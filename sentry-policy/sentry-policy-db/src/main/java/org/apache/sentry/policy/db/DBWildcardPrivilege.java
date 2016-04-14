/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// copied from apache shiro

package org.apache.sentry.policy.db;

import java.util.List;

import org.apache.sentry.core.common.utils.PathUtils;
import org.apache.sentry.core.model.db.AccessConstants;
import org.apache.sentry.core.model.db.DBModelAuthorizable.AuthorizableType;
import org.apache.sentry.policy.common.PolicyConstants;
import org.apache.sentry.policy.common.Privilege;
import org.apache.sentry.policy.common.PrivilegeFactory;
import org.apache.sentry.policy.common.KeyValue;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

// XXX this class is made ugly by the fact that Action is not a Authorizable.
public class DBWildcardPrivilege implements Privilege {

  private final ImmutableList<KeyValue> parts;

  private final Boolean isDenyPrivilege;

  public DBWildcardPrivilege(String wildcardString) {
    wildcardString = Strings.nullToEmpty(wildcardString).trim();
    boolean isDenyPrivilege = false;
    if (wildcardString.isEmpty()) {
      throw new IllegalArgumentException("Wildcard string cannot be null or empty.");
    }
    List<KeyValue>parts = Lists.newArrayList();
    for (String authorizable : PolicyConstants.AUTHORIZABLE_SPLITTER.trimResults().split(
        wildcardString)) {
      if (authorizable.isEmpty()) {
        throw new IllegalArgumentException("Privilege '" + wildcardString + "' has an empty section");
      }
      KeyValue kv = new KeyValue(authorizable);
      if (PolicyConstants.DENY_PRIVILEGE_KEY.equals(kv.getKey())) {
        isDenyPrivilege = isDenyPrivilege || Boolean.parseBoolean(kv.getValue());
      } else {
        parts.add(kv);
      }
    }
    if (parts.isEmpty()) {
      throw new AssertionError("Should never occur: " + wildcardString);
    }
    this.parts = ImmutableList.copyOf(parts);
    this.isDenyPrivilege = isDenyPrivilege;
  }


  @Override
  public boolean implies(Privilege p) {
    return impliesCore(p);
  }

  public boolean impliesCore(Privilege p) {
    // By default only supports comparisons with other DBWildcardPermissions
    if (!(p instanceof DBWildcardPrivilege)) {
      return false;
    }

    DBWildcardPrivilege wp = (DBWildcardPrivilege) p;

    List<KeyValue> otherParts = wp.parts;
    if(equals(wp)) {
      return true;
    }
    int index = 0;
    for (KeyValue otherPart : otherParts) {
      // If this privilege has less parts than the other privilege, everything
      // after the number of parts contained
      // in this privilege is automatically implied, so return true
      if (parts.size() - 1 < index) {
        return true;
      } else {
        KeyValue part = parts.get(index);
        // Support for action inheritance from parent to child (eg. Db -> Table)
        if (part.getKey().equalsIgnoreCase("action") && !(otherPart.getKey().equalsIgnoreCase("action"))) {
          continue;
        }
        // are the keys even equal
        if(!part.getKey().equalsIgnoreCase(otherPart.getKey())) {
          return false;
        }
        if (!impliesKeyValue(part, otherPart)) {
          return false;
        }
        index++;
      }
    }
    // If this privilege has more parts than
    // the other parts, only imply it if
    // all of the other parts are wildcards
    for (; index < parts.size(); index++) {
      KeyValue part = parts.get(index);
      if (!part.getValue().equals(AccessConstants.ALL)) {
        return false;
      }
    }

    return true;
  }

  private boolean impliesKeyValue(KeyValue policyPart, KeyValue requestPart) {
    Preconditions.checkState(policyPart.getKey().equalsIgnoreCase(requestPart.getKey()),
        "Please report, this method should not be called with two different keys");
    if(policyPart.getValue().equals(AccessConstants.ALL) ||
        policyPart.getValue().equalsIgnoreCase("ALL")) {
      return true;
    } else if (!PolicyConstants.PRIVILEGE_NAME.equalsIgnoreCase(policyPart.getKey())
        && AccessConstants.ALL.equalsIgnoreCase(requestPart.getValue())) {
      /* privilege request is to match with any object of given type */
      return true;
    } else if (!PolicyConstants.PRIVILEGE_NAME.equalsIgnoreCase(policyPart.getKey())
        && AccessConstants.SOME.equalsIgnoreCase(requestPart.getValue())) {
      /* privilege request is to match with any object of given type */
      return true;
    } else if(policyPart.getKey().equalsIgnoreCase(AuthorizableType.URI.name())) {
      return impliesURI(policyPart.getValue(), requestPart.getValue());
    }
    return policyPart.equals(requestPart);
  }

  @VisibleForTesting
  protected static boolean impliesURI(String privilege, String request) {
    return PathUtils.impliesURI(privilege, request);
  }

  @Override
  public String toString() {
    String permission = PolicyConstants.AUTHORIZABLE_JOINER.join(parts);
    if (isDenyPrivilege) {
      return PolicyConstants.AUTHORIZABLE_JOINER.join(permission, new KeyValue(
          PolicyConstants.DENY_PRIVILEGE_KEY, "true"));
    }
    return permission;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof DBWildcardPrivilege) {
      DBWildcardPrivilege wp = (DBWildcardPrivilege) o;
      return parts.equals(wp.parts);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return parts.hashCode();
  }

  public static class DBWildcardPrivilegeFactory implements PrivilegeFactory {
    @Override
    public Privilege createPrivilege(String privilege) {
      return new DBWildcardPrivilege(privilege);
    }
  }

  @Override
  public boolean isDenyPrivilege() {
    return isDenyPrivilege;
  }
}

/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.provider.db.service.thrift;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TListSentryPrivilegesByAuthRequest implements org.apache.thrift.TBase<TListSentryPrivilegesByAuthRequest, TListSentryPrivilegesByAuthRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TListSentryPrivilegesByAuthRequest");

  private static final org.apache.thrift.protocol.TField PROTOCOL_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("protocol_version", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField REQUESTOR_USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("requestorUserName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHORIZABLE_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("authorizableSet", org.apache.thrift.protocol.TType.SET, (short)3);
  private static final org.apache.thrift.protocol.TField GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("groups", org.apache.thrift.protocol.TType.SET, (short)4);
  private static final org.apache.thrift.protocol.TField ROLE_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("roleSet", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TListSentryPrivilegesByAuthRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TListSentryPrivilegesByAuthRequestTupleSchemeFactory());
  }

  private int protocol_version; // required
  private String requestorUserName; // required
  private Set<TSentryAuthorizable> authorizableSet; // required
  private Set<String> groups; // optional
  private TSentryActiveRoleSet roleSet; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROTOCOL_VERSION((short)1, "protocol_version"),
    REQUESTOR_USER_NAME((short)2, "requestorUserName"),
    AUTHORIZABLE_SET((short)3, "authorizableSet"),
    GROUPS((short)4, "groups"),
    ROLE_SET((short)5, "roleSet");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PROTOCOL_VERSION
          return PROTOCOL_VERSION;
        case 2: // REQUESTOR_USER_NAME
          return REQUESTOR_USER_NAME;
        case 3: // AUTHORIZABLE_SET
          return AUTHORIZABLE_SET;
        case 4: // GROUPS
          return GROUPS;
        case 5: // ROLE_SET
          return ROLE_SET;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PROTOCOL_VERSION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.GROUPS,_Fields.ROLE_SET};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROTOCOL_VERSION, new org.apache.thrift.meta_data.FieldMetaData("protocol_version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.REQUESTOR_USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("requestorUserName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHORIZABLE_SET, new org.apache.thrift.meta_data.FieldMetaData("authorizableSet", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSentryAuthorizable.class))));
    tmpMap.put(_Fields.GROUPS, new org.apache.thrift.meta_data.FieldMetaData("groups", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.ROLE_SET, new org.apache.thrift.meta_data.FieldMetaData("roleSet", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSentryActiveRoleSet.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TListSentryPrivilegesByAuthRequest.class, metaDataMap);
  }

  public TListSentryPrivilegesByAuthRequest() {
    this.protocol_version = 2;

  }

  public TListSentryPrivilegesByAuthRequest(
    int protocol_version,
    String requestorUserName,
    Set<TSentryAuthorizable> authorizableSet)
  {
    this();
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
    this.requestorUserName = requestorUserName;
    this.authorizableSet = authorizableSet;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TListSentryPrivilegesByAuthRequest(TListSentryPrivilegesByAuthRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.protocol_version = other.protocol_version;
    if (other.isSetRequestorUserName()) {
      this.requestorUserName = other.requestorUserName;
    }
    if (other.isSetAuthorizableSet()) {
      Set<TSentryAuthorizable> __this__authorizableSet = new HashSet<TSentryAuthorizable>();
      for (TSentryAuthorizable other_element : other.authorizableSet) {
        __this__authorizableSet.add(new TSentryAuthorizable(other_element));
      }
      this.authorizableSet = __this__authorizableSet;
    }
    if (other.isSetGroups()) {
      Set<String> __this__groups = new HashSet<String>();
      for (String other_element : other.groups) {
        __this__groups.add(other_element);
      }
      this.groups = __this__groups;
    }
    if (other.isSetRoleSet()) {
      this.roleSet = new TSentryActiveRoleSet(other.roleSet);
    }
  }

  public TListSentryPrivilegesByAuthRequest deepCopy() {
    return new TListSentryPrivilegesByAuthRequest(this);
  }

  @Override
  public void clear() {
    this.protocol_version = 2;

    this.requestorUserName = null;
    this.authorizableSet = null;
    this.groups = null;
    this.roleSet = null;
  }

  public int getProtocol_version() {
    return this.protocol_version;
  }

  public void setProtocol_version(int protocol_version) {
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
  }

  public void unsetProtocol_version() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  /** Returns true if field protocol_version is set (has been assigned a value) and false otherwise */
  public boolean isSetProtocol_version() {
    return EncodingUtils.testBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  public void setProtocol_versionIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID, value);
  }

  public String getRequestorUserName() {
    return this.requestorUserName;
  }

  public void setRequestorUserName(String requestorUserName) {
    this.requestorUserName = requestorUserName;
  }

  public void unsetRequestorUserName() {
    this.requestorUserName = null;
  }

  /** Returns true if field requestorUserName is set (has been assigned a value) and false otherwise */
  public boolean isSetRequestorUserName() {
    return this.requestorUserName != null;
  }

  public void setRequestorUserNameIsSet(boolean value) {
    if (!value) {
      this.requestorUserName = null;
    }
  }

  public int getAuthorizableSetSize() {
    return (this.authorizableSet == null) ? 0 : this.authorizableSet.size();
  }

  public java.util.Iterator<TSentryAuthorizable> getAuthorizableSetIterator() {
    return (this.authorizableSet == null) ? null : this.authorizableSet.iterator();
  }

  public void addToAuthorizableSet(TSentryAuthorizable elem) {
    if (this.authorizableSet == null) {
      this.authorizableSet = new HashSet<TSentryAuthorizable>();
    }
    this.authorizableSet.add(elem);
  }

  public Set<TSentryAuthorizable> getAuthorizableSet() {
    return this.authorizableSet;
  }

  public void setAuthorizableSet(Set<TSentryAuthorizable> authorizableSet) {
    this.authorizableSet = authorizableSet;
  }

  public void unsetAuthorizableSet() {
    this.authorizableSet = null;
  }

  /** Returns true if field authorizableSet is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthorizableSet() {
    return this.authorizableSet != null;
  }

  public void setAuthorizableSetIsSet(boolean value) {
    if (!value) {
      this.authorizableSet = null;
    }
  }

  public int getGroupsSize() {
    return (this.groups == null) ? 0 : this.groups.size();
  }

  public java.util.Iterator<String> getGroupsIterator() {
    return (this.groups == null) ? null : this.groups.iterator();
  }

  public void addToGroups(String elem) {
    if (this.groups == null) {
      this.groups = new HashSet<String>();
    }
    this.groups.add(elem);
  }

  public Set<String> getGroups() {
    return this.groups;
  }

  public void setGroups(Set<String> groups) {
    this.groups = groups;
  }

  public void unsetGroups() {
    this.groups = null;
  }

  /** Returns true if field groups is set (has been assigned a value) and false otherwise */
  public boolean isSetGroups() {
    return this.groups != null;
  }

  public void setGroupsIsSet(boolean value) {
    if (!value) {
      this.groups = null;
    }
  }

  public TSentryActiveRoleSet getRoleSet() {
    return this.roleSet;
  }

  public void setRoleSet(TSentryActiveRoleSet roleSet) {
    this.roleSet = roleSet;
  }

  public void unsetRoleSet() {
    this.roleSet = null;
  }

  /** Returns true if field roleSet is set (has been assigned a value) and false otherwise */
  public boolean isSetRoleSet() {
    return this.roleSet != null;
  }

  public void setRoleSetIsSet(boolean value) {
    if (!value) {
      this.roleSet = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PROTOCOL_VERSION:
      if (value == null) {
        unsetProtocol_version();
      } else {
        setProtocol_version((Integer)value);
      }
      break;

    case REQUESTOR_USER_NAME:
      if (value == null) {
        unsetRequestorUserName();
      } else {
        setRequestorUserName((String)value);
      }
      break;

    case AUTHORIZABLE_SET:
      if (value == null) {
        unsetAuthorizableSet();
      } else {
        setAuthorizableSet((Set<TSentryAuthorizable>)value);
      }
      break;

    case GROUPS:
      if (value == null) {
        unsetGroups();
      } else {
        setGroups((Set<String>)value);
      }
      break;

    case ROLE_SET:
      if (value == null) {
        unsetRoleSet();
      } else {
        setRoleSet((TSentryActiveRoleSet)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PROTOCOL_VERSION:
      return Integer.valueOf(getProtocol_version());

    case REQUESTOR_USER_NAME:
      return getRequestorUserName();

    case AUTHORIZABLE_SET:
      return getAuthorizableSet();

    case GROUPS:
      return getGroups();

    case ROLE_SET:
      return getRoleSet();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PROTOCOL_VERSION:
      return isSetProtocol_version();
    case REQUESTOR_USER_NAME:
      return isSetRequestorUserName();
    case AUTHORIZABLE_SET:
      return isSetAuthorizableSet();
    case GROUPS:
      return isSetGroups();
    case ROLE_SET:
      return isSetRoleSet();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TListSentryPrivilegesByAuthRequest)
      return this.equals((TListSentryPrivilegesByAuthRequest)that);
    return false;
  }

  public boolean equals(TListSentryPrivilegesByAuthRequest that) {
    if (that == null)
      return false;

    boolean this_present_protocol_version = true;
    boolean that_present_protocol_version = true;
    if (this_present_protocol_version || that_present_protocol_version) {
      if (!(this_present_protocol_version && that_present_protocol_version))
        return false;
      if (this.protocol_version != that.protocol_version)
        return false;
    }

    boolean this_present_requestorUserName = true && this.isSetRequestorUserName();
    boolean that_present_requestorUserName = true && that.isSetRequestorUserName();
    if (this_present_requestorUserName || that_present_requestorUserName) {
      if (!(this_present_requestorUserName && that_present_requestorUserName))
        return false;
      if (!this.requestorUserName.equals(that.requestorUserName))
        return false;
    }

    boolean this_present_authorizableSet = true && this.isSetAuthorizableSet();
    boolean that_present_authorizableSet = true && that.isSetAuthorizableSet();
    if (this_present_authorizableSet || that_present_authorizableSet) {
      if (!(this_present_authorizableSet && that_present_authorizableSet))
        return false;
      if (!this.authorizableSet.equals(that.authorizableSet))
        return false;
    }

    boolean this_present_groups = true && this.isSetGroups();
    boolean that_present_groups = true && that.isSetGroups();
    if (this_present_groups || that_present_groups) {
      if (!(this_present_groups && that_present_groups))
        return false;
      if (!this.groups.equals(that.groups))
        return false;
    }

    boolean this_present_roleSet = true && this.isSetRoleSet();
    boolean that_present_roleSet = true && that.isSetRoleSet();
    if (this_present_roleSet || that_present_roleSet) {
      if (!(this_present_roleSet && that_present_roleSet))
        return false;
      if (!this.roleSet.equals(that.roleSet))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_protocol_version = true;
    builder.append(present_protocol_version);
    if (present_protocol_version)
      builder.append(protocol_version);

    boolean present_requestorUserName = true && (isSetRequestorUserName());
    builder.append(present_requestorUserName);
    if (present_requestorUserName)
      builder.append(requestorUserName);

    boolean present_authorizableSet = true && (isSetAuthorizableSet());
    builder.append(present_authorizableSet);
    if (present_authorizableSet)
      builder.append(authorizableSet);

    boolean present_groups = true && (isSetGroups());
    builder.append(present_groups);
    if (present_groups)
      builder.append(groups);

    boolean present_roleSet = true && (isSetRoleSet());
    builder.append(present_roleSet);
    if (present_roleSet)
      builder.append(roleSet);

    return builder.toHashCode();
  }

  public int compareTo(TListSentryPrivilegesByAuthRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TListSentryPrivilegesByAuthRequest typedOther = (TListSentryPrivilegesByAuthRequest)other;

    lastComparison = Boolean.valueOf(isSetProtocol_version()).compareTo(typedOther.isSetProtocol_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProtocol_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.protocol_version, typedOther.protocol_version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRequestorUserName()).compareTo(typedOther.isSetRequestorUserName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequestorUserName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.requestorUserName, typedOther.requestorUserName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthorizableSet()).compareTo(typedOther.isSetAuthorizableSet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthorizableSet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authorizableSet, typedOther.authorizableSet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroups()).compareTo(typedOther.isSetGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groups, typedOther.groups);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRoleSet()).compareTo(typedOther.isSetRoleSet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoleSet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roleSet, typedOther.roleSet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TListSentryPrivilegesByAuthRequest(");
    boolean first = true;

    sb.append("protocol_version:");
    sb.append(this.protocol_version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("requestorUserName:");
    if (this.requestorUserName == null) {
      sb.append("null");
    } else {
      sb.append(this.requestorUserName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("authorizableSet:");
    if (this.authorizableSet == null) {
      sb.append("null");
    } else {
      sb.append(this.authorizableSet);
    }
    first = false;
    if (isSetGroups()) {
      if (!first) sb.append(", ");
      sb.append("groups:");
      if (this.groups == null) {
        sb.append("null");
      } else {
        sb.append(this.groups);
      }
      first = false;
    }
    if (isSetRoleSet()) {
      if (!first) sb.append(", ");
      sb.append("roleSet:");
      if (this.roleSet == null) {
        sb.append("null");
      } else {
        sb.append(this.roleSet);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetProtocol_version()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'protocol_version' is unset! Struct:" + toString());
    }

    if (!isSetRequestorUserName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'requestorUserName' is unset! Struct:" + toString());
    }

    if (!isSetAuthorizableSet()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'authorizableSet' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (roleSet != null) {
      roleSet.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TListSentryPrivilegesByAuthRequestStandardSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesByAuthRequestStandardScheme getScheme() {
      return new TListSentryPrivilegesByAuthRequestStandardScheme();
    }
  }

  private static class TListSentryPrivilegesByAuthRequestStandardScheme extends StandardScheme<TListSentryPrivilegesByAuthRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TListSentryPrivilegesByAuthRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROTOCOL_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.protocol_version = iprot.readI32();
              struct.setProtocol_versionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REQUESTOR_USER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.requestorUserName = iprot.readString();
              struct.setRequestorUserNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHORIZABLE_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set130 = iprot.readSetBegin();
                struct.authorizableSet = new HashSet<TSentryAuthorizable>(2*_set130.size);
                for (int _i131 = 0; _i131 < _set130.size; ++_i131)
                {
                  TSentryAuthorizable _elem132; // required
                  _elem132 = new TSentryAuthorizable();
                  _elem132.read(iprot);
                  struct.authorizableSet.add(_elem132);
                }
                iprot.readSetEnd();
              }
              struct.setAuthorizableSetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set133 = iprot.readSetBegin();
                struct.groups = new HashSet<String>(2*_set133.size);
                for (int _i134 = 0; _i134 < _set133.size; ++_i134)
                {
                  String _elem135; // required
                  _elem135 = iprot.readString();
                  struct.groups.add(_elem135);
                }
                iprot.readSetEnd();
              }
              struct.setGroupsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ROLE_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.roleSet = new TSentryActiveRoleSet();
              struct.roleSet.read(iprot);
              struct.setRoleSetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TListSentryPrivilegesByAuthRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PROTOCOL_VERSION_FIELD_DESC);
      oprot.writeI32(struct.protocol_version);
      oprot.writeFieldEnd();
      if (struct.requestorUserName != null) {
        oprot.writeFieldBegin(REQUESTOR_USER_NAME_FIELD_DESC);
        oprot.writeString(struct.requestorUserName);
        oprot.writeFieldEnd();
      }
      if (struct.authorizableSet != null) {
        oprot.writeFieldBegin(AUTHORIZABLE_SET_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.authorizableSet.size()));
          for (TSentryAuthorizable _iter136 : struct.authorizableSet)
          {
            _iter136.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.groups != null) {
        if (struct.isSetGroups()) {
          oprot.writeFieldBegin(GROUPS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.groups.size()));
            for (String _iter137 : struct.groups)
            {
              oprot.writeString(_iter137);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.roleSet != null) {
        if (struct.isSetRoleSet()) {
          oprot.writeFieldBegin(ROLE_SET_FIELD_DESC);
          struct.roleSet.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TListSentryPrivilegesByAuthRequestTupleSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesByAuthRequestTupleScheme getScheme() {
      return new TListSentryPrivilegesByAuthRequestTupleScheme();
    }
  }

  private static class TListSentryPrivilegesByAuthRequestTupleScheme extends TupleScheme<TListSentryPrivilegesByAuthRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesByAuthRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.protocol_version);
      oprot.writeString(struct.requestorUserName);
      {
        oprot.writeI32(struct.authorizableSet.size());
        for (TSentryAuthorizable _iter138 : struct.authorizableSet)
        {
          _iter138.write(oprot);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetGroups()) {
        optionals.set(0);
      }
      if (struct.isSetRoleSet()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetGroups()) {
        {
          oprot.writeI32(struct.groups.size());
          for (String _iter139 : struct.groups)
          {
            oprot.writeString(_iter139);
          }
        }
      }
      if (struct.isSetRoleSet()) {
        struct.roleSet.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesByAuthRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.protocol_version = iprot.readI32();
      struct.setProtocol_versionIsSet(true);
      struct.requestorUserName = iprot.readString();
      struct.setRequestorUserNameIsSet(true);
      {
        org.apache.thrift.protocol.TSet _set140 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.authorizableSet = new HashSet<TSentryAuthorizable>(2*_set140.size);
        for (int _i141 = 0; _i141 < _set140.size; ++_i141)
        {
          TSentryAuthorizable _elem142; // required
          _elem142 = new TSentryAuthorizable();
          _elem142.read(iprot);
          struct.authorizableSet.add(_elem142);
        }
      }
      struct.setAuthorizableSetIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set143 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.groups = new HashSet<String>(2*_set143.size);
          for (int _i144 = 0; _i144 < _set143.size; ++_i144)
          {
            String _elem145; // required
            _elem145 = iprot.readString();
            struct.groups.add(_elem145);
          }
        }
        struct.setGroupsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.roleSet = new TSentryActiveRoleSet();
        struct.roleSet.read(iprot);
        struct.setRoleSetIsSet(true);
      }
    }
  }

}


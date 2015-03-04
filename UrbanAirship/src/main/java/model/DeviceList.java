package model;

public class DeviceList
{
  private String[] tags;
  private String tag;
  private String alias;
  private String active;
  private String created;
  private String device_token;
  private String cus_num;
  private String device_uid;
  private String apid;
  private String c2dm_registration_id;
  private String device_type;
  private String device_key;

  public String[] getTags()
  {
    return this.tags;
  }
  public void setTags(String[] tags) {
    this.tags = tags;
  }
  public String getTag() {
    return this.tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }
  public String getAlias() {
    return this.alias;
  }
  public void setAlias(String alias) {
    this.alias = alias;
  }
  public String getActive() {
    return this.active;
  }
  public void setActive(String active) {
    this.active = active;
  }
  public String getCreated() {
    return this.created;
  }
  public void setCreated(String created) {
    this.created = created;
  }
  public String getDevice_token() {
    return this.device_token;
  }
  public void setDevice_token(String device_token) {
    this.device_token = device_token;
  }
  public String getCus_num() {
    return this.cus_num;
  }
  public void setCus_num(String cus_num) {
    this.cus_num = cus_num;
  }
  public String getDevice_uid() {
    return this.device_uid;
  }
  public void setDevice_uid(String device_uid) {
    this.device_uid = device_uid;
  }
  public String getApid() {
    return this.apid;
  }
  public void setApid(String apid) {
    this.apid = apid;
  }
  public String getC2dm_registration_id() {
    return this.c2dm_registration_id;
  }
  public void setC2dm_registration_id(String c2dm_registration_id) {
    this.c2dm_registration_id = c2dm_registration_id;
  }
  public String getDevice_type() {
    return this.device_type;
  }
  public void setDevice_type(String device_type) {
    this.device_type = device_type;
  }
  public String getDevice_key() {
    return this.device_key;
  }
  public void setDevice_key(String device_key) {
    this.device_key = device_key;
  }
}
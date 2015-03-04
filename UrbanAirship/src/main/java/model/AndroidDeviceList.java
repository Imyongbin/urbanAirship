package model;

import java.util.List;

public class AndroidDeviceList
{
  private int active_device_tokens_count;
  private int device_tokens_count;
  private List<DeviceList> apids;

  public int getActive_device_tokens_count()
  {
    return this.active_device_tokens_count;
  }
  public void setActive_device_tokens_count(int active_device_tokens_count) {
    this.active_device_tokens_count = active_device_tokens_count;
  }
  public int getDevice_tokens_count() {
    return this.device_tokens_count;
  }
  public void setDevice_tokens_count(int device_tokens_count) {
    this.device_tokens_count = device_tokens_count;
  }
  public List<DeviceList> getApids() {
    return this.apids;
  }
  public void setApids(List<DeviceList> apids) {
    this.apids = apids;
  }
}
package model;

import java.util.List;

public class IosDeviceList
{
  private int active_device_tokens_count;
  private int device_tokens_count;
  private List<DeviceList> device_tokens;

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
  public List<DeviceList> getDevice_tokens() {
    return this.device_tokens;
  }
  public void setDevice_tokens(List<DeviceList> device_tokens) {
    this.device_tokens = device_tokens;
  }
}
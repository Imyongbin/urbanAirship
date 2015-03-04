package service;

import java.util.List;
import model.AndroidDeviceList;
import model.DeviceList;
import model.IosDeviceList;

public abstract interface DeviceListService
{
  public abstract IosDeviceList getIosDeviceList();

  public abstract AndroidDeviceList getAndroidDeviceList();

  public abstract int deleteDeviceList();

  public abstract List<DeviceList> selectDeviceList();

  public abstract int countDeviceList();

  public abstract int countActiveDeviceList();
}
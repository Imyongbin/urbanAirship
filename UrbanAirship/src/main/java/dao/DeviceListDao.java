package dao;

import java.util.List;
import model.DeviceList;

public abstract interface DeviceListDao
{
  public abstract int insertIosDeviceList(DeviceList paramDeviceList);

  public abstract int insertAndroidDeviceList(DeviceList paramDeviceList);

  public abstract int deleteDeviceList();

  public abstract List<DeviceList> selectDeviceList();

  public abstract int countDeviceList();

  public abstract int countActiveDeviceList();
}
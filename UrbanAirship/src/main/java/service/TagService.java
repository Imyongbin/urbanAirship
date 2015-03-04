package service;

import java.util.List;
import model.DeviceList;
import model.Target;

public abstract interface TagService
{
  public abstract int setAndroidTag(String paramString, List<DeviceList> paramList);

  public abstract int setIosTag(String paramString, List<DeviceList> paramList);

  public abstract List<DeviceList> selectDeviceList(Target paramTarget);

  public abstract List<Target> selectCamp();
}
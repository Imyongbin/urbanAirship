package dao;

import java.util.List;

import model.DeviceList;
import model.Target;

public interface TagDao  {
	public abstract List<DeviceList> selectDeviceList(Target target);
	public abstract List<Target> selectCamp();

}
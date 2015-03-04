package dao;

import java.util.List;

import model.DeviceList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("testDao")
public class DeviceListDaoImpl
  implements DeviceListDao
{

  @Autowired
  SqlMapClientTemplate sqlMapClientTemplate;

  public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate)
  {
    this.sqlMapClientTemplate = sqlMapClientTemplate;
  }

  public int insertIosDeviceList(DeviceList test) {
    return this.sqlMapClientTemplate.update("device.insertIosDeviceList", test);
  }

  public int insertAndroidDeviceList(DeviceList test) {
    return this.sqlMapClientTemplate.update("device.insertAndroidDeviceList", test);
  }

  public int deleteDeviceList() {
    return this.sqlMapClientTemplate.delete("device.deleteDeviceList");
  }

  public List<DeviceList> selectDeviceList()
  {
    return this.sqlMapClientTemplate.queryForList("device.selectDeviceList");
  }

  public int countDeviceList() {
    return ((Integer)this.sqlMapClientTemplate.queryForObject("device.countDeviceList")).intValue();
  }

  public int countActiveDeviceList() {
    return ((Integer)this.sqlMapClientTemplate.queryForObject("device.countActiveDeviceList")).intValue();
  }
}
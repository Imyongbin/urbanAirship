package service;

import common.util.HttpClientUtil;
import dao.DeviceListDao;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import model.AndroidDeviceList;
import model.DeviceList;
import model.IosDeviceList;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceListServiceImpl
  implements DeviceListService
{

  @Autowired
  private DeviceListDao testDao;
  private static final String ANDROID_APPKEY = "h4b5HQ6QSOK3QlOFkXhI8g";
  private static final String ANDROID_SECRET = "NqLl8nRsS72OtgYytbFcVg";
  private static final String ANDROID_MASTERSECRET = "mF5lWarfQFKWBWAtkwWYUA";
  private static final String IOS_APPKEY = "g-kj6CMYRWSzPsSR2q0y7A";
  private static final String IOS_SECRET = "67g-3EfvSVCCX_j0_EG-vw";
  private static final String IOS_MASTERSECRET = "OCre5CPLT-yyCjQ8NMHEEA";

  public IosDeviceList getIosDeviceList()
  {
    String strResponse = "";
    HttpClientUtil httpUtil = new HttpClientUtil("https://go.urbanairship.com/api/device_tokens/");

    httpUtil.setAppKey("g-kj6CMYRWSzPsSR2q0y7A");
    httpUtil.setSecret("OCre5CPLT-yyCjQ8NMHEEA");

    strResponse = httpUtil.execute();
    System.out.println(strResponse);

    ObjectMapper mapper = null;
    IosDeviceList list = new IosDeviceList();
    try {
      mapper = new ObjectMapper();
      list = (IosDeviceList)mapper.readValue(strResponse, IosDeviceList.class);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    String alias = "";
    DeviceList test = null;
    try {
      for (int i = 0; i < list.getDevice_tokens().size(); i++) {
        test = new DeviceList();
        test = (DeviceList)list.getDevice_tokens().get(i);
        test.setTag(Arrays.toString(test.getTags()));
        alias = test.getAlias();

        for (String pair : alias.split("&")) {
          int eq = pair.indexOf("=");
          if (eq >= 0) {
            if (pair.indexOf("CNO") > -1) test.setCus_num(pair.substring(eq + 1));
            if (pair.indexOf("DID") <= -1) continue; test.setDevice_uid(pair.substring(eq + 1));
          }
        }
        this.testDao.insertIosDeviceList(test);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public AndroidDeviceList getAndroidDeviceList() {
    String strResponse = "";
    HttpClientUtil httpUtil = new HttpClientUtil("https://go.urbanairship.com/api/apids/");

    httpUtil.setAppKey("h4b5HQ6QSOK3QlOFkXhI8g");
    httpUtil.setSecret("mF5lWarfQFKWBWAtkwWYUA");

    strResponse = httpUtil.execute();
    System.out.println(strResponse);
    ObjectMapper mapper = null;
    AndroidDeviceList list = new AndroidDeviceList();
    try {
      mapper = new ObjectMapper();
      list = (AndroidDeviceList)mapper.readValue(strResponse, AndroidDeviceList.class);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    String alias = "";
    DeviceList test = null;
    try {
      for (int i = 0; i < list.getApids().size(); i++) {
        test = new DeviceList();
        test = (DeviceList)list.getApids().get(i);
        test.setTag(Arrays.toString(test.getTags()));
        alias = test.getAlias();
        if (alias != null) {
          for (String pair : alias.split("&")) {
            int eq = pair.indexOf("=");
            if (eq >= 0) {
              if (pair.indexOf("CNO") > -1) test.setCus_num(pair.substring(eq + 1));
              if (pair.indexOf("DID") <= -1) continue; test.setDevice_uid(pair.substring(eq + 1));
            }
          }
          this.testDao.insertAndroidDeviceList(test);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int deleteDeviceList()
  {
    return this.testDao.deleteDeviceList();
  }

  public List<DeviceList> selectDeviceList() {
    return this.testDao.selectDeviceList();
  }

  public int countDeviceList() {
    return this.testDao.countDeviceList();
  }

  public int countActiveDeviceList() {
    return this.testDao.countActiveDeviceList();
  }
}
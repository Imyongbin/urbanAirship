package service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.DeviceList;
import model.Target;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.HttpClientUtil;

import dao.TagDao;

@Service
public class TagServiceImpl
  implements TagService
{

  @Autowired
  private TagDao tagDao;
  private static final String ANDROID_APPKEY 		= "h4b5HQ6QSOK3QlOFkXhI8g";
  private static final String ANDROID_SECRET 		= "NqLl8nRsS72OtgYytbFcVg";
  private static final String ANDROID_MASTERSECRET 	= "mF5lWarfQFKWBWAtkwWYUA";
  private static final String IOS_APPKEY 			= "g-kj6CMYRWSzPsSR2q0y7A";
  private static final String IOS_SECRET 			= "67g-3EfvSVCCX_j0_EG-vw";
  private static final String IOS_MASTERSECRET 		= "OCre5CPLT-yyCjQ8NMHEEA";

  public int setAndroidTag(String tag, List<DeviceList> deviceList)
  {
    String strResponse = "";
    try {
      tag = URLEncoder.encode(tag, "UTF-8");
    }
    catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }
    HttpClientUtil httpUtil = new HttpClientUtil("https://go.urbanairship.com/api/tags/" + tag);

    httpUtil.setAppKey("h4b5HQ6QSOK3QlOFkXhI8g");
    httpUtil.setSecret("mF5lWarfQFKWBWAtkwWYUA");

    DeviceList device = new DeviceList();
    HashMap map = new HashMap();
    HashMap map2 = new HashMap();
    List android = new ArrayList();

    for (int i = 0; i < deviceList.size(); i++) {
      device = (DeviceList)deviceList.get(i);
      if (device.getDevice_type().equals("ANDROID")) {
        android.add(device.getDevice_key());
      }
    }

    map2.put("add", android);
    map.put("apids", map2);

    String reqBody = "";
    ObjectMapper mapper = null;
    try {
      mapper = new ObjectMapper();
      reqBody = mapper.writeValueAsString(map);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    httpUtil.setReqBody(reqBody);
    httpUtil.setMethodType(1);
    strResponse = httpUtil.execute();
    int ret = 0;
    if (strResponse.equals("")) ret = 1;
    return ret;
  }

  public int setIosTag(String tag, List<DeviceList> deviceList) {
    String strResponse = "";
    try {
      tag = URLEncoder.encode(tag, "UTF-8");
    }
    catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }
    HttpClientUtil httpUtil = new HttpClientUtil("https://go.urbanairship.com/api/tags/" + tag);
    httpUtil.setAppKey("g-kj6CMYRWSzPsSR2q0y7A");
    httpUtil.setSecret("OCre5CPLT-yyCjQ8NMHEEA");

    DeviceList device = new DeviceList();
    List ios = new ArrayList();
    HashMap map = new HashMap();
    HashMap map2 = new HashMap();
    for (int i = 0; i < deviceList.size(); i++) {
      device = (DeviceList)deviceList.get(i);
      if (device.getDevice_type().equals("IOS")) {
        ios.add(device.getDevice_key());
      }
    }

    map2.put("add", ios);
    map.put("device_tokens", map2);
    String reqBody = "";
    ObjectMapper mapper = null;
    try {
      mapper = new ObjectMapper();
      reqBody = mapper.writeValueAsString(map);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    httpUtil.setReqBody(reqBody);
    httpUtil.setMethodType(1);
    strResponse = httpUtil.execute();
    int ret = 0;
    if (strResponse.equals("")) ret = 1;
    return ret;
  }

  public List<DeviceList> selectDeviceList(Target target) {
    return this.tagDao.selectDeviceList(target);
  }

  public List<Target> selectCamp() {
    return this.tagDao.selectCamp();
  }
}
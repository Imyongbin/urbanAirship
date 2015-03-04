package service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.DeviceList;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.HttpClientUtil;

import dao.TagDao;

@Service
public class SendPushServiceImpl
  implements SendPushService
{

  @Autowired
  private TagDao tagDao;
  private static final String ANDROID_APPKEY = "h4b5HQ6QSOK3QlOFkXhI8g";
  private static final String ANDROID_SECRET = "NqLl8nRsS72OtgYytbFcVg";
  private static final String ANDROID_MASTERSECRET = "mF5lWarfQFKWBWAtkwWYUA";
  private static final String IOS_APPKEY = "g-kj6CMYRWSzPsSR2q0y7A";
  private static final String IOS_SECRET = "67g-3EfvSVCCX_j0_EG-vw";
  private static final String IOS_MASTERSECRET = "OCre5CPLT-yyCjQ8NMHEEA";

  public int sendAndroid(String tag, String image, String title, String message)
  {
    String strResponse = "";
    HttpClientUtil httpUtil = new HttpClientUtil("https://go.urbanairship.com/api/push/");

    httpUtil.setAppKey("h4b5HQ6QSOK3QlOFkXhI8g");
    httpUtil.setSecret("mF5lWarfQFKWBWAtkwWYUA");

    HashMap map = new HashMap();
    HashMap tagMap = new HashMap();
    HashMap notiMap = new HashMap();
    HashMap styMap = new HashMap();
    HashMap andMap = new HashMap();

    tagMap.put("tag", tag);
    styMap.put("type", "big_picture");
    styMap.put("big_picture", image);
    styMap.put("title", title);
    styMap.put("summary", message);
    andMap.put("style", styMap);
    notiMap.put("android", andMap);
    notiMap.put("alert", message);
    String[] device_types = { "android" };

    map.put("audience", tagMap);
    map.put("device_types", device_types);
    map.put("notification", notiMap);
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

  public int sendIos(String tag, String image, String title, String message) {
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
}
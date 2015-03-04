package common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class HttpClientUtil
{
  private static final int GETTYPE = 0;
  private static final int POSTTYPE = 1;
  private static final int PUTTYPE = 2;
  private static final int DELETETYPE = 3;
  private String urlStr = "";
  private int methodType = 0;
  private String appKey = "";
  private String secret = "";
  private String reqBody;

  public HttpClientUtil(String urlStr)
  {
    this.urlStr = urlStr;
  }

  public void setMethodType(int methodType) {
    this.methodType = methodType;
  }

  public int getMethodType() {
    return this.methodType;
  }

  public void setAppKey(String appKey)
  {
    this.appKey = appKey;
  }

  public String getAppKey() {
    return this.appKey;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getSecret() {
    return this.secret;
  }

  public String getReqBody() {
    return this.reqBody;
  }

  public void setReqBody(String reqBody) {
    this.reqBody = reqBody;
  }

  public String execute() {
    String strResponse = "";
    HttpClient httpclient = new HttpClient();
    Credentials credentials = new UsernamePasswordCredentials(this.appKey, this.secret);
    httpclient.getState().setCredentials(AuthScope.ANY, credentials);
    PostMethod httpPost = null;
    PutMethod httpPut = null;
    GetMethod httpget = null;
    if (methodType == GETTYPE) {
      httpget = new GetMethod(this.urlStr);
      httpget.addRequestHeader("Content-Type", "application/json");
      httpget.addRequestHeader("Accept", "application/vnd.urbanairship+json; version=3;");
      try {
        httpclient.executeMethod(httpget);
        InputStream responseStream = httpget.getResponseBodyAsStream();

        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream, Charset.forName("UTF-8")));

        String sLine = null;
        while ((sLine = reader.readLine()) != null) {
          sb.append(sLine + "\n");
        }
        strResponse = sb.toString();
      }
      catch (Exception e) {
        e.printStackTrace();
      } finally {
        httpget.releaseConnection();
      }
    }
    else if (this.methodType == POSTTYPE) {
      httpPost = new PostMethod(this.urlStr);
      httpPost.addRequestHeader("Content-Type", "application/json");
      httpPost.addRequestHeader("Accept", "application/vnd.urbanairship+json; version=3;");
      System.out.println("reqBody :: " + this.reqBody);
      StringRequestEntity requestEntity = new StringRequestEntity(this.reqBody);
      httpPost.setRequestEntity(requestEntity);
      try {
        httpclient.executeMethod(httpPost);
        strResponse = httpPost.getResponseBodyAsString();
        System.out.println("response : " + strResponse);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        httpPost.releaseConnection();
      }
    }
    else
    {
      StringRequestEntity requestEntity;
      if (this.methodType == 2) {
        httpPut = new PutMethod(this.urlStr);
        requestEntity = new StringRequestEntity(this.reqBody);
        httpPut.setRequestEntity(requestEntity);
      } else if (this.methodType == 3) {
        //requestEntity = new DeleteMethod(this.urlStr);
      }
    }
    return strResponse;
  }
}
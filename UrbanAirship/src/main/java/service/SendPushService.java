package service;

public abstract interface SendPushService
{
  public abstract int sendAndroid(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract int sendIos(String paramString1, String paramString2, String paramString3, String paramString4);
}
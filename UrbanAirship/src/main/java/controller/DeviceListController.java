package controller;

import model.AndroidDeviceList;
import model.IosDeviceList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DeviceListService;

@Controller
public class DeviceListController
{

  @Autowired
  private DeviceListService deviceListService;

  @RequestMapping({"/deviceList.do"})
  public String test(Model model)
  {
    return "deviceList";
  }
  @RequestMapping({"/getDeviceList.do"})
  public String getDeviceList(Model model) {
    AndroidDeviceList andList = new AndroidDeviceList();
    IosDeviceList iosList = new IosDeviceList();
    try
    {
      this.deviceListService.deleteDeviceList();
      andList = this.deviceListService.getAndroidDeviceList();
      iosList = this.deviceListService.getIosDeviceList();
    } catch (Exception e) {
      e.printStackTrace();
    }

    model.addAttribute("deviceList", this.deviceListService.selectDeviceList());
    model.addAttribute("count", Integer.valueOf(this.deviceListService.countDeviceList()));
    model.addAttribute("activeCount", Integer.valueOf(this.deviceListService.countActiveDeviceList()));
    return "deviceList";
  }
}
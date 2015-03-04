package controller;

import java.util.List;

import model.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.SendPushService;
import service.TagService;

@Controller
public class TagController
{

  @Autowired
  private TagService tagService;

  @Autowired
  private SendPushService sendPushService;

  @RequestMapping({"/tag.do"})
  public String tagForm(Model model)
  {
    model.addAttribute("campList", this.tagService.selectCamp());
    return "tag";
  }

  @RequestMapping({"/setTag.do"})
  public String setTag(Model model, @RequestParam("tag_name") String tag_name, @RequestParam("cell_id") String cell_id, @RequestParam("key") String key)
  {
    Target target = new Target();
    target.setCell_id(cell_id);
    target.setJoin_type(key);
    try {
      System.out.println(tag_name);
      List list = this.tagService.selectDeviceList(target);
      this.tagService.setAndroidTag(tag_name, list);
      this.tagService.setIosTag(tag_name, list);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    model.addAttribute("campList", this.tagService.selectCamp());
    return "tag";
  }
}
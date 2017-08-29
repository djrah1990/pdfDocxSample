package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Patrick on 2017. 8. 29..
 */

@Controller
public class RouteController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getIndexView() {
    return "index";
  }

  @RequestMapping(value = "/savePdf", method = RequestMethod.GET)
  public String getSavePdfView() {
    return "savePdf";
  }
}

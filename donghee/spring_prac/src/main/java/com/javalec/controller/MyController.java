package com.javalec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/view")
    public String view() {

        return "view";
    }

    @RequestMapping("/content/contentView")
    public String contentView(ModelMap model) {

        model.addAttribute("description", "Model Parameter");
        model.addAttribute("id", "dongheecha");

        return "content/contentView";
    }

    @RequestMapping("/content/contentView2")
    public ModelAndView contentView() {

        ModelAndView model = new ModelAndView();

        model.addObject("description", "Model Class");
        model.addObject("id", "dongheecha");
        model.setViewName("content/contentView2");

        return model;
    }
    
    
}

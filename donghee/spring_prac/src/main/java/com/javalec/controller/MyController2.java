package com.javalec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class MyController2 {
   
    @RequestMapping("/contentView")
    public String contentView(ModelMap model) {

        model.addAttribute("description", "Model Parameter");
        model.addAttribute("id", "dongheecha");

        return "board/contentView";
    }

    @RequestMapping("/contentView2")
    public ModelAndView contentView() {

        ModelAndView model = new ModelAndView();

        model.addObject("description", "Model Class");
        model.addObject("id", "dongheecha");
        model.setViewName("board/contentView2");

        return model;
    }
}

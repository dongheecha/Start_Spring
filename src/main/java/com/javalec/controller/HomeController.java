package com.javalec.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping("/")
    public String index(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        return "static/index.html";
    }
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "static/greeting.html";
      }
    @RequestMapping("/home")
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate );
        
        return "static/home.html";
    }
    
    @RequestMapping("/login.html")
    public String login(Locale locale, Model model) {
        
        return "redirect:list.html";
    }
    
    @RequestMapping("/welcome.html")
    public String welcome(Locale locale, Model model) {
        
        return "security/welcome";
    }
    
    @RequestMapping("/loginForm.html")
    public String loginForm(Locale locale, Model model) {
        
        return "security/loginForm";
    }
}

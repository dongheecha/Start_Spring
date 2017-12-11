package com.javalec.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        logger.info("welcome home!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";

    }

    @RequestMapping("/login.html")
    public String login(Locale locale, Model model) {
        return "list";
    }

    @RequestMapping("/welcome.html")
    public String welcome(Locale locale, Model model) {
        return "security/welcome";
    }

}

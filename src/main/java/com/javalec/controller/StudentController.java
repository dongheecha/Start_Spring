package com.javalec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET, value = "/getStudent")
    public String getStudent(HttpServletRequest httpServletRequest, Model model) {

        String id = httpServletRequest.getParameter("id");

        model.addAttribute("studentID", id);

        return "/student/getStudent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getStudent")
    public ModelAndView postStudent(HttpServletRequest httpServletRequest) {

        ModelAndView model = new ModelAndView();

        String id = httpServletRequest.getParameter("id");

        model.setViewName("/student/getStudent");
        model.addObject("studentID", id);

        return model;
    }

    @RequestMapping("/form")
    public String form() {

        return "/student/form";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/view")
    public String studentView(Student student) {
        
        return "/student/view";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public String studentViewInfo(@ModelAttribute("studentInfo") Student student) {
        
        return "/student/view";
    }
    
    @RequestMapping("/studentConfirm")
    public String studentConfirm(HttpServletRequest httpServletRequest , Model model) {
        
        String id = httpServletRequest.getParameter("id");
        
        if(id.equals("abc"))    return "redirect:/student/studentOK";
        
        return "redirect:/student/studentNG";
        
        
    }
    
    @RequestMapping("/studentOK")
    public String studentOK() {
        
        return "/student/studentOK";
    }
    
    @RequestMapping("/studentNG")
    public String studentNG() {
        
        return "/student/studentNG";
    }
    
}

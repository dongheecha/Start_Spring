package com.javalec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.model.StudentValid;
import com.javalec.util.handleValidator;

@Controller
@RequestMapping("/student/valid")
public class StudentValidationController {
    
    @RequestMapping("/studentForm")
    public String studentForm() {
        return "/student/valid/createPage";
    }
 
    @RequestMapping("/create")
    public String studentCreate(@ModelAttribute("studentValid") StudentValid student, BindingResult result) {
        
        String page = "/student/valid/createDonePage";
        
        handleValidator validator = new handleValidator();
        
        validator.validate(student, result);
        
        if(result.hasErrors())  page = "/student/valid/createPage";
        
        
        return page;
    }
}

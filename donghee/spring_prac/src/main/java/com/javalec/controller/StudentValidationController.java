package com.javalec.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    public String studentCreate(@ModelAttribute("studentValid") @Valid StudentValid student, BindingResult result) {

        String page = "/student/valid/createDonePage";

        
        //@Valid 를 지정함으로서 밑의 소스를 대체할 수 있음.
        /*handleValidator validator = new handleValidator();

        validator.validate(student, result);
         */
        
        if (result.hasErrors())
            page = "/student/valid/createPage";

        return page;
    }
    
    @InitBinder // validater 인터페이스를 상속하지 않아도 스프링 프레임워크가 최초로 호툴해서 알아서 검증해줌.
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new handleValidator());
    }
}

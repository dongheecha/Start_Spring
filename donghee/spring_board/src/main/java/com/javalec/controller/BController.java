package com.javalec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.impl.BService;
import com.javalec.service.BContentService;
import com.javalec.service.BDeleteService;
import com.javalec.service.BListService;
import com.javalec.service.BModifyService;
import com.javalec.service.BReplyService;
import com.javalec.service.BReplyViewService;
import com.javalec.service.BWriteService;

@Controller
public class BController {

    BService service;
   
    @RequestMapping("/list")
    public String list(Model model) {

        System.out.println("list()");

        service = new BListService();
        service.execute(model);

        return "list";
    }

    @RequestMapping("/writeView")
    public String writeView(Model model) {
        System.out.println("writeView()");

        return "writeView";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        System.out.println("write()");

        model.addAttribute("request", request);

        service = new BWriteService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("contentView")
    public String contentView(HttpServletRequest request, Model model) {

        System.out.println("contentView()");
        model.addAttribute("request", request);

        service = new BContentService();
        service.execute(model);

        return "contentView";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String modify(HttpServletRequest request, Model model) {
        System.out.println("modify()");

        model.addAttribute("request", request);
        service = new BModifyService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/replyView")
    public String replyView(HttpServletRequest request, Model model) {
        System.out.println("replyView()");

        model.addAttribute("request", request);
        service = new BReplyViewService();
        service.execute(model);

        return "replyView";
    }

    @RequestMapping("/reply")
    public String reply(HttpServletRequest request, Model model) {

        System.out.println("reply()");

        model.addAttribute("request", request);

        service = new BReplyService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {

        System.out.println("delete()");

        model.addAttribute("request", request);

        service = new BDeleteService();
        service.execute(model);

        return "redirect:list";

    }
}

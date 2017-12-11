package com.javalec.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.impl.BoardService;
import com.javalec.service.BoardContentService;
import com.javalec.service.BoardDeleteService;
import com.javalec.service.BoardListService;
import com.javalec.service.BoardModifyService;
import com.javalec.service.BoardReplyService;
import com.javalec.service.BoardReplyViewService;
import com.javalec.service.BoardWriteService;

@Controller
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    BoardService service;

    @RequestMapping("/list")
    public String list(Model model) {

        System.out.println("list()");

        service = new BoardListService();
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

        service = new BoardWriteService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("contentView")
    public String contentView(HttpServletRequest request, Model model) {

        System.out.println("contentView()");
        model.addAttribute("request", request);

        service = new BoardContentService();
        service.execute(model);

        return "contentView";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String modify(HttpServletRequest request, Model model) {
        System.out.println("modify()");

        model.addAttribute("request", request);
        service = new BoardModifyService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/replyView")
    public String replyView(HttpServletRequest request, Model model) {
        System.out.println("replyView()");

        model.addAttribute("request", request);
        service = new BoardReplyViewService();
        service.execute(model);

        return "replyView";
    }

    @RequestMapping("/reply")
    public String reply(HttpServletRequest request, Model model) {

        System.out.println("reply()");

        model.addAttribute("request", request);

        service = new BoardReplyService();
        service.execute(model);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {

        System.out.println("delete()");

        model.addAttribute("request", request);

        service = new BoardDeleteService();
        service.execute(model);

        return "redirect:list";

    }

}

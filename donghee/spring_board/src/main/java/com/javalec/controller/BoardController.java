package com.javalec.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.dao.BoardDao;
import com.javalec.dto.BoardDto;

@Controller
public class BoardController {

    BoardDao dao;

    @Autowired
    public void setDao(BoardDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/list.html")
    public String list(Model model) {

        System.out.println("list()");

        ArrayList<BoardDto> dtos = dao.list();
        model.addAttribute("list", dtos);

        return "list";
    }

    @RequestMapping("/writeView.html")
    public String writeView( Model model) {
        System.out.println("writeView()");


        return "writeView";
    }

    @RequestMapping("/write.html")
    public String write(HttpServletRequest request, Model model) {
        System.out.println("write()");

        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        dao.write(bName, bTitle, bContent);

        return "redirect:list.html";
    }

    @RequestMapping("contentView.html")
    public String contentView(HttpServletRequest request, Model model) {

        System.out.println("contentView()");

        long bId = Long.parseLong(request.getParameter("bId"));

        BoardDto dto = dao.contentView(bId);

        model.addAttribute("contentView", dto);

        return "contentView";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify.html")
    public String modify(HttpServletRequest request, Model model) {
        System.out.println("modify()");

        long bId = Long.parseLong(request.getParameter("bId"));
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        dao.modify(bId, bName, bTitle, bContent);

        return "redirect:list.html";
    }

    @RequestMapping("/replyView.html")
    public String replyView(HttpServletRequest request, Model model) {
        System.out.println("replyView()");

        long bId = Long.parseLong(request.getParameter("bId"));

        BoardDto dto = dao.replyView(bId);

        model.addAttribute("replyView", dto);

        return "replyView";
    }

    @RequestMapping("/reply.html")
    public String reply(HttpServletRequest request, Model model) {

        System.out.println("reply()");

        long bId = Long.parseLong(request.getParameter("bId"));
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");
        int bGroup = Integer.parseInt(request.getParameter("bGroup"));
        int bStep = Integer.parseInt(request.getParameter("bStep"));
        int bIndent = Integer.parseInt(request.getParameter("bIndent"));

        dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);

        return "redirect:list.html";
    }

    @RequestMapping("/delete.html")
    public String delete(HttpServletRequest request, Model model) {

        long bId = Long.parseLong(request.getParameter("bId"));

        dao.delete(bId);

        return "redirect:list.html";

    }

}

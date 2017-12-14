package com.javalec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.dto.BoardDto;
import com.javalec.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/list.html")
    public String list(Model model) {

        System.out.println("list()");

        model.addAttribute("list", boardService.getBoardList());

        return "list";
    }

    @RequestMapping("/writeView.html")
    public String writeView(Model model) {
        System.out.println("writeView()");

        return "writeView";
    }

    @RequestMapping("/write.html")
    public String write(@ModelAttribute BoardDto dto) {
        System.out.println("write()");

        int result = boardService.insertBoard(dto);

        if (result == 0)
            return "redirect:error.html";
        else
            return "redirect:list.html";
    }

    @RequestMapping("contentView.html")
    public String contentView(@RequestParam("id") long id, Model model) {

        System.out.println("contentView()");

        model.addAttribute("contentView", boardService.getBoard(id));
        int result = boardService.modifyBoardHit(id);

        if (result == 0)
            return "redirect:error.html";
        else
            return "contentView";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify.html")
    public String modify(@ModelAttribute BoardDto dto) {
        System.out.println("modify()");

        int result = boardService.modifyBoard(dto);

        if (result == 0)
            return "redirect:error.html";
        else
            return "redirect:list.html";
    }

    @RequestMapping("/replyView.html")
    public String replyView(@RequestParam("bId") long id, Model model) {
        System.out.println("replyView()");

        model.addAttribute("replyView", boardService.getBoard(id));
        int result = boardService.modifyBoardHit(id);

        if (result == 0)
            return "redirect:error.html";
        else
            return "replyView";

    }

    @RequestMapping("/reply.html")
    public String reply(@ModelAttribute BoardDto dto) {

        System.out.println("reply()");

        int result = boardService.insertBoardReply(dto);

        if (result == 0)
            return "redirect:error.html";
        else
            return "redirect:list.html";
    }

    @RequestMapping("/delete.html")
    public String delete(@RequestParam("bId") long id) {

        int result = boardService.deleteBoard(id);

        if (result == 0)
            return "redirect:error.html";
        else
            return "redirect:list.html";
    }

}

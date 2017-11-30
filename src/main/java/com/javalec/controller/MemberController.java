package com.javalec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.model.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/memberView")
    public String viewMember(HttpServletRequest httpServletRequest, Model model) {

        String id = httpServletRequest.getParameter("id");
        String pw = httpServletRequest.getParameter("pw");

        model.addAttribute("id", id);
        model.addAttribute("pw", pw);

        return "member/memberView";

    }

    @RequestMapping("/memberViewCheck")
    public String viewMember(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("pw", pw);

        return "member/memberViewCheck";

    }

    @RequestMapping("/join")
    public String memberJoin(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name,
            @RequestParam("email") String email, Model model) {

        Member member = new Member();
        
        member.setName(name);
        member.setId(id);
        member.setPw(pw);
        member.setEmail(email);
        

        model.addAttribute("member", member);

        return "member/join";

    }
    
    
    @RequestMapping("/checkJoin")
    public String memberJoin(Member member) {
        
        return "member/checkJoin";

    }
    
    @RequestMapping("/checkJoin/{name}")
    public String memberJoin2(@PathVariable String name) {
        
        return "member/checkJoin2";

    }
}

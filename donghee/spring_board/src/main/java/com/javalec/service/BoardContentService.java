package com.javalec.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BoardDao;
import com.javalec.dto.BoardDto;
import com.javalec.impl.BoardService;

public class BoardContentService implements BoardService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub
        
        
        Map<String, Object> map = model.asMap();
        HttpServletRequest request  = (HttpServletRequest) map.get("request");
        long bId = Long.parseLong(request.getParameter("bId"));
        
        BoardDao dao = new BoardDao();
        BoardDto dto = dao.contentView(bId);
        
        model.addAttribute("contentView", dto);
        
    }

}

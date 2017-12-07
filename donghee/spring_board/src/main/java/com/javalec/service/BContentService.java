package com.javalec.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.dto.BDto;
import com.javalec.impl.BService;

public class BContentService implements BService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub
        
        
        Map<String, Object> map = model.asMap();
        HttpServletRequest request  = (HttpServletRequest) map.get("request");
        long bId = Long.parseLong(request.getParameter("bId"));
        
        BDao dao = new BDao();
        BDto dto = dao.contentView(bId);
        
        model.addAttribute("contentView", dto);
        
    }

}

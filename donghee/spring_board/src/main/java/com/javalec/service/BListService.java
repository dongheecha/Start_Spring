package com.javalec.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.dto.BDto;
import com.javalec.impl.BService;

public class BListService implements BService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub

        BDao dao = new BDao();
        ArrayList<BDto> dtos = dao.list();
        
        model.addAttribute("list" , dtos);
        
    }

}

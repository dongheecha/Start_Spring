package com.javalec.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.dto.BDto;
import com.javalec.impl.BService;

@Service
public class BListService implements BService {

    
    @Autowired
    private BDao dao;

   
    public BListService() {
        System.out.println("bDao : " + dao);
    }

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub

        ArrayList<BDto> dtos = dao.list();

        model.addAttribute("list", dtos);

    }

}

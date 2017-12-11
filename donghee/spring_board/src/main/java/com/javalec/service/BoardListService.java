package com.javalec.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.dao.BoardDao;
import com.javalec.dto.BoardDto;
import com.javalec.impl.BoardService;

@Service
public class BoardListService implements BoardService {

    
    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub

        BoardDao dao = new BoardDao();
        
        ArrayList<BoardDto> dtos = dao.list();

        model.addAttribute("list", dtos);

    }

}

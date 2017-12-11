package com.javalec.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BoardDao;
import com.javalec.impl.BoardService;

public class BoardModifyService implements BoardService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub

        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        long bId = Long.parseLong(request.getParameter("bId"));
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        BoardDao dao = new BoardDao();

        dao.modify(bId, bName, bTitle, bContent);

    }

}

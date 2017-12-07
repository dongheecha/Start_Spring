package com.javalec.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.impl.BService;

public class BDeleteService implements BService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub

        Map<String, Object> map = model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        long bId = Long.parseLong(request.getParameter("bId"));

        BDao dao = new BDao();
        dao.delete(bId);

    }

}

package com.javalec.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.impl.BService;

public class BWriteService implements BService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub
        Map<String, Object> map = model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        BDao dao = new BDao();

        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");

        dao.write(bName, bTitle, bContent);

    }

}

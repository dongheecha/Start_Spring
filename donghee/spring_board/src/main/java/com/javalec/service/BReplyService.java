package com.javalec.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BDao;
import com.javalec.impl.BService;

public class BReplyService implements BService {

    @Override
    public void execute(Model model) {
        // TODO Auto-generated method stub
        Map<String, Object> map = model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        long bId = Long.parseLong(request.getParameter("bId"));
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");
        int bGroup = Integer.parseInt(request.getParameter("bGroup"));
        int bStep = Integer.parseInt(request.getParameter("bStep"));
        int bIndent = Integer.parseInt(request.getParameter("bIndent"));

        BDao dao = new BDao();
        dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);

    }

}

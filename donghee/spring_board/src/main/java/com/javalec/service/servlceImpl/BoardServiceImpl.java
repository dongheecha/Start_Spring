package com.javalec.service.servlceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.dao.BoardDao;
import com.javalec.dto.BoardDto;
import com.javalec.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao dao;

    public List<BoardDto> getBoardList() {
        // TODO Auto-generated method stub
        return dao.getBoardList();
    }

    @Override
    public int insertBoard(BoardDto dto) {
        // TODO Auto-generated method stub
        return dao.insertBoard(dto);
    }

    @Override
    public BoardDto getBoard(long id) {
        // TODO Auto-generated method stub
        return dao.getBoard(id);
    }

    @Override
    public int modifyBoardHit(long id) {
        // TODO Auto-generated method stub
        return dao.modifyBoardHit(id);
    }

    @Override
    public int modifyBoard(BoardDto dto) {
        // TODO Auto-generated method stub
        return dao.modifyBoard(dto);
    }

    @Override
    public int insertBoardReply(BoardDto dto) {
        // TODO Auto-generated method stub
        return dao.insertBoardReply(dto);
    }

    @Override
    public int deleteBoard(long id) {
        // TODO Auto-generated method stub
        return dao.deleteBoard(id);
    }

}

package com.javalec.service;

import java.util.List;

import com.javalec.dto.BoardDto;
import com.javalec.dto.MvcBoard;

public interface BoardService {

    public List<MvcBoard> getBoardList();
    int insertBoard(BoardDto dto);
    public BoardDto getBoard(long id);
    int modifyBoardHit(long id);
    int modifyBoard(BoardDto dto);
    int insertBoardReply(BoardDto dto);
    int deleteBoard(long id);
    

}

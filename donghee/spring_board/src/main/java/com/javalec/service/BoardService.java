package com.javalec.service;

import java.util.List;
import java.util.Map;

import com.javalec.dto.BoardDto;

public interface BoardService {

    public List<BoardDto> getBoardList();
    int insertBoard(BoardDto dto);
    public BoardDto getBoard(long id);
    int modifyBoardHit(long id);
    int modifyBoard(BoardDto dto);
    int insertBoardReply(BoardDto dto);
    int deleteBoard(long id);
    

}

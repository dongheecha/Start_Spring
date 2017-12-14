package com.javalec.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.dao.BoardDao;
import com.javalec.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    public SqlSession sqlSession;

    private static String namespace = "com.javalec.sample.board_mapper";

    public List<BoardDto> getBoardList() {

        return sqlSession.selectList(namespace + ".getBoardList");

    }

    public int insertBoard(BoardDto dto) {

        return sqlSession.insert(namespace + ".insertBoard", dto);
    }

    @Override
    public BoardDto getBoard(long id) {
        // TODO Auto-generated method stub
        return sqlSession.selectOne(namespace + ".getBoard", id);
    }

    @Override
    public int modifyBoardHit(long id) {
        // TODO Auto-generated method stub
        return sqlSession.update(namespace + ".modifyBoardHit", id);
    }

    @Override
    public int modifyBoard(BoardDto dto) {
        // TODO Auto-generated method stub

        return sqlSession.update(namespace + ".modifyBoard", dto);
    }

    @Override
    public int deleteBoard(long id) {
        // TODO Auto-generated method stub
        return sqlSession.delete(namespace + ".deleteBoard", id);
    }

    @Override
    public int insertBoardReply(BoardDto dto) {
        // TODO Auto-generated method stub
        return sqlSession.insert(namespace + ".insertBoardReply", dto);
    }

}
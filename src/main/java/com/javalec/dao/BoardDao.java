package com.javalec.dao;

import java.util.List;
import java.util.Map;

import com.javalec.dto.BoardDto;

/*
 * 매퍼 인터페이스
 * 이 인터페이스 내에 선언된 mapper 클래스들의 메서드 이름이 마이바티스 설정파일에 
 * <mapper>의 resource 속성 값으로 작성해둔 query.xml의 엘리멘트 id와 같은 쿼리를 수행해 결과를 return 해준다.
 * 
 * mapper인터페이스와 mapper XML은 namespace 속성으로 매핑된다.
 * 매퍼클래스의 메서드명과 일치하는 id엘리멘트의 parameterType으로 매퍼클래스의 파라미터를 넘겨받고,
 *  resultType으로 결과를 리턴해준다.
 * */

public interface BoardDao {

   public List<BoardDto> getBoardList();
   public int insertBoard(BoardDto dto);
   public BoardDto getBoard(long id);
   public int deleteBoard(long boardId);
   public int modifyBoard(BoardDto dto);
   public int insertBoardReply(BoardDto dto);
   public int modifyBoardHit(long id);
     
        
}

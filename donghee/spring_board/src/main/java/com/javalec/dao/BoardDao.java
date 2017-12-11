package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.dto.BoardDto;

public class BoardDao {

    JdbcTemplate template;

    TransactionTemplate transactionTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public BoardDao() {
        System.out.println(template);
    }

    public ArrayList<BoardDto> list() {

        String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                + " bGroup, bStep, bIndent, deleteFlag from mvc_board order by bGroup desc, bStep asc ";

        return (ArrayList<BoardDto>) template.query(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));

    }

    public void write(final String bName, final String bTitle, final String bContent) {

        template.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                // TODO Auto-generated method stub

                String query = "insert into mvc_board (bName, bTitle, bContent,bDate, bHit, bGroup, bStep, bIndent, deleteFlag) "
                        + " values(?,?,?,now(),0,(( select max(bId) + 1 from mvc_board a)),0,0,0)";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, bName);
                pstmt.setString(2, bTitle);
                pstmt.setString(3, bContent);

                return pstmt;
            }

        });
    }

    public BoardDto contentView(final long bId) {

        updateHit(bId);

        BoardDto dto = null;

        String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                + " bGroup, bStep, bIndent, deleteFlag from mvc_board where bId =  " + bId;

        dto = (BoardDto) template.queryForObject(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));

        return dto;
    }

    public void updateHit(final long bId) {

        String query = "update mvc_board set bHit = bHit + 1  where bId = ?  ";

        template.update(query, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                // TODO Auto-generated method stub
                pstmt.setLong(1, bId);
            }

        });
    }

    public void modify(final long bId, final String bName, final String bTitle, final String bContent) {

        String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?   where bId = ?  ";

        template.update(query, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                // TODO Auto-generated method stub
                pstmt.setString(1, bName);
                pstmt.setString(2, bTitle);
                pstmt.setString(3, bContent);
                pstmt.setLong(4, bId);
            }

        });
    }

    public void delete(final long bId) {
        // TODO Auto-generated method stub

        String query = "update mvc_board set deleteFlag = 1  where bId = ?  ";

        template.update(query, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                // TODO Auto-generated method stub
                pstmt.setLong(1, bId);
            }

        });
    }

    public BoardDto replyView(long bId) {
        // TODO Auto-generated method stub

        String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                + " bGroup, bStep, bIndent, deleteFlag from mvc_board where bId = " + bId;

        return template.queryForObject(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));

    }

    public void reply(final long bId, final String bName, final String bTitle, final String bContent, final int bGroup,
            final int bStep, final int bIndent) {
        // TODO Auto-generated method stub

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                // TODO Auto-generated method stub

                template.update(new PreparedStatementCreator() {

                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        // TODO Auto-generated method stub
                        String query = "update mvc_board set bHit = bHit + 1  where bId = ?  ";
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setLong(1, bId);

                        return pstmt;
                    }

                });

                template.update(new PreparedStatementCreator() {

                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        // TODO Auto-generated method stub
                        String query = "insert into mvc_board (bName, bTitle, bContent,bDate, bHit, bGroup, bStep, bIndent, deleteFlag) "
                                + " values(?, ?, ?, now(), 0, ?, ?, ?, 0)";

                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setString(1, bName);
                        pstmt.setString(2, bTitle);
                        pstmt.setString(3, bContent);
                        pstmt.setInt(4, bGroup);
                        pstmt.setInt(5, bStep + 1);
                        pstmt.setInt(6, bIndent + 1);

                        return pstmt;
                    }

                });
            }

        });

    }

    public void replyShape(final int strGroup, final int strStep) {
        // TODO Auto-generated method stub

        String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
        template.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                // TODO Auto-generated method stub
                pstmt.setInt(1, strGroup);
                pstmt.setInt(2, strStep);

            }
        });
    }

}

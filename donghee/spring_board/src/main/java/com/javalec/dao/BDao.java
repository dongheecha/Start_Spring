package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javalec.dto.BDto;


public class BDao {

    JdbcTemplate template;
    PlatformTransactionManager transactionManager;
    
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public void setTransactionManager( PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    public BDao() {
        System.out.println(template);
    }

    public ArrayList<BDto> list() {

        String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                + " bGroup, bStep, bIndent, deleteFlag from mvc_board order by bGroup desc, bStep asc ";

        return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

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

    public BDto contentView(final long bId) {

        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        // updateHit(bId);

        BDto dto = null;
        
        try {

            String query1 = "update mvc_board set bHit = bHit + 1  where bId = ?  ";

            template.update(query1, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement pstmt) throws SQLException {
                    // TODO Auto-generated method stub
                    pstmt.setLong(1, bId);
                }

            });

       
            String query2 = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                    + " bGroup, bStep, bIndent, deleteFlag from mvc_board where bId =  " + bId;

            dto = (BDto) template.queryForObject(query2, new BeanPropertyRowMapper<BDto>(BDto.class));

            transactionManager.commit(status);

            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        
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

    public BDto replyView(long bId) {
        // TODO Auto-generated method stub

        String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                + " bGroup, bStep, bIndent, deleteFlag from mvc_board where bId = " + bId;

        return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

    }

    public void reply(final long bId, final String bName, final String bTitle, final String bContent, final int bGroup,
            final int bStep, final int bIndent) {
        // TODO Auto-generated method stub

        replyShape(bGroup, bStep);

        String query = "insert into mvc_board (bName, bTitle, bContent,bDate, bHit, bGroup, bStep, bIndent, deleteFlag) "
                + " values(?, ?, ?, now(), 0, ?, ?, ?, 0)";

        template.update(query, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                // TODO Auto-generated method stub
                pstmt.setString(1, bName);
                pstmt.setString(2, bTitle);
                pstmt.setString(3, bContent);
                pstmt.setInt(4, bGroup);
                pstmt.setInt(5, bStep + 1);
                pstmt.setInt(6, bIndent + 1);

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

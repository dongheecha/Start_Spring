package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalec.dto.BDto;

public class BDao {

    DataSource dataSource;

    public BDao() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/simple_spring");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<BDto> list() {

        ArrayList<BDto> dtos = new ArrayList<BDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();

            String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                    + " bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc ";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BDto dto = new BDto(rs.getLong("bId"), rs.getString("bName"), rs.getString("bTitle"),
                        rs.getString("bContent"), rs.getTimestamp("bDate"), rs.getInt("bHit"), rs.getInt("bGroup"),
                        rs.getInt("bStep"), rs.getInt("bIndent"));

                dtos.add(dto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtos;

    }
}

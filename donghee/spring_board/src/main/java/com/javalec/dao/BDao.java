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
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/mysql");

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
                    + " bGroup, bStep, bIndent, deleteFlag from mvc_board order by bGroup desc, bStep asc ";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BDto dto = new BDto(rs.getLong("bId"), rs.getString("bName"), rs.getString("bTitle"),
                        rs.getString("bContent"), rs.getTimestamp("bDate"), rs.getInt("bHit"), rs.getInt("bGroup"),
                        rs.getInt("bStep"), rs.getInt("bIndent"), rs.getInt("deleteFlag"));

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

    public void write(String bName, String bTitle, String bContent) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();

            String query = "insert into mvc_board (bName, bTitle, bContent,bDate, bHit, bGroup, bStep, bIndent, deleteFlag) "
                    + " values(?,?,?,now(),0,(( select max(bId) + 1 from mvc_board a)),0,0,0)";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BDto contentView(long bId) {

        BDto dto = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();

            String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                    + " bGroup, bStep, bIndent, deleteFlag from mvc_board" + " where bId = ?  ";
            pstmt = conn.prepareStatement(query);

            pstmt.setLong(1, bId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new BDto(rs.getLong("bId"), rs.getString("bName"), rs.getString("bTitle"),
                        rs.getString("bContent"), rs.getTimestamp("bDate"), rs.getInt("bHit"), rs.getInt("bGroup"),
                        rs.getInt("bStep"), rs.getInt("bIndent"), rs.getInt("deleteFlag"));

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
        return dto;

    }

    public void updateHit(long bId) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();

            String query = "update mvc_board set bHit = bHit + 1  where bId = ?  ";
            pstmt = conn.prepareStatement(query);

            pstmt.setLong(1, bId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void modify(long bId, String bName, String bTitle, String bContent) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();

            String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?   where bId = ?  ";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            pstmt.setLong(4, bId);

            int row = pstmt.executeUpdate();

            System.out.println("return row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(long bId) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();

            String query = "update mvc_board set deleteFlag = 1  where bId = ?  ";
            pstmt = conn.prepareStatement(query);

            pstmt.setLong(1, bId);

            int row = pstmt.executeUpdate();

            System.out.println("return row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BDto replyView(long bId) {
        // TODO Auto-generated method stub

        BDto dto = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();

            String query = "select  bId,  bName,  bTitle,  bContent,  bDate,  bHit, "
                    + " bGroup, bStep, bIndent, deleteFlag from mvc_board" + " where bId = ?  ";
            pstmt = conn.prepareStatement(query);

            pstmt.setLong(1, bId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new BDto(rs.getLong("bId"), rs.getString("bName"), rs.getString("bTitle"),
                        rs.getString("bContent"), rs.getTimestamp("bDate"), rs.getInt("bHit"), rs.getInt("bGroup"),
                        rs.getInt("bStep"), rs.getInt("bIndent"), rs.getInt("deleteFlag"));

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
        return dto;
    }

    public void reply(long bId, String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent) {
        // TODO Auto-generated method stub

        replyShape(bGroup, bStep);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();

            String query = "insert into mvc_board (bName, bTitle, bContent,bDate, bHit, bGroup, bStep, bIndent, deleteFlag) "
                    + " values(?, ?, ?, now(), 0, ?, ?, ?, 0)";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            pstmt.setInt(4, bGroup);
            pstmt.setInt(5, bStep + 1);
            pstmt.setInt(6, bIndent + 1);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void replyShape(int strGroup, int strStep) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, strGroup);
            pstmt.setInt(2, strStep);

            int rn = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

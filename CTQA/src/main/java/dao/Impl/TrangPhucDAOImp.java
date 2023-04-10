/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Impl;

import config.MySQLConnection;
import dao.TrangPhucDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TrangPhuc;
import model.TrangPhuc;

/**
 *
 * @author DUY THINH
 */
public class TrangPhucDAOImp implements TrangPhucDAO{

    @Override
    public void createTableTrangPhuc() {
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();
        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS t_trangphuc (\n"
                + "    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,\n"
                + "    tenTrangPhuc     VARCHAR(45),\n"
                + "    loaiTrangPhuc     INT,\n"
                + "    giaChoThue         DOUBLE,\n"
                + "    doanhThuTuTrangPhuc            DOUBLE,\n"
                + "    moTa            VARCHAR(45)\n"
                + ");";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Loi khi tao bang trang phuc:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public void deleteTbl() {
        String sql = "delete from t_trangphuc";

        Connection conn = MySQLConnection.getInstance().getConnection();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public boolean insertTrangPhuc(TrangPhuc TrangPhuc) {
        boolean status = false;
        //insert ,check exist TrangPhuc, role
        if (findOne(TrangPhuc.getTenTrangPhuc()) == null) {
//            if (!checkRole(TrangPhuc.getRoleId())) {
            String sql = "INSERT INTO t_trangphuc(tenTrangPhuc, loaiTrangPhuc, giaChoThue, doanhThuTuTrangPhuc,moTa) VALUES (?,?,?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, TrangPhuc.getTenTrangPhuc());
                ps.setInt(2, TrangPhuc.getLoaiTrangPhuc());
                ps.setDouble(3, TrangPhuc.getGiaChoThue());
                ps.setDouble(4, TrangPhuc.getDoanhThuTuTrangPhuc());
                ps.setString(5, TrangPhuc.getMoTa());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert TrangPhuc:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    @Override
    public int updateInfor(String TrangPhuc, String fullname, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteTrangPhuc(String TrangPhuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TrangPhuc> getListTrangPhuc() {
        List<TrangPhuc> TrangPhucs = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM t_trangphuc ORDER BY doanhThuTuTrangPhuc DESC; ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenTrangPhuc = rs.getString("tenTrangPhuc");
                int loaiTrangPhuc = rs.getInt("loaiTrangPhuc");
                double giaChoThue = rs.getDouble("giaChoThue");
                double doanhThuTuTrangPhuc = rs.getDouble("doanhThuTuTrangPhuc");
                String moTa = rs.getString("moTa");
                TrangPhucs.add(new TrangPhuc(tenTrangPhuc, loaiTrangPhuc, giaChoThue, doanhThuTuTrangPhuc,moTa));
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi lay list trang phuc" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return TrangPhucs;
    }

    @Override
    public int countListTrangPhuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TrangPhuc findOne(String id) {
        String sql = "SELECT * FROM t_trangphuc WHERE tenTrangPhuc = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String tenTrangPhuc = rs.getString("tenTrangPhuc");
                int loaiTrangPhuc = rs.getInt("loaiTrangPhuc");
                double giaChoThue = rs.getDouble("giaChoThue");
                double doanhThuTuTrangPhuc = rs.getDouble("doanhThuTuTrangPhuc");
                String moTa = rs.getString("moTa");
                return new TrangPhuc(tenTrangPhuc, loaiTrangPhuc, giaChoThue, doanhThuTuTrangPhuc,moTa);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi tim trang phuc:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return null;
    }

    @Override
    public boolean checkAccount(String tenTrangPhuc) {
        String sql = "SELECT * FROM t_user WHERE tenTrangPhuc = ? ";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenTrangPhuc);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }

        return false;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Impl;

import config.MySQLConnection;
import dao.KhachHangDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Administrator
 */
public class KhachHangDAOImp implements KhachHangDAO {

    @Override
    public void createTableKhachHang() {
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();
        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS t_khachhang (\n"
                + "    tenKhachHang     VARCHAR(45),\n"
                + "    soDienThoai     VARCHAR(45),\n"
                + "    diaChi         VARCHAR(45),\n"
                + "    doanhThuTuKhachHang            DOUBLE,\n"
                + "    PRIMARY KEY (soDienThoai)\n"
                + ");";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Loi khi tao bang khach hang:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public void deleteTbl() {
        String sql = "delete from t_khachHang";

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
            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public boolean insertKhachHang(KhachHang khachHang) {
        boolean status = false;
        //insert ,check exist khachHang, role
        if (findOne(khachHang.getSoDienThoai()) == null) {
//            if (!checkRole(khachHang.getRoleId())) {
            String sql = "INSERT INTO t_khachHang(tenKhachHang, soDienThoai, diaChi, doanhThuTuKhachHang) VALUES (?,?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, khachHang.getTenKhachHang());
                ps.setString(2, khachHang.getSoDienThoai());
                ps.setString(3, khachHang.getDiaChi());
                ps.setDouble(4, khachHang.getDoanhThuTuKhachHang());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert khachHang:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    @Override
    public int updateInfor(String KhachHang, String fullname, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteKhachHang(String KhachHang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> getListKhachHang() {
        List<KhachHang> khachHangs = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM t_khachHang ORDER BY doanhThuTuKhachHang DESC; ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenKhachHang = rs.getString("tenKhachHang");
                String diaChi = rs.getString("diaChi");
                double doanhThuTuKhachHang = rs.getDouble("doanhThuTuKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                khachHangs.add(new KhachHang(tenKhachHang, soDienThoai, diaChi, doanhThuTuKhachHang));
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi lay list Khach Hang" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return khachHangs;
    }

    @Override
    public int countListKhachHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang findOne(String SdtKhachHang) {
        String sql = "SELECT * FROM t_khachHang WHERE soDienThoai = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, SdtKhachHang);
            rs = ps.executeQuery();
            if (rs.next()) {
                String tenKhachHang = rs.getString("tenKhachHang");
                String diaChi = rs.getString("diaChi");
                double doanhThuTuKhachHang = rs.getDouble("doanhThuTuKhachHang");
                return new KhachHang(tenKhachHang, SdtKhachHang, diaChi, doanhThuTuKhachHang);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi tim tai khoan:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return null;
    }

    @Override
    public boolean checkAccount(String soDienThoai) {
        String sql = "SELECT * FROM t_user WHERE soDienThoai = ? ";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, soDienThoai);
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

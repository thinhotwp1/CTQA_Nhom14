/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Impl;

import config.MySQLConnection;
import dao.NhaPhanPhoiDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhaPhanPhoi;

/**
 *
 * @author Administrator
 */
public class NhaPhanPhoiDAOImp implements NhaPhanPhoiDAO {

    @Override
    public void createTableNhaPhanPhoi() {
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();
        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS t_nhaphanphoi (\n"
                + "    tenNhaPhanPhoi     VARCHAR(45),\n"
                + "    soDienThoai     VARCHAR(45),\n"
                + "    diaChi         VARCHAR(45),\n"
                + "    doanhThuTuNhaPhanPhoi            DOUBLE,\n"
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
        String sql = "delete from t_NhaPhanPhoi";

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
    public boolean insertNhaPhanPhoi(NhaPhanPhoi NhaPhanPhoi) {
        boolean status = false;
        //insert ,check exist NhaPhanPhoi, role
        if (findOne(NhaPhanPhoi.getSoDienThoai()) == null) {
//            if (!checkRole(NhaPhanPhoi.getRoleId())) {
            String sql = "INSERT INTO t_NhaPhanPhoi(tenNhaPhanPhoi, soDienThoai, diaChi, doanhThuTuNhaPhanPhoi) VALUES (?,?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, NhaPhanPhoi.getTenNhaPhanPhoi());
                ps.setString(2, NhaPhanPhoi.getSoDienThoai());
                ps.setString(3, NhaPhanPhoi.getDiaChi());
                ps.setDouble(4, NhaPhanPhoi.getDoanhThuTuNhaPhanPhoi());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert NhaPhanPhoi:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    @Override
    public int updateInfor(String NhaPhanPhoi, String fullname, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteNhaPhanPhoi(String NhaPhanPhoi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhaPhanPhoi> getListNhaPhanPhoi() {
        List<NhaPhanPhoi> NhaPhanPhois = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM t_NhaPhanPhoi ORDER BY doanhThuTuNhaPhanPhoi DESC; ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenNhaPhanPhoi = rs.getString("tenNhaPhanPhoi");
                String diaChi = rs.getString("diaChi");
                double doanhThuTuNhaPhanPhoi = rs.getDouble("doanhThuTuNhaPhanPhoi");
                String soDienThoai = rs.getString("soDienThoai");
                NhaPhanPhois.add(new NhaPhanPhoi(tenNhaPhanPhoi, soDienThoai, diaChi, doanhThuTuNhaPhanPhoi));
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi lay list Khach Hang" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return NhaPhanPhois;
    }

    @Override
    public int countListNhaPhanPhoi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhaPhanPhoi findOne(String SdtNhaPhanPhoi) {
        String sql = "SELECT * FROM t_NhaPhanPhoi WHERE soDienThoai = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, SdtNhaPhanPhoi);
            rs = ps.executeQuery();
            if (rs.next()) {
                String tenNhaPhanPhoi = rs.getString("tenNhaPhanPhoi");
                String diaChi = rs.getString("diaChi");
                double doanhThuTuNhaPhanPhoi = rs.getDouble("doanhThuTuNhaPhanPhoi");
                return new NhaPhanPhoi(tenNhaPhanPhoi, SdtNhaPhanPhoi, diaChi, doanhThuTuNhaPhanPhoi);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi tim khach hang:\n" + ex);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MySQLConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinhLD
 */
public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl sInstance;

    public static UserDAOImpl getInstance() {
        if (sInstance == null) {
            sInstance = new UserDAOImpl();
        }
        return sInstance;
    }

    @Override
    public void createTableUser() {
        // create if not exist
        // table user (tenTaiKhoan,matKhau,tenNhanVien,role,force_update_matKhau)
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();
        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS t_user (\n"
                + "    tenTaiKhoan     VARCHAR(45),\n"
                + "    tenNhanVien     VARCHAR(45),\n"
                + "    matKhau         VARCHAR(45),\n"
                + "    role            INT,\n"
                + "    PRIMARY KEY (tenTaiKhoan)\n"
                + ");";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Loi khi tao bang user:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public boolean insertUser(User user) {
        boolean status = false;
        //insert ,check exist user, role
        if (findOne(user.getTenTaiKhoan()) == null) {
//            if (!checkRole(user.getRoleId())) {
            String sql = "INSERT INTO t_user(tenTaiKhoan, tenNhanVien, matKhau, role) VALUES (?,?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getTenTaiKhoan());
                ps.setString(2, user.getTenNhanVien());
                ps.setString(3, user.getMatKhau());
                ps.setInt(4, user.getRole());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert user:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    @Override
    public User findOne(String tenTaiKhoan) {
        String sql = "SELECT * FROM t_user WHERE tenTaiKhoan = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenTaiKhoan);
            rs = ps.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("tenNhanVien");
                String matKhau = rs.getString("matKhau");
                int roleId = rs.getInt("role");
                return new User(tenTaiKhoan, fullName, matKhau, roleId);
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
    public void deleteTbl() {
        String sql = "delete from t_user";

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


    /*
    1. Thành công
    2.user Name đã tồn tại
    3.Quyền đã tồn tại
     */
    @Override
    public int updateInfor(String tenTaiKhoan, String fullname, String pass) {
        int status = 0;
        String sql = null;
        if (fullname.isEmpty()) {
            sql = "UPDATE t_user SET matKhau = ? WHERE tenTaiKhoan = ?";
        } else {
            sql = "UPDATE t_user SET matKhau = ?, tenNhanVien = ? WHERE tenTaiKhoan = ?";
        }

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            if (fullname.isEmpty()) {
                ps.setString(1, pass);
                ps.setString(2, tenTaiKhoan);
            } else {
                ps.setString(1, pass);
                ps.setString(2, fullname);
                ps.setString(3, tenTaiKhoan);
            }
            ps.executeUpdate();
            conn.commit();
            status = 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            status = 0;
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
            MySQLConnection.getInstance().closeConn(conn);
        }
        return status;
    }

    @Override
    public boolean deleteUser(String tenTaiKhoan) {
        boolean c = false;
        //delete
        String sql = "DELETE FROM t_user WHERE tenTaiKhoan = ?";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenTaiKhoan);
            ps.executeUpdate();
            conn.commit();
            c = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return c;
    }

    @Override
    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM t_user";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String fullName = rs.getString("tenNhanVien");
                String matKhau = rs.getString("matKhau");
                int roleId = rs.getInt("role");
                users.add(new User(tenTaiKhoan, fullName, matKhau, roleId));
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi lay list user" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return users;
    }
    @Override
    public int countListUser() {
        List<User> users = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM t_user";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String fullName = rs.getString("tenNhanVien");
                String matKhau = rs.getString("matKhau");
                int roleId = rs.getInt("role");
                users.add(new User(tenTaiKhoan, fullName, matKhau, roleId));
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi lay list user" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return users.size();
    }

    @Override
    public boolean checkAccount(String username, String password) {
        String sql = "SELECT * FROM t_user WHERE tenTaiKhoan = ? AND matKhau = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
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

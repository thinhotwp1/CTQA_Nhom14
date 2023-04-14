package com.example.server_ctqa.config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    // Các thông tin kết nối đến cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://localhost:3306/ctqa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Đối tượng kết nối duy nhất
    private static MySQLConnection instance;

    // Đối tượng Connection
    private Connection connection;

    // Phương thức tạo đối tượng duy nhất
    private MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức trả về đối tượng kết nối duy nhất
    public static synchronized MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    // Phương thức trả về đối tượng Connection
    public Connection getConnection() {
        return connection;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
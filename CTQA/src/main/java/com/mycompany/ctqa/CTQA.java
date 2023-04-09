/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ctqa;

import config.MySQLConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class CTQA {

    public static void main(String[] args) {
        MySQLConnection conn = MySQLConnection.getInstance();
        Connection connection = conn.getConnection();
        try {
            if (!connection.isClosed()) {
                System.out.println("Connected to MySQL database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

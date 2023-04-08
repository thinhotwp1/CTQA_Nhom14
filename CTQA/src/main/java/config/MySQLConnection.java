package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnection {

    // Các thông tin kết nối đến cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://localhost:3306/CTQA";
    private static final String USER = "root";
    private static final String PASSWORD = "thjnhotwp1";

    // Đối tượng kết nối duy nhất
    private static MySQLConnection instance;

    // Đối tượng Connection
    private Connection connection;

    // Phương thức tạo đối tượng duy nhất
    private MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

}
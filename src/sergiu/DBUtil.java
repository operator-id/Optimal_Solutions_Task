package sergiu;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:sqlite:employeedb.db";
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn;
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(URL);
        return conn;
    }

    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Result set closing problem");
            }
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Statement closing problem");
            }
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("JDBC Connection closing problem");
            }
    }
}

package sergiu;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:sqlite:employeedb.db";
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(URL);
        return connection;
    }

    public static void closeAll(Connection con, Statement statement, ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Result set closing problem");
            }
        if (statement != null)
            try {
                statement.close();
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

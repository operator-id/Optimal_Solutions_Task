package sergiu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeTableManager {

    public void createEmployeeTable() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();

            preparedStatement = connection.prepareStatement("SELECT name from" +
                    " sqlite_master WHERE type='table' AND name='employee'");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Creating employee table...");

                preparedStatement = connection.prepareStatement("CREATE TABLE employee(a varchar(100), b varchar(100), c varchar(100)," +
                        "d varchar(50), e varchar(500), f varchar(100), g varchar(100), h varchar(10), i varchar(10), j varchar(100))");
                preparedStatement.execute();
            } else {
                System.out.println("There already exists an employee table.");
            }


        } catch (SQLException ex) {
            System.out.println("Check SQL syntax");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problems with the JDBC driver");

        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }

    }

    public void insertEmployeeListIntoDB(List<Employee> employeeList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO employee" +
                    "(a, b, c, d, e, f, g, h, i, j) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (Employee employee : employeeList) {

                preparedStatement.setString(1, employee.getFieldA());
                preparedStatement.setString(2, employee.getFieldB());
                preparedStatement.setString(3, employee.getFieldC());
                preparedStatement.setString(4, employee.getFieldD());
                preparedStatement.setString(5, employee.getFieldE());
                preparedStatement.setString(6, employee.getFieldF());
                preparedStatement.setString(7, employee.getFieldG());
                preparedStatement.setString(8, employee.getFieldH());
                preparedStatement.setString(9, employee.getFieldI());
                preparedStatement.setString(10, employee.getFieldJ());

                preparedStatement.addBatch();


            }
            int[] numUpdates = preparedStatement.executeBatch();

            for (int i = 0; i < numUpdates.length; i++) {
                if (numUpdates[i] == -2)
                    System.out.println("Execution " + i +
                            ": unknown number of rows updated");
                else
                    System.out.println("Execution " + i +
                            " successful: " + numUpdates[i] + " rows updated");
            }
        } catch (SQLException ex) {
            System.out.println("Check SQL syntax");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problems with the JDBC driver");

        } finally {
            DBUtil.closeAll(connection, preparedStatement, null);
        }
    }

    public void dropEmployeeTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();

            preparedStatement = connection.prepareStatement("SELECT name FROM" +
                    " sqlite_master WHERE type='table' AND name='employee'");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Dropping employee table...");
                PreparedStatement statement = connection.prepareStatement("DROP TABLE employee");
                statement.execute();
            } else {
                System.out.println("No employee table found.");
            }


        } catch (SQLException ex) {
            System.out.println("Check SQL syntax");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problems with the JDBC driver");

        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }

    }
}

package sergiu;

import java.sql.*;
import java.util.List;

public class EmployeeTableManager {

    public void createEmployeeTable() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();

            preparedStatement = connection.prepareStatement("SELECT name from" +
                    " sqlite_master WHERE type='table' AND name='employee'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                System.out.println("Creating employee table...");
                Statement createStatement = connection.createStatement();
                createStatement.execute("CREATE TABLE employee(a varchar(100), b varchar(100), c varchar(100)," +
                        "d varchar(50), e varchar(1000), f varchar(100), g float, h varchar(10), i varchar(10), j varchar(100))");
            }
            else {
                System.out.println("There already exists an employee table.");
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
    public void insertEmployeeListIntoDB(List<Employee> employeeList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO Film( ID, TITLU, DURATA, AN_APARITIE, RATING, DESCRIERE) values(NULL, ?, ?, ?, ?, ?)");



            preparedStatement.executeUpdate();

            System.out.println("Succes la adaugarea unui film nou");

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
    public void dropEmployeeTable(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();

            preparedStatement = connection.prepareStatement("SELECT name FROM" +
                    " sqlite_master WHERE type='table' AND name='employee'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Dropping employee table...");
                Statement createStatement = connection.createStatement();
                createStatement.execute("DROP TABLE employee;");
            }else{
                System.out.println("No employee table found.");
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
}

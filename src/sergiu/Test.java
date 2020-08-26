package sergiu;

import java.util.List;

public class Test {

    public static void main(String[] args)  {

        long startTime = System.nanoTime();
        try {
            CustomParser parser = new CustomParser();

            List<Employee> employees = parser.parseCSV(StringConstants.CSV_FILE_PATH);
            RecordFieldsCheckerUtil.checkForBadRecordsInList(employees);

            EmployeeTableManager manager = new EmployeeTableManager();
            //manager.dropEmployeeTable();
            manager.createEmployeeTable();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Task took " + estimatedTime/ 10E8 + " seconds");
    }
}

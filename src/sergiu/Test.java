package sergiu;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        ListProcessor processor = new ListProcessor();
        CustomParser parser = new CustomParser();
        EmployeeTableManager manager = new EmployeeTableManager();
        try {

            List<Employee> employees = parser.parseCSV(StringConstants.CSV_FILE_PATH);

            processor.processEmployeesList(employees);
            processor.writeLogs();

            //manager.dropEmployeeTable();
            manager.createEmployeeTable();
            manager.insertEmployeeListIntoDB(processor.getSuccessfulRecords());


        } catch (Exception e) {
            e.printStackTrace();
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Task took " + estimatedTime / 10E8 + " seconds");
    }
}

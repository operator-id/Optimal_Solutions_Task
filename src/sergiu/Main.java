package sergiu;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        ListProcessor processor = new ListProcessor();
        CustomParser parser = new CustomParser();
        EmployeeTableManager manager = new EmployeeTableManager();
        PropertiesManager properties = new PropertiesManager();

        try {
            List<Employee> employees = parser.parseCSV(properties.getPropValues("input_file_path"));

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

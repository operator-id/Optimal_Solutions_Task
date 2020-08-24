package sergiu;

import java.util.List;

public class Test {
    static String CSV_FILE_PATH = "Resources/Interview-task-data-osh.csv";
    public static void main(String[] args)  {
        long startTime = System.nanoTime();
// ... the code being measured ...

        try {
            CustomParser parser = new CustomParser();

            List<Employee> emps = parser.parseCSV(CSV_FILE_PATH);
            System.out.println(emps.toString());
//        parseCSVFileAsList();
//        System.out.println("**********");
//        parseCSVToBeanList();
//        System.out.println("**********");
//        writeCSVData(emps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Task took " + estimatedTime/ 10E8 + " seconds");
    }
}

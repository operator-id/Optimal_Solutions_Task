package sergiu;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomParser {

    CustomParser() {
    }
//    private static void parseCSVToBeanList() throws IOException {
//
//        HeaderColumnNameTranslateMappingStrategy<Employee> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Employee>();
//        beanStrategy.setType(Employee.class);
//
//        Map<String, String> columnMapping = new HashMap<String, String>();
//        columnMapping.put("ID", "id");
//        columnMapping.put("Name", "name");
//        columnMapping.put("Role", "role");
//        //columnMapping.put("Salary", "salary");
//
//        beanStrategy.setColumnMapping(columnMapping);
//
//        CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
//        CSVReader reader = new CSVReader(new FileReader("employees.csv"));
//        List<Employee> emps = csvToBean.parse(beanStrategy, reader);
//        System.out.println(emps);
//    }

//    private static void writeCSVData(List<Employee> emps) throws IOException {
//        StringWriter writer = new StringWriter();
//
//        CSVWriter csvWriter = new CSVWriter(writer);
//
//        List<String[]> data  = toStringArray(emps);
//        csvWriter.writeAll(data);
//        csvWriter.close();
//        System.out.println(writer);
//    }

//    private static List<String[]> toStringArray(List<Employee> emps) {
//        List<String[]> records = new ArrayList<String[]>();
//        //add header record
//        records.add(new String[]{"ID","Name","Role","Salary"});
//        Iterator<Employee> it = emps.iterator();
//        while(it.hasNext()){
//            Employee emp = it.next();
//            records.add(new String[]{emp.getId(),emp.getName(),emp.getRole(),emp.getSalary()});
//        }
//        return records;
//    }

    List<Employee> parseCSV(String filePath) throws IOException, CsvException {
        int counter = 0;

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
//        CSVParser parser = new CSVParserBuilder()
//                .withSeparator(',')
//                .build();

        CSVReader reader = new CSVReaderBuilder(fileReader)
                .withSkipLines(1)
//                .withCSVParser(parser)
                .build();
        List<String[]> allData = reader.readAll();


        List<Employee> employees = new ArrayList<>();
        for (String[] row : allData) {
            if(row.length<2){break;}
            counter++;
            Employee emp = new Employee();
            System.out.println(" row: " + counter);


            emp.setFieldA(row[0]);
            emp.setFieldB(row[1]);
            emp.setFieldC(row[2]);
            emp.setFieldD(row[3]);
            emp.setFieldE(row[4]);
            emp.setFieldF(row[5]);
            emp.setFieldG(row[6]);
            emp.setFieldH(row[7]);
            emp.setFieldI(row[8]);
            emp.setFieldJ(row[9]);

            employees.add(emp);

        }

        reader.close();


        return employees;
    }

//    private static void parseCSVAsList() throws IOException, CsvException {
//        //create CSVReader object
//        CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');
//
//        List<Employee> emps = new ArrayList<Employee>();
//        //read all lines at once
//        List<String[]> records = reader.readAll();
//
//        Iterator<String[]> iterator = records.iterator();
//        //skip header row
//        iterator.next();
//
//        while(iterator.hasNext()){
//            String[] record = iterator.next();
//            Employee emp = new Employee();
//            emp.setId(record[0]);
//            emp.setName(record[1]);
//            emp.setRole(record[2]);
//            emp.setSalary(record[3]);
//            emps.add(emp);
//        }
//
//        reader.close();
//
//        System.out.println(emps);
//    }

}

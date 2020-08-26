package sergiu;

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


    List<Employee> parseCSV(String filePath) throws IOException, CsvException {
        int counter = 0;

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));

        CSVReader reader = new CSVReaderBuilder(fileReader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = reader.readAll();


        List<Employee> employees = new ArrayList<>();
        for (String[] row : allData) {
            if (row.length > 1) {
                counter++;
                Employee employee = new Employee();
                System.out.println("row: " + counter);


                employee.setFieldA(row[0]);
                employee.setFieldB(row[1]);
                employee.setFieldC(row[2]);
                employee.setFieldD(row[3]);
                employee.setFieldE(row[4]);
                employee.setFieldF(row[5]);
                employee.setFieldG(row[6]);
                employee.setFieldH(row[7]);
                employee.setFieldI(row[8]);
                employee.setFieldJ(row[9]);

                employees.add(employee);
            }
        }

        reader.close();


        return employees;
    }

}

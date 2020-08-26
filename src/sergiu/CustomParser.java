package sergiu;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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


        List<Employee> employees = new LinkedList<>();
        for (String[] row : allData) {
            if(row.length > 1) {
                counter++;
                Employee emp = new Employee();
                System.out.println("row: " + counter);


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
        }

        reader.close();


        return employees;
    }

}

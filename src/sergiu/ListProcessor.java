package sergiu;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
    PropertiesManager properties = new PropertiesManager();
    private List<String[]> badRecords = new ArrayList<>();
    private List<Employee> successfulRecords = new ArrayList<>();
    private int totalRecords;

    private static String[] populateRow(Employee employee) {
        String[] row = new String[10];
        row[0] = employee.getFieldA();
        row[1] = employee.getFieldB();
        row[2] = employee.getFieldC();
        row[3] = employee.getFieldD();
        row[4] = employee.getFieldE();
        row[5] = employee.getFieldF();
        row[6] = employee.getFieldG();
        row[7] = employee.getFieldH();
        row[8] = employee.getFieldI();
        row[9] = employee.getFieldJ();

        return row;
    }

    public void processEmployeesList(List<Employee> fullList) {
        getBadRecords().add(Employee.getHeaders());
        setTotalRecords(fullList.size());

        for (Employee employee : fullList) {
            if (employee.getFieldA().isBlank()
                    || employee.getFieldB().isBlank()
                    || employee.getFieldC().isBlank()
                    || employee.getFieldD().isBlank()
                    || employee.getFieldE().isBlank()
                    || employee.getFieldF().isBlank()
                    || employee.getFieldG().isBlank()
                    || employee.getFieldH().isBlank()
                    || employee.getFieldI().isBlank()
                    || employee.getFieldJ().isBlank()
            ) {
                getBadRecords().add(populateRow(employee));


            } else {
                getSuccessfulRecords().add(employee);
            }

        }
    }

    public void writeLogs() {
        try {
            WriterUtil.writeIntoCSVFile(properties.getPropValues("bad_data_start_text")
                            + PropertiesManager.getTimeStamp() + properties.getPropValues("bad_data_extension")
                    , getBadRecords());
            String logText = properties.getPropValues("record_total_number_text") + getTotalRecords() + "\n" +
                    properties.getPropValues("record_successful_number_text") + getSuccessfulRecords().size() + "\n" +
                    properties.getPropValues("record_failed_number_text") + getBadRecords().size();
            WriterUtil.writeIntoFile(properties.getPropValues("log_path") , logText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getBadRecords() {
        return badRecords;
    }

    public List<Employee> getSuccessfulRecords() {
        return successfulRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}

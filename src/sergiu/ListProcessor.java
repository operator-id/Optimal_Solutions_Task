package sergiu;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
    private List<String[]> badRecords = new ArrayList<>();
    private List<Employee> successfulRecords = new ArrayList<>();
    private int totalRecords;

    public void processEmployeesList(List<Employee> fullList) {
        getBadRecords().add(Employee.getHeaders());
        setTotalRecords(fullList.size());

        for(Employee employee: fullList){
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

    public void writeLogs(){
        try {
            WriterUtil.writeIntoCSVFile(StringConstants.getBadDataPath(), getBadRecords());
            String logText = StringConstants.RECORDS_RECEIVED + getTotalRecords() + "\n" +
                    StringConstants.RECORDS_SUCCESSFUL + getSuccessfulRecords().size() + "\n" +
                    StringConstants.RECORDS_FAILED + getBadRecords().size();
            WriterUtil.writeIntoFile(StringConstants.LOG_PATH, logText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getBadRecords() {
        return badRecords;
    }

    public void setBadRecords(List<String[]> badRecords) {
        this.badRecords = badRecords;
    }

    public List<Employee> getSuccessfulRecords() {
        return successfulRecords;
    }

    public void setSuccessfulRecords(List<Employee> successfulRecords) {
        this.successfulRecords = successfulRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}

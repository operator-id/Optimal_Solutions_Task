package sergiu;

import java.util.ArrayList;
import java.util.List;

public class RecordFieldsCheckerUtil
{

   public static void checkForBadRecordsInList(List<Employee> list){

       List<String[]> badRecords = new ArrayList<>();

       badRecords.add(Employee.getHeaders());


       int numberOfFailedRecords = 0;
       int numberOfReceivedRecords = list.size();
       for (Employee employee : list ){
          if (employee.getFieldA().trim().equals("")
                  || employee.getFieldB().trim().equals("")
                  || employee.getFieldC().trim().equals("")
                  || employee.getFieldD().trim().equals("")
                  || employee.getFieldE().trim().equals("")
                  || employee.getFieldF().trim().equals("")
                  || employee.getFieldG().trim().equals("")
                  || employee.getFieldH().trim().equals("")
                  || employee.getFieldI().trim().equals("")
                  || employee.getFieldJ().trim().equals("")
          ){
              numberOfFailedRecords++;
              badRecords.add(populateCSVRow(employee));
          } else {

          }

      }
       int numberOfRecordsSuccessful = numberOfReceivedRecords - numberOfFailedRecords;
       try {
           WriterUtil.writeIntoCSVFile(StringConstants.getBadDataPath(), badRecords);
           String logText = StringConstants.RECORDS_RECEIVED + numberOfReceivedRecords + "\n" +
                   StringConstants.RECORDS_SUCCESSFUL + numberOfRecordsSuccessful + "\n" +
                   StringConstants.RECORDS_FAILED + numberOfFailedRecords;
           WriterUtil.writeIntoFile(StringConstants.LOG_PATH, logText);


       } catch (Exception e){
           e.printStackTrace();
       }

   }
   private static String[] populateCSVRow(Employee employee){
       String[] row = new String[Employee.getHeaders().length];
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

}

package sergiu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringConstants {
    static final String LOG_PATH = "Output/log.txt";
    static String CSV_FILE_PATH = "Resources/Interview-task-data-osh.csv";
    static final String RECORDS_RECEIVED = "# of records received : ";
    static final String RECORDS_SUCCESSFUL = "# of records successful : ";
    static final String RECORDS_FAILED = "# of records failed : ";


    static String getBadDataPath(){

        String timeStamp = getTimeStamp();
        return "Output/bad-data-" +
                timeStamp +
                ".csv";
    }
    private static String getTimeStamp(){
        return new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss").format(new Date());
    }
}

package sergiu;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class WriterUtil {

    public static void writeIntoFile(String path, String data) throws IOException {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(getFile(path)), StandardCharsets.UTF_8));
            writer.write(data);
        } catch (
                IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }


    public static void writeIntoCSVFile(String path, List<String[]> data) {
        Writer writer = null;


        try {

            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(getFile(path)), StandardCharsets.UTF_8));
            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeAll(data);

        } catch (
                IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }

    private static File getFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}

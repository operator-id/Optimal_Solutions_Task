package sergiu;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriterUtil {

    public static void writeIntoFile(String path, String data) throws IOException {
        Writer writer = null;
        File log = new File(path);
        log.createNewFile();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(log), StandardCharsets.UTF_8));
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
}

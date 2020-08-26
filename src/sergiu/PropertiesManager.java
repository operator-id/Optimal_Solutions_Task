package sergiu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

class PropertiesManager {
    private InputStream inputStream;



     String getPropValues(String property) throws IOException {
        String result = null;
        try {
            java.util.Properties prop = new java.util.Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            result = prop.getProperty(property);


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

    static String getTimeStamp() {
        return new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss").format(new Date());
    }
}

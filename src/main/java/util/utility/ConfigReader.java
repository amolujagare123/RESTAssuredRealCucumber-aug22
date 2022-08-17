package util.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the config file
        FileInputStream fis = new FileInputStream("config/config.properties");

        // 2. create object of Properties class
        Properties prop = new Properties();

        // 3. load this object with file object
        prop.load(fis);

        return prop;
    }

    public static String getSampleUserUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("urlSampleUser");
    }

    public static String getChatServerUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("chatServerUrl");
    }
}

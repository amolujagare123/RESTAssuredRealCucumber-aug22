package util.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClassDemo {

    public static void main(String[] args) throws IOException {

        // 1. read the config file
        FileInputStream fis = new FileInputStream("config/config.properties");

        // 2. create object of Properties class
        Properties prop = new Properties();

        // 3. load this object with file object
        prop.load(fis);

        // 4. read the file
        System.out.println(prop.getProperty("urlSampleUser"));
    }
}

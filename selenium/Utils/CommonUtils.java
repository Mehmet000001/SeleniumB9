package selenium.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
    public  static String readProperty(String propertyKey){
        File propertyFile= new File("src/test/resources/config.properties");
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(propertyFile));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return properties.getProperty(propertyKey);
    }
}

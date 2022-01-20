package TestBase;
import java.io.*;
import java.util.*;
public class PropertyReaderClass {
    private static PropertyReaderClass propertyReaderObject;
    public String value;
    private Properties properties;


    private PropertyReaderClass(){
        try{
            FileReader reader=new FileReader("src/main/Properties/SnatchBot.properties");
            properties=new Properties();
            properties.load(reader);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static PropertyReaderClass getInstance() {
        propertyReaderObject = new PropertyReaderClass();
        return propertyReaderObject;
    }

    public String getPropValues(String key) {
        value = properties.getProperty(key);
        return value;
    }
}

package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Will be reading with the help of properties file
/*This method is used to load the properties from config.properties file
@return it returns Properties prop object*/
public class ConfigReader {
    private Properties prop;

    //public void initialize_properties() { -> since returning prop void should remove
    public Properties initialize_properties() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:/Users/Himasha/IdeaProjects/cucumber-automation/src/test/resources/configuration/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
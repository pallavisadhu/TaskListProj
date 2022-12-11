package readconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	Properties properties;
	public final String propertyFilePath="/Users/pallavisadhu/Desktop/TaskListProj/TaskListSeleniumProj/src/test/java/configfiles/Config.properties";
	
	public ConfigFileReader() throws IOException,FileNotFoundException {
		File f =  new File(propertyFilePath);
		FileInputStream fin = new FileInputStream(f);
		properties = new Properties();
		properties.load(fin);
		
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getUserName() {
		return properties.getProperty("username");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	

}

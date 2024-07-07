package commonLibs.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	
	public static Properties readProperties(String filename) throws IOException {
		filename = filename.trim();
		
		InputStream fileReader = new FileInputStream(filename);
		
		Properties property = new Properties();
		
		property.load(fileReader);
		
		return property;
	}

}

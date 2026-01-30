package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	public static void loadConfig() {

		try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {

			properties = new Properties();
			properties.load(file);

		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties file");
		}
	}

	public static String getPropertyValue(String key) {

		if (properties == null) { 
			loadConfig(); 
		}

		String value = properties.getProperty(key);

		if (value == null) {
			throw new RuntimeException("Key not found in config.properties: " + key);
		}
		return value;
	}

//	public static int getTimeout() {
//		return Integer.parseInt(getPropertyValue("timeout")); 
//	}
 
}

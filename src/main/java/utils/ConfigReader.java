package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			FileInputStream file = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load config.properties file!");
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}

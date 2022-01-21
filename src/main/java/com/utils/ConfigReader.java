package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns the Properties peop object
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/test/resources/com/config/config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
}

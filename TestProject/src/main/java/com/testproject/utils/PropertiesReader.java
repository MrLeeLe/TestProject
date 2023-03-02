package com.testproject.utils;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesReader {

	public static Properties prop = new Properties();
	
	//Get the current environment configuration
	public String getConfigByKey(String config) {
		try {
			prop.load(new FileInputStream("src/test/resources/globalconfig/config.properties"));
			return prop.getProperty(config);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
}

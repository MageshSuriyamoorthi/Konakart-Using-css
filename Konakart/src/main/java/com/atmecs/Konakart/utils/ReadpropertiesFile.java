package com.atmecs.Konakart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ReadpropertiesFile {

	private Properties prop = new Properties();

	public ReadpropertiesFile() {
		List<String> propsFiles = Arrays.asList(Classpaths.loc_file, Classpaths.url_file, Classpaths.loc_file_two);

		for (String filePath : propsFiles) {
			try {
				prop.load(new FileInputStream(new File(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getLocatorValue(String elements) {
		String data = prop.getProperty(elements);
		return data;
	}

}

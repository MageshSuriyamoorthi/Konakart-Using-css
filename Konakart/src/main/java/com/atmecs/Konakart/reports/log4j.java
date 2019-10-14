package com.atmecs.Konakart.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.Konakart.utils.Classpaths;

/**
 * Configure the log4j file path and to display output messages.
 * 
 */

public class log4j {

	Logger logger = null;

	public log4j() {
		getlogger();
		logger = Logger.getLogger(log4j.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(Classpaths.log4j_file);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void infoboo(boolean message) {
		logger.info(message);
	}

}

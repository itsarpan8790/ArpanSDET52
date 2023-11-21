package com.bixi.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to Read Data From Properties File
	 * 
	 * @author arpan
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fisP = new FileInputStream(IpathConstants.FilePath);
		Properties p = new Properties();
		p.load(fisP);
		String value = p.getProperty(key);
		return value;

	}
}

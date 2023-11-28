package com.bixi.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to generate Random No upto 500
	 * @author arpan
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}

	/**
	 * This method is to return Current System Date
	 * @author arpan
	 * @return
	 */
	public String systemDate() {
		Date date=new Date();
		String sysDate = date.toString();
		return sysDate;
	}
	
	/**
	 * This method is for System Date with Time
	 * 
	 * @return
	 */
	public String systemDateInformat() {
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		String sysDateTime = formatter.format(date);
		return sysDateTime;
	}
}





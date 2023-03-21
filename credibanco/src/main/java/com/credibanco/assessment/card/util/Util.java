package com.credibanco.assessment.card.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {
	
	public static int getDifferenceBetweenDates(Timestamp date) {
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(new Date());
		Calendar finalDate = Calendar.getInstance();
		finalDate.setTime(date);
		
		return startDate.get(Calendar.MINUTE) - finalDate.get(Calendar.MINUTE); 
	}
	
	public String transformPan(String pan) {
		char[] panChars = pan.toCharArray();
		for (int i = 0; i < panChars.length; i++) {
			if (i>=6&&i<=panChars.length-5) 
				panChars[i] = '*';
		}
		
		return String.valueOf(panChars);
	}

}

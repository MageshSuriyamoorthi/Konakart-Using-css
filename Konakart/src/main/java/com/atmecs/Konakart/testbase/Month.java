package com.atmecs.Konakart.testbase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Month {

	public String daysdifference(String blogerDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dayDifference = "";
		try {

			String currentDate = formatter.format(date);
			String blogDate = monthINFormate(blogerDate);

			Date date1;
			Date date2;

			SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

			date1 = dates.parse(currentDate);
			date2 = dates.parse(blogDate);

			long difference = Math.abs(date1.getTime() - date2.getTime());
			long differenceDates = difference / (24 * 60 * 60 * 1000);

			dayDifference = Long.toString(differenceDates);
		} catch (Exception exception) {
		}
		return dayDifference;

	}

	public String monthINFormate(String date) {
		String dateArr[] = date.replace(",", "").split("\\s+");
		int j = 0;
		String MM = "";
		String[] monthArr = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < monthArr.length; i++) {
			if (dateArr[1].equalsIgnoreCase(monthArr[i])) {
				j = i + 1;
				break;
			}
		}
		if (j < 10)
			MM = "0" + j;
		else
			MM = MM + j;

		String blogDate = MM + "/" + dateArr[0] + "/" + dateArr[2];
		return blogDate;
	}

}

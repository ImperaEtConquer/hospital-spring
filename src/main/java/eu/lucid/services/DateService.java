package eu.lucid.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

@Service
public class DateService {

	public String DateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	public Date StringToDate(String date) {
		String[] data = date.split("-");
		int year = Integer.valueOf(data[0]);
		int month = Integer.valueOf(data[1]);
		int day = Integer.valueOf(data[2]);
		return new GregorianCalendar(year, month - 1, day).getTime();
	}
}

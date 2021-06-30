package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
//		System.out.println(dateSql);
		
		// local date
		LocalDate localDate = LocalDate.now();
//		System.out.println(localDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = sdf.format(date);
		Date formattedDate = sdf.parse(dateStr);
		System.out.println(dateStr);
		System.out.println(formattedDate);
	}
}

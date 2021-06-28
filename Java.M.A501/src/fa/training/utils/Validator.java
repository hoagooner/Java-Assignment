package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
	public static Date parseStringToDate(String dateString) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		simpleDateFormat.setLenient(false);
		return simpleDateFormat.parse(dateString);
	}

	public static boolean isPhone(String phone) {
		try {
			Integer.valueOf(phone);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isOrderNumber(String number) {
		try {
			Integer.valueOf(number);
		} catch (Exception e) {
			return false;
		}
		return number.length() == 10;
	}
}

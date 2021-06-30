package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
	
	static String datePatt = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
	static String EMAIL_PATTERN = 
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
	static String EMAIL_PATTERN1 = 
            "^[a-zA-Z][\\w-]+@fsoft.com.vn$";
	
	
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile(datePatt);
//		String dateStr = "1999-13-12";
//		Matcher matcher = pattern.matcher(dateStr);
//		System.out.println(matcher.matches());
//		System.out.println(dateStr.matches(datePatt));
//		
//		String test = "123aabcd55";
//		Pattern pattern1 = Pattern.compile("\\d+");
//		Matcher matcher1 = pattern1.matcher(test);
//		while(matcher1.find()) {
//			System.out.println(matcher1.group());
//		}
		
		System.out.println("hoa@fsoft.com.vn".matches(EMAIL_PATTERN1));
		RegexExample obj = new RegexExample();
	}
}
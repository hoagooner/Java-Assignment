package oop;

public class StringSample {
	public static void main(String[] args) {
		String x = "abcd";
		String y = x.toString() + "d";
//		String z = y.toString();
		
		System.out.println(x == y);
	}
}

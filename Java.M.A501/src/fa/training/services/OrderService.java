package fa.training.services;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import fa.training.entities.Order;
import fa.training.utils.Validator;

public class OrderService {
	public Order createOrder() {
		Order order = new Order();
		Scanner scanner = new Scanner(System.in);
		System.out.print("+ number: ");
		String orderNumber =  scanner.nextLine();
		while(!Validator.isOrderNumber(orderNumber)) {
			System.out.print("Invalid order number, please enter order number with length equals 10: ");
			orderNumber = scanner.nextLine();
		}
		order.setNumber(orderNumber);
		System.out.print("+ date: ");
		String dateString = scanner.nextLine();
		boolean checkParse = true;
		do {
			try {
				Date date = Validator.parseStringToDate(dateString);
				order.setDate(date);
				checkParse = true;
			} catch (ParseException e) {
				checkParse = false;
				System.out.print("Date format must be dd/mm/yyyy, enter date again: ");
				dateString = scanner.nextLine();
			}
		} while (!checkParse);
		return order;
	}
}

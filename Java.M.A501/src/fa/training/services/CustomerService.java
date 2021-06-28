package fa.training.services;

import static fa.training.main.Test.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Validator;

public class CustomerService {

	private static OrderService orderService = new OrderService();

	public static Customer createCustomer() {
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("----Enter customer information----");
		System.out.print("Enter name: ");
		customer.setName(sc.nextLine());
		System.out.print("Enter phone number: ");
		String phone =  sc.nextLine();
		while(!Validator.isPhone(phone)) {
			System.out.print("Invalid phone number, try again: ");
			phone = sc.nextLine();
		}
		customer.setPhoneNumber(phone);
		System.out.print("Enter address: ");
		customer.setAddress(sc.nextLine());

		System.out.println("Enter order infor: ");
		List<Order> orders = new ArrayList<Order>();
		String choice = "y";
		do {
			orders.add(orderService.createOrder());
			System.out.print("Do you want to add an order, press Y/y: ");
			choice = sc.nextLine();
		} while (choice.equalsIgnoreCase("Y"));
		customer.setOrders(orders);

		customers.add(customer);
		System.out.println("--------------");
		return customer;
	}

	public static List<Customer> findAll() {
		return customers;
	}

	public static void display(List<Customer> customers) {
		customers.forEach(customer -> System.out.println(customer));
	}

	public static List<Customer> search(String phone) {
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equals(phone))
				result.add(customer);
		}
		return result;
	}

	public static boolean remove(String phone) {
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equals(phone))
				customers.remove(customer);
			return true;
		}
		return false;
	}

}

package fa.training.services;

import java.util.List;
import java.util.Scanner;

import fa.training.dao.CustomerDAO;
import fa.training.dao.impl.CustomerDAOImpl;
import fa.training.entities.Customer;

public class CustomerService {
	public CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public void getAllCustomer() {
		List<Customer> customers = customerDAO.getCustomers();
		customers.forEach(customer -> System.out.println(customer));
	}

	public void addCustomer() {
		Customer customer = new Customer();
		customer.input();
		if (customerDAO.add(customer)) System.out.println("Add Customer successfully");
		else System.out.println("Add Customer failed");
	}

	@SuppressWarnings("resource")
	public void deleteCustomer() {
		System.out.print("Enter customer id: ");
		try {
			int customerId = Integer.valueOf(new Scanner(System.in).nextLine());
			if (customerDAO.delete(customerId)) System.out.println("Delete Customer successfully");
			else System.out.println("Delete Customer failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void updateCustomer() {
		Scanner scanner = new Scanner(System.in);
		try {
			Customer customer = new Customer();
			System.out.print("Enter customer id: ");
			customer.setCustomerId(Integer.valueOf(scanner.nextLine()));
			System.out.print("Enter customer name: ");
			customer.setCustomerName(scanner.nextLine());
			
			if (customerDAO.update(customer)) System.out.println("Update customer successfully");
			else System.out.println("Update customer failed");
		} catch (Exception e) {
			System.out.println("Update customer failed");
			e.printStackTrace();
		}
		
	}
}

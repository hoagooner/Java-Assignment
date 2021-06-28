package fa.training.entities;

import java.util.Scanner;

public class Customer {
	private int customerId;
	private String customerName;
	
	public Customer() {
	}

	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	@SuppressWarnings("resource")
	public void input() {
		do {
			try {
				if (customerName == null) {
					System.out.print("Enter the customer name: ");
					customerName = new Scanner(System.in).nextLine();
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
}

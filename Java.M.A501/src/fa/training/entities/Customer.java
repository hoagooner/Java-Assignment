package fa.training.entities;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String phoneNumber;
	private String address;
	List<Order> orders;

	public Customer(String name, String phoneNumber, String address, List<Order> orders) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.orders = orders;
	}

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		String str = "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "] - ";
		for (Order order : this.orders) {
			str += order.toString();
		}
		return str;
	}

}

package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Order {
	private int orderId;
	private Date orderDate;
	private int customerId;
	private int employeeId;
	private double total;
	
	public Order() {
	}

	public Order(int orderId, Date orderDate, int customerId, int employeeId, double total) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}
	
	@SuppressWarnings("resource")
	public void input() {
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				if (orderDate == null) 
					orderDate = new Date();
				if (customerId == 0) {
					System.out.print("Enter customer id: ");
					customerId = Integer.valueOf(scanner.nextLine());
				}
				if (employeeId == 0) {
					System.out.print("Enter employee id: ");
					employeeId = Integer.valueOf(scanner.nextLine());
				}
				if (total == 0) {
					System.out.print("Enter order total: ");
					total = Double.valueOf(scanner.nextLine());
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return "Order [orderId=" + orderId + ", orderDate=" + format.format(orderDate) + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", total=" + total + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}	

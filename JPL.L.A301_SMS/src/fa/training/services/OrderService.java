package fa.training.services;

import java.util.List;
import java.util.Scanner;

import fa.training.dao.OrderDAO;
import fa.training.dao.impl.OrderDAOImpl;
import fa.training.entities.Order;

public class OrderService {
	public OrderDAO orderDAO = new OrderDAOImpl();
	
	@SuppressWarnings("resource")
	public void getAllOrdersByCustomerId() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the customer id: ");
			int id = Integer.valueOf(scanner.nextLine());
			List<Order> orders = orderDAO.getOrdersByCustomerID(id);
			System.out.println("List order by customer id: "+id);
			orders.forEach(order -> System.out.println(order));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void addOrder() {
		Order order = new Order();
		order.input();
		if (orderDAO.add(order)) System.out.println("Add order successfully");
		else System.out.println("Add order failed");
	}


	@SuppressWarnings("resource")
	public void updateOrderTotal() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter order id: ");
			int orderId = Integer.valueOf(scanner.nextLine());
			
			if (orderDAO.updateOrderTotal(orderId)) System.out.println("Update order successfully");
			else System.out.println("Update order failed");
		} catch (Exception e) {
			System.out.println("Update order failed");
			e.printStackTrace();
		}
	}
}

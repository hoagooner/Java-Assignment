package fa.training.services;

import java.util.List;
import java.util.Scanner;

import fa.training.dao.LineItemDAO;
import fa.training.dao.impl.LineItemDAOImpl;
import fa.training.entities.LineItem;

public class LineItemService {
	public LineItemDAO lineItemDAO = new LineItemDAOImpl();

	@SuppressWarnings("resource")
	public void getAllItemsByOrderId() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the order id: ");
			int orderId = Integer.valueOf(scanner.nextLine());
			List<LineItem> lineItems = lineItemDAO.getAllItemsByOrderId(orderId);
			System.out.println("List Line Item by order id: "+orderId);
			lineItems.forEach(lineItem -> System.out.println(lineItem));
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

	@SuppressWarnings("resource")
	public void computeOrderTotal() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the order id: ");
			int orderId = Integer.valueOf(scanner.nextLine());
			System.out.println("Total oder by order id : "+orderId);
			System.out.println("Order id " + orderId + " : " + lineItemDAO.computeOrderTotal(orderId) + "$");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLineItem() {
		LineItem lineItem = new LineItem();
		lineItem.input();
		
		if (lineItemDAO.add(lineItem)) System.out.println("Add LineItem successfully");
		else System.out.println("Add LineItem failed");
	}	

}

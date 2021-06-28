package fa.training.main;

import java.util.Scanner;

import fa.training.services.CustomerService;
import fa.training.services.LineItemService;
import fa.training.services.OrderService;

public class SaleManagement {
	public static CustomerService customerService = new CustomerService();
	public static OrderService orderService = new OrderService();
	public static LineItemService lineItemService = new LineItemService();
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String number = "";
		do {
			System.out.println("Choose function: ");
			System.out.println("1. List customer");
			System.out.println("2. List order by customer id");
			System.out.println("3. List Line Item by order id");
			System.out.println("4. Compute order total by order id");
			System.out.println("5. Add customer");
			System.out.println("6. Remove customer");
			System.out.println("7. Update customer");
			System.out.println("8. Create an order");
			System.out.println("9. Create a lineitem");
			System.out.println("10. Update an order total");
			System.out.println("11. Exit");
			System.out.print("Enter the number: ");
			number = scanner.nextLine();
				switch (number) {
				case "1":
					customerService.getAllCustomer();
					break;
				case "2":
					orderService.getAllOrdersByCustomerId();
					break;
				case "3":
					lineItemService.getAllItemsByOrderId();
					break;
				case "4":
					lineItemService.computeOrderTotal();
					break;
				case "5":
					customerService.addCustomer();
					break;
				case "6":
					customerService.deleteCustomer();
					break;
				case "7":
					customerService.updateCustomer();
					break;
				case "8":
					orderService.addOrder();
					break;
				case "9":
					lineItemService.addLineItem();
					break;
				case "10":
					orderService.updateOrderTotal();
					break;
				}
			System.out.println("---------------");
		} while (!"11".equalsIgnoreCase(number));
		scanner.close();
	}
}

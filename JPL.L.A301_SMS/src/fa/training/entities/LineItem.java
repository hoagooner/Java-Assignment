package fa.training.entities;

import java.util.Scanner;

public class LineItem {
	private int orderId;
	private int productId;
	private int quantity;
	private double price;
	
	public LineItem() {
	}

	public LineItem(int orderId, int productId, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	@SuppressWarnings("resource")
	public void input() {
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				if (orderId == 0) 
					System.out.print("Enter order id: ");
					orderId = Integer.valueOf(scanner.nextLine());
				if (productId == 0) {
					System.out.print("Enter product id: ");
					productId = Integer.valueOf(scanner.nextLine());
				}
				if (quantity == 0) {
					System.out.print("Enter quantity: ");
					quantity = Integer.valueOf(scanner.nextLine());
				}
				if (price == 0) {
					System.out.print("Enter price: ");
					price = Double.valueOf(scanner.nextLine());
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	@Override
	public String toString() {
		return "LineItem [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

	public int getOerderId() {
		return orderId;
	}

	public void setOerderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

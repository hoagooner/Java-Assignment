package fa.training.dao;

import java.util.List;

import fa.training.entities.Order;

public interface OrderDAO {
	public List<Order> getOrders();
	public Order getOrder(int orderId);
	public boolean add(Order order);
	public boolean update(Order order);
	public boolean updateOrderTotal(int orderId);
	public void delete(int orderId);
	public List<Order> getOrdersByCustomerID(int customerId);
}

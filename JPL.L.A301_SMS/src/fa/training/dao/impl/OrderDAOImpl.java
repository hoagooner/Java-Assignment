package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fa.training.dao.LineItemDAO;
import fa.training.dao.OrderDAO;
import fa.training.entities.Order;
import fa.training.services.LineItemService;
import fa.training.utils.DBConnection;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LineItemDAO lineItemDAO = new LineItemDAOImpl();

	@Override
	public boolean add(Order order) {
		String sql = "INSERT INTO Orders (order_date, customer_id, employee_id, total) VALUES(?,?,?,?)";
		try (Connection conn = DBConnection.getConnection();PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setTimestamp(1, new java.sql.Timestamp(order.getOrderDate().getTime()));
			statement.setInt(2, order.getCustomerId());
			statement.setInt(3, order.getEmployeeId());
			statement.setDouble(4, order.getTotal());
			if (statement.executeUpdate() > 0) return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean update(Order order) {
		return false;
	}
	
	@Override
	public boolean updateOrderTotal(int orderId) {
		String sql = "UPDATE Orders SET total = ? WHERE order_id = ?";
		try (Connection conn = DBConnection.getConnection();PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setDouble(1, lineItemDAO.computeOrderTotal(orderId));
			statement.setInt(2, orderId);
			
			if (statement.executeUpdate() > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public void delete(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getOrdersByCustomerID(int customerId) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM Orders WHERE customer_id = ?";
		ResultSet rs = null;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, customerId);
			rs = statement.executeQuery();
			while (rs.next()) {
				int order_Id = rs.getInt("order_id");
				Date order_date = rs.getDate("order_date");
				int customer_Id = rs.getInt("customer_id");
				int employee_Id = rs.getInt("employee_id");
				double total = rs.getDouble("total");
				Order order = new Order(order_Id,order_date,customer_Id,employee_Id,total);
				orders.add(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return orders;
	}

}

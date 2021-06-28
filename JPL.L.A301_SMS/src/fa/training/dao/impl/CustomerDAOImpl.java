package fa.training.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;
import fa.training.utils.DBConnection;

public class CustomerDAOImpl implements CustomerDAO{
	
	@Override
	public List<Customer> getCustomers() {
		String sql = "SELECT * FROM Customer";
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);) {
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("customer_id"), rs.getString("customer_name"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	@Override
	public boolean add(Customer customer) {
		String sql = "{CALL addCustomer(?, ?)}";
		try (Connection conn = DBConnection.getConnection();CallableStatement statement = conn.prepareCall(sql);) {
			statement.setString(1, customer.getCustomerName());
			statement.registerOutParameter(2, Types.INTEGER);
			
			statement.execute();
			
			return statement.getInt(2) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Customer customer) {
		String sql = "UPDATE Customer SET customer_name = ? WHERE customer_Id = ?";
		try (Connection conn = DBConnection.getConnection();PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, customer.getCustomerName());
			statement.setInt(2, customer.getCustomerId());
			int result = statement.executeUpdate();
			
			if (result > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}


	
	@Override
	public boolean delete(int customerId) {
		String sql = "{CALL deleteCustomer(?, ?)}";
		try (Connection conn = DBConnection.getConnection();CallableStatement statement = conn.prepareCall(sql);) {
			statement.setInt(1, customerId);
			statement.registerOutParameter(2, Types.INTEGER);
			
			statement.execute();
			
			return statement.getInt(2) == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

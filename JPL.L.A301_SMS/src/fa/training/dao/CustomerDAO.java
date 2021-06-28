package fa.training.dao;


import java.util.List;

import fa.training.entities.Customer;


public interface CustomerDAO {
	public List<Customer> getCustomers();
	public Customer getCustomer(int customerId);
	public boolean add(Customer customer);
	public boolean update(Customer customer);
	public boolean delete(int customerId);
}

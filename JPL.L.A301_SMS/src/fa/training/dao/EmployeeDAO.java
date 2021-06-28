package fa.training.dao;


import java.util.List;

import fa.training.entities.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployee(int employeeId);
	public void add(Employee employee);
	public void update(Employee employee);
	public void delete(int employeeId);
}

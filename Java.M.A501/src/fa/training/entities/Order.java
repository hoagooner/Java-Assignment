package fa.training.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private String number;
	private Date date;
	private Customer customer;

	public Order(String number, Date date, Customer customer) {
		super();
		this.number = number;
		this.date = date;
		this.customer = customer;
	}

	public Order(String number, Date date) {
		super();
		this.number = number;
		this.date = date;
	}

	public Order() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String formatDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		return formatter.format(date);
	}

	@Override
	public String toString() {
		return " Order [number=" + number + ", date=" + this.formatDate() + "]";
	}

}

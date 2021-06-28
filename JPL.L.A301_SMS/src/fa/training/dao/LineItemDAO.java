package fa.training.dao;


import java.util.List;

import fa.training.entities.LineItem;


public interface LineItemDAO {
	public List<LineItem> getLineItems();
	public LineItem getLineItem(int lineItemId);
	public boolean add(LineItem lineItem);
	public void update(LineItem lineItem);
	public void delete(int lineItemId);
	public List<LineItem> getAllItemsByOrderId(int orderId);
	public Double computeOrderTotal(int orderId);
}

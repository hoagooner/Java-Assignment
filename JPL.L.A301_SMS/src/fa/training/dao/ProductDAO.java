package fa.training.dao;

import java.util.List;

import fa.training.entities.Product;


public interface ProductDAO {
	public List<Product> getProducts();
	public Product getProduct(int productId);
	public void add(Product product);
	public void update(Product product);
	public void delete(int productId);
}

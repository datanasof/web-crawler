package db;

public class Product {
	private int id;
	private String productName;
	
	public Product() {}
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}

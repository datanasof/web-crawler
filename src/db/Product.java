package db;

public class Product {
	private int productID;
	private String productName;
	
	public Product() {}
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int id) {
		this.productID = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}

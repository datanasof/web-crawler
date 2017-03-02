package db;

public class Pricelist {
	private int id;
	private int productID;
	private int price;
	private String currency;
	
	public Pricelist() {}
	public Pricelist(int productID, int price, String currency) {
		super();
		this.productID = productID;
		this.price = price;
		this.currency = currency;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}

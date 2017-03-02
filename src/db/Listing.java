package db;
import java.sql.Timestamp;

public class Listing {
	private int id;
	
	private int productID;	   
	private int dealerID;
	private float price;
	private String currency;
	private String url;
	private Timestamp time;
	   
	private int rating;
	private int position;
   	   	   
	public Listing() {}
	
   public Listing(int productID, int dealerID, float price, String currency, String url, Timestamp time, int rating,
			int position) {
		this.productID = productID;
		this.dealerID = dealerID;
		this.price = price;
		this.currency = currency;
		this.url = url;
		this.time = time;
		this.rating = rating;
		this.position = position;
	}
   
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	   
	public int getDealerID() {
		return dealerID;
	}
	public void setDealerID(int dealerID) {
		this.dealerID = dealerID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getProductID() {
	    return productID;
	}
	public void setProductID( int id ) {
		this.productID = id;
	}	   
}

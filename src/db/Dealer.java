package db;

public class Dealer {
	private int dealerID;
	private int pvmonthly;	   
	private int pvyearly;
	private String dealerName;	
   	   	   
	public Dealer() {}
	   
    public Dealer(String name, int pvmonthly, int pvyearly) {	
	this.pvmonthly = pvmonthly;
	this.pvyearly = pvyearly;
	this.dealerName = name;
    }

	public int getDealerID() {
		return dealerID;
	}

	public void setDealerID(int id) {
		this.dealerID = id;
	}

	public int getPvmonthly() {
		return pvmonthly;
	}

	public void setPvmonthly(int pvmonthly) {
		this.pvmonthly = pvmonthly;
	}

	public int getPvyearly() {
		return pvyearly;
	}

	public void setPvyearly(int pvyearly) {
		this.pvyearly = pvyearly;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String name) {
		this.dealerName = name;
	}
    

}

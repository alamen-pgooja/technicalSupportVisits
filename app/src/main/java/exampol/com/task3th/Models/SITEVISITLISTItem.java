package exampol.com.task3th.Models;

import com.google.gson.annotations.SerializedName;

public class SITEVISITLISTItem{

	@SerializedName("ContactNo")
	private String contactNo;

	@SerializedName("MerchantName")
	private String merchantName;

	@SerializedName("visitTitle")
	private String visitTitle;

	@SerializedName("visitDescription")
	private String visitDescription;

	@SerializedName("TicketNo")
	private String ticketNo;

	@SerializedName("Id")
	private int id;

	@SerializedName("MerchantID")
	private String merchantID;

	@SerializedName("VisitDate")
	private String visitDate;

	@SerializedName("Location")
	private Location location;

	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}

	public String getContactNo(){
		return contactNo;
	}

	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}

	public String getMerchantName(){
		return merchantName;
	}

	public void setVisitTitle(String visitTitle){
		this.visitTitle = visitTitle;
	}

	public String getVisitTitle(){
		return visitTitle;
	}

	public void setVisitDescription(String visitDescription){
		this.visitDescription = visitDescription;
	}

	public String getVisitDescription(){
		return visitDescription;
	}

	public void setTicketNo(String ticketNo){
		this.ticketNo = ticketNo;
	}

	public String getTicketNo(){
		return ticketNo;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMerchantID(String merchantID){
		this.merchantID = merchantID;
	}

	public String getMerchantID(){
		return merchantID;
	}

	public void setVisitDate(String visitDate){
		this.visitDate = visitDate;
	}

	public String getVisitDate(){
		return visitDate;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"SITEVISITLISTItem{" + 
			"contactNo = '" + contactNo + '\'' + 
			",merchantName = '" + merchantName + '\'' + 
			",visitTitle = '" + visitTitle + '\'' + 
			",visitDescription = '" + visitDescription + '\'' + 
			",ticketNo = '" + ticketNo + '\'' + 
			",id = '" + id + '\'' + 
			",merchantID = '" + merchantID + '\'' + 
			",visitDate = '" + visitDate + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}
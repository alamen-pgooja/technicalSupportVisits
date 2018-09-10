package exampol.com.task3th.Models;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(nameInDb = "VISITS")
public class SITEVISITLISTItem{

	public SITEVISITLISTItem() {
	}

	public SITEVISITLISTItem(Long number, String contactNo, String merchantName, String visitTitle, String visitDescription, String ticketNo, int id, String merchantID, String visitDate) {
		this.number = number;
		this.contactNo = contactNo;
		this.merchantName = merchantName;
		this.visitTitle = visitTitle;
		this.visitDescription = visitDescription;
		this.ticketNo = ticketNo;
		this.id = id;
		this.merchantID = merchantID;
		this.visitDate = visitDate;
	}

	// this entity just for numbering not part of the model
	// just for data base use
	@Id(autoincrement = true)
	private Long number;

	@Property
	@SerializedName("ContactNo")
	private String contactNo;

	@Property
	@SerializedName("MerchantName")
	private String merchantName;

	@Property
	@SerializedName("visitTitle")
	private String visitTitle;

	@Property
	@SerializedName("visitDescription")
	private String visitDescription;

	@Property
	@SerializedName("TicketNo")
	private String ticketNo;

	@Property
	@SerializedName("Id")
	private int id;

	@Property
	@SerializedName("MerchantID")
	private String merchantID;

	@Property
	@SerializedName("VisitDate")
	private String visitDate;


	@ToOne
	@JoinEntity(entity = Location.class, sourceProperty = "Id", targetProperty = "Id")
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
	public String toString() {
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
}
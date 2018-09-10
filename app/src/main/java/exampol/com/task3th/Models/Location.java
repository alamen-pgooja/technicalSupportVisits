package exampol.com.task3th.Models;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity (nameInDb = "Location")
public class Location{

	@Id(autoincrement = true)
	Long id;
	@Property
	@SerializedName("latitude")
	private double latitude;

	@Property
	@SerializedName("longitude")
	private double longitude;

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
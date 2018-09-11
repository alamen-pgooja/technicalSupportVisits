package exampol.com.task3th.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ServerResponse {

	@SerializedName("SITEVISITLIST")
	private List<Visit> sITEVISITLIST;

	@SerializedName("ERROR")
	private String eRROR;

	@SerializedName("RESULT")
	private String rESULT;

	public void setSITEVISITLIST(List<Visit> sITEVISITLIST){
		this.sITEVISITLIST = sITEVISITLIST;
	}

	public List<Visit> getSITEVISITLIST(){
		return sITEVISITLIST;
	}

	public void setERROR(String eRROR){
		this.eRROR = eRROR;
	}

	public String getERROR(){
		return eRROR;
	}

	public void setRESULT(String rESULT){
		this.rESULT = rESULT;
	}

	public String getRESULT(){
		return rESULT;
	}

	@Override
 	public String toString(){
		return 
			"ServerResponse{" +
			"sITEVISITLIST = '" + sITEVISITLIST + '\'' + 
			",eRROR = '" + eRROR + '\'' + 
			",rESULT = '" + rESULT + '\'' + 
			"}";
		}
}
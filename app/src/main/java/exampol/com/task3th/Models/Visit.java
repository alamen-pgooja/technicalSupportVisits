package exampol.com.task3th.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Visit{

	@SerializedName("SITEVISITLIST")
	private List<SITEVISITLISTItem> sITEVISITLIST;

	@SerializedName("ERROR")
	private String eRROR;

	@SerializedName("RESULT")
	private String rESULT;

	public void setSITEVISITLIST(List<SITEVISITLISTItem> sITEVISITLIST){
		this.sITEVISITLIST = sITEVISITLIST;
	}

	public List<SITEVISITLISTItem> getSITEVISITLIST(){
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
			"Visit{" + 
			"sITEVISITLIST = '" + sITEVISITLIST + '\'' + 
			",eRROR = '" + eRROR + '\'' + 
			",rESULT = '" + rESULT + '\'' + 
			"}";
		}
}
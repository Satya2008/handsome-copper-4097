package model;


import java.io.Serializable;
import java.util.Date;

import controller.CrimeController;

public class Crime  extends CrimeController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int crimeId;
	private CrimeType type;
	private String Desc;
	private String psArea;
	private Date date;
	private String victim;

	public Crime(CrimeType type, String desc, String psArea, Date date, String victim) {
		super();
		this.crimeId = (int)(Math.random()*100000000);
		this.type = type;
		this.Desc = desc;
		this.psArea = psArea;
		this.date = date;
		this.victim = victim;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public CrimeType getType() {
		return type;
	}

	public void setType(CrimeType type) {
		this.type = type;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getPsArea() {
		return psArea;
	}

	public void setPsArea(String psArea) {
		this.psArea = psArea;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", type=" + type + ", Desc=" + Desc + ", psArea=" + psArea + ", date="
				+ date + ", victim=" + victim + "]";
	}


   
   
}

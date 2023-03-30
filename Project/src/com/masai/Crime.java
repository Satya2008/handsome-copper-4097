package com.masai;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Crime implements Serializable {
	private int crimeId;
	private String type;
	private String Desc;
	private String psArea;
	private String date;
	private String victim;

	public Crime(String type, String desc, String psArea, String date, String victim) {
		super();
		this.crimeId = (int)(Math.random()*100000000);
		this.type = type;
		Desc = desc;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	
	
//	   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("crime.txt"));
 public void writeCrime() throws FileNotFoundException, IOException {
	 try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("crime.txt"))){
		 oos.writeObject(this);
	 }catch(IOException e)  {
		 e.printStackTrace();
	 }
	
 }

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", type=" + type + ", Desc=" + Desc + ", psArea=" + psArea + ", date="
				+ date + ", victim=" + victim + "]";
	} 
   
   
}

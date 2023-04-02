package model;

import java.io.Serializable;

public class Criminal implements Serializable {
	private int criminalId;
	private String name;
	private String dob;
	private String gender;
	private String identifyingMark;
	private String firstArrestDate;
	private String arrestedFromPsArea;
  
  
  
	public Criminal( String name, String dob, String gender, String identifyingMark,
		String firstArrestDate, String arrestedFromPsArea) {
		super();
		this.criminalId = (int)(Math.random()*100000000);
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifyingMark = identifyingMark;
		this.firstArrestDate = firstArrestDate;
		this.arrestedFromPsArea = arrestedFromPsArea;
	}

	public int getCriminalId() {
		return criminalId;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getIdentifyingMark() {
		return identifyingMark;
	}

	public String getFirstArrestDate() {
		return firstArrestDate;
	}

	public String getArrestedFromPsArea() {
		return arrestedFromPsArea;
	}

	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setIdentifyingMark(String identifyingMark) {
		this.identifyingMark = identifyingMark;
	}

	public void setFirstArrestDate(String firstArrestDate) {
		this.firstArrestDate = firstArrestDate;
	}

	public void setArrestedFromPsArea(String arrestedFromPsArea) {
		this.arrestedFromPsArea = arrestedFromPsArea;
	}

	@Override
	public String toString() {
		return "Criminal{" +
				"criminalId=" + criminalId +
				", name='" + name + '\'' +
				", dob='" + dob + '\'' +
				", gender='" + gender + '\'' +
				", identifyingMark='" + identifyingMark + '\'' +
				", firstArrestDate='" + firstArrestDate + '\'' +
				", arrestedFromPsArea='" + arrestedFromPsArea + '\'' +
				'}';
	}
}

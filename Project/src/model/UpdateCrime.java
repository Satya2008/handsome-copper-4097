package model;

import java.util.Date;

public class UpdateCrime {
    

	private CrimeType type;
    private String Desc;
    private String psArea;
    private Date date;
    private String victim;

    public UpdateCrime(CrimeType type, String desc, String psArea, Date date, String victim) {
		super();
		this.type = type;
		Desc = desc;
		this.psArea = psArea;
		this.date = date;
		this.victim = victim;
	}
    
    public void setType(CrimeType type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setPsArea(String psArea) {
        this.psArea = psArea;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public CrimeType getType() {
        return type;
    }

    public String getDesc() {
        return Desc;
    }

    public String getPsArea() {
        return psArea;
    }

    public Date getDate() {
        return date;
    }

    public String getVictim() {
        return victim;
    }
}

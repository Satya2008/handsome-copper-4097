package model;

public class UpdateCriminal {

    private String name;
    private String dob;
    private String gender;
    private String identifyingMark;
    private String firstArrestDate;
    private String arrestedFromPsArea;

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

}


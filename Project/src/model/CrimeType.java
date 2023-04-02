package model;

public enum CrimeType {
    ROBBERY,
    THEFT,
    HOMICIDE;

    public static CrimeType getCT(String ct){
        CrimeType crimeType = null;
        if(ct.equalsIgnoreCase("Robbery")) {
        	crimeType =  ROBBERY;
        }
            
        else if(ct.equalsIgnoreCase("Theft")){
            crimeType = THEFT;
        }
        else if(ct.equalsIgnoreCase("Homicide")){
            crimeType = HOMICIDE;
        }

        return crimeType;
    }
}

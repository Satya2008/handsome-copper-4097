package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Map;
import java.util.Scanner;

import controller.CrimeController;
import controller.CriminalController;
import model.Crime;
import model.CrimeType;
import model.Criminal;
import model.UpdateCrime;

public class CrimeManagementSystem {
    static CrimeController crimeController = new CrimeController();
    static CriminalController criminalController = new CriminalController();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to CrimeManagementSystem :");
        while (true){
            System.out.println("1. Start :");
            System.out.println("2. EXIT");
            int s = in.nextInt();
            switch (s){
                case 1 :
                    System.out.println("Select User Type :");
                    System.out.println("1. Admin");
                    System.out.println("2. Public");
                    int ut = in.nextInt();
                    switch (ut){
                        case 1:
                            performAdminActivities();
                            break;
                        case 2:
                            performPublicActivities();
                            break;
                    }
                case 2:
                    System.exit(0);
            }
        }

    }

    private static void performPublicActivities() throws ParseException {
        while(true){
            System.out.println("Welcome to public domain !!");
            System.out.println("You are allowed to do below activities. Select any of them :");
            System.out.println("1. Search criminal by name");
            System.out.println("2. Search crime by description");
            System.out.println("3. View total crime for each police station for a date range");
            System.out.println("4. View total crime for each crime type for a date range");
            System.out.println("5. Switch User type");
            System.out.println("6. Exit");

            int pub = in.nextInt();
              in.nextLine();
            switch (pub){
                case 1 :
                    System.out.println("Enter Criminal name :");
                    String cname = in.nextLine();
                    Criminal criminal = criminalController.searchCriminalByName(cname);
                    if(criminal == null) {
                    	System.out.println("No Criminal found of this name");
                    }else {
                    	  System.out.println("Criminal Detail :");
                    System.out.println(criminal.toString());
                    }
                  
                    
                   
                    break;
                case 2 :
                    System.out.println("Enter crime description :");
                    String desc = in.nextLine();
                    Crime crime = crimeController.searchCrimeByDesc(desc);
                    System.out.println("Crime Detail :");
                    System.out.println(crime.toString());
                    
                    break;
                case 3:
                    System.out.println("Enter PS :");
                    String ps = in.nextLine();
                    System.out.println("Enter from date (dd/MM/yyyy):");
                    String d1 = in.nextLine();
                    Date from = CMSUtil.dateConverter(d1);

                    System.out.println("Enter to date :");
                    String d2 = in.nextLine();
                    Date to = CMSUtil.dateConverter(d2);

                    Map<String, Integer> psCrime = crimeController.totalCrimeByPS(ps, from, to);
                    for(Map.Entry<String, Integer> e : psCrime.entrySet()){
                        System.out.println(e.getKey()+" : "+e.getValue());
                    }
                    break;
                case 4:
                    System.out.println("enter crime type : ");
                    String ct = in.nextLine();
                    CrimeType crimeType = CrimeType.getCT(ct);
                    System.out.println("Enter from date (dd/MM/yyyy):");
                    String d11 = in.nextLine();
                    Date from1 = CMSUtil.dateConverter(d11);

                    System.out.println("Enter to date :");
                    String d22 = in.nextLine();
                    Date to1 = CMSUtil.dateConverter(d22);

                    Map<CrimeType, Integer> ctCrime = crimeController.totalCrimeByType(crimeType, from1, to1);
                    for(Map.Entry<CrimeType, Integer> e : ctCrime.entrySet()){
                        System.out.println(e.getKey().name()+" : "+e.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Switch to admin");
                  
                    performAdminActivities();
                   
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }

    private static void performAdminActivities() throws ParseException {
        boolean adminLogin = false;
        in.nextLine();
        System.out.println("username :");
        String username = in.nextLine();
        System.out.println("password :");
        String pass = in.nextLine();

        if(username.equals("admin") && pass.equals("admin")){
            adminLogin = true;
            System.out.println("Admin log in successfull !!");
            while(true){
                System.out.println("Welcome Admin !!");
                System.out.println("You are allowed to do below activities. Select any of them :");
                System.out.println("1. addCrimeDetail");
                System.out.println("2. updateCrimeType");
                System.out.println("3. deleteCrimeByCrimeId");
                System.out.println("4. addCriminalToCrime");
                System.out.println("5. removeCriminalToCrime");
                System.out.println("6. addCriminalDetail");
                System.out.println("7. updateCriminalDetail");
                System.out.println("8. deleteCriminalByCriminalId");
                System.out.println("9. Search criminal by name");
                System.out.println("10. Search crime by description");
                System.out.println("11. View total crime for each police station for a date range");
                System.out.println("12. View total crime for each crime type for a date range");
                System.out.println("13. Exit");
                System.out.println("14. switch to public");
                
                int adm = in.nextInt();
                in.nextLine();
                switch(adm) {
                case 1:
                  System.out.println("Please enter Crime Type : ");
                  String t = in.nextLine();
                 CrimeType type = CrimeType.getCT(t);
                  System.out.print("Please enter Description : ");
                  String Desc = in.nextLine();
                  System.out.print("Please enter psArea : ");
                  String psArea = in.nextLine();
                  System.out.print(" Please enter Date of Crime : ");
                  String d = in.nextLine();
                  
                  Date date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
                  System.out.print("Victim name: ");
                  String victim = in.nextLine();
                  Crime crime = new Crime(type, Desc, psArea, date,  victim);
                   String res = crimeController.addCrimeDetail(crime);
                   System.out.println(res);
                    break;
                case 2:
                	System.out.print("Enter crime ID: ");
                	int crimeId = in.nextInt();
                	in.nextLine();

                	System.out.print("Enter new crime type: ");
                	UpdateCrime updateCrime = new UpdateCrime(CrimeType.ROBBERY, null, null, null, null);
                
                	String done = crimeController.updateCrimeType(crimeId, updateCrime);
                
                	      
                	    System.out.println(done);
                
                    break;
                case 3:
                    // code to delete crime by crime id
                    break;
                case 4:
                    // code to add criminal to crime
                    break;
                case 5:
                    // code to remove criminal from crime
                    break;
                case 6:
                    // code to add criminal detail
                    break;
                case 7:
                    // code to update criminal detail
                    break;
                case 8:
                    // code to delete criminal by criminal id
                    break;
                case 9:
                    // code to search criminal by name
                    break;
                case 10:
                    // code to search crime by description
                    break;
                case 11:
                    // code to view total crime for each police station for a date range
                    break;
                case 14:
                    System.out.println("Switch to public");
                   
                    performPublicActivities();
                  
                    break;
                case 12:
                    // code to view total crime for each crime type for a date range
                    break;
                case 13:
                    return; // exit the method
                default:
                    System.out.println("Invalid choice, please try again");
                }
                
            }
        }else{
            System.out.println("Admin log in Failed !!");
            return;
        }

    }
}

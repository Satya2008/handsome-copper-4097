package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CMSUtil {

    public static Date dateConverter(String s){
        Date date = null;
        try{
            date = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        }catch (ParseException e){
            System.out.println("enter date in (dd/MM/yyyy) format only.");

        }

        return date;
    }
}

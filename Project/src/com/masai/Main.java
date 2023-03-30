package com.masai;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception{
	Crime a1 = new Crime("Rob", "dhdhd", "Bhimpura", "20/02/2022", "gaG");
     System.out.println(a1);
     a1.writeCrime();
}
}
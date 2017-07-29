/**
 * Author: Jose Rosario-Lopez
 * Date: March 8, 2017
 * Program Purpose: This program serves to test the Coin class. 
 * 					Four (4) coins are tested: quarter, dime, nickel, and penny.
 * Input: The face value of each coin (randomly generated). Accept decimal numbers.
 * Output: The ending balance
 */


package edu.unlv.is380.assignment3;

import java.text.DecimalFormat;

public class FourCoinTossing {
	public static void main(String[] args) {
		
		//Define the format of the numbers
		DecimalFormat formatter = new DecimalFormat("$#0.00");
		
		//Starting balance
		double balance = 0.0;
		
		//Create the four coins
		Coin quarter = new Coin();
		Coin dime	 = new Coin();
		Coin nickel  = new Coin();
		Coin penny 	 = new Coin();
		
		// Setting the face value of each coin
		quarter.setFaceValue(0.25);
		dime.setFaceValue(0.10);
		nickel.setFaceValue(0.05);
		penny.setFaceValue(0.01);
		
		//Toss the quarter
		//If it lands heads-up, add 25 cents to the balance
		quarter.toss();
		System.out.println("Quarter landed on: " + quarter.getSideUp());
		
		
		//if side is heads
		if ( quarter.getSideUp().equals("Heads") ) 
		{			
			balance = balance + quarter.getFaceValue();
		}
		
		
		
		//Toss the dime
		//If the dime lands heads-up, add 10 cents to the balance
		dime.toss();
		System.out.println("Dime landed on: " + dime.getSideUp());
		
		if (  dime.getSideUp().equals("Heads")  ) 
		{
			balance = balance + dime.getFaceValue();
		}
		
		
	
		//Toss the nickel
		//If the nickel lands heads-up, add 05 cents to the balance
		nickel.toss();
		System.out.println("Nickel landed on: " + nickel.getSideUp());
		
		if (  nickel.getSideUp().equals("Heads")  ) 
		{
			balance = balance + nickel.getFaceValue();
		}
				
				
				
				
		//Toss the penny
		//If the penny lands heads-up, add 01 cent to the balance
		penny.toss();
		System.out.println("Penny landed on: " +  penny.getSideUp());
		
		if (  penny.getSideUp().equals("Heads")  ) 
		{
			balance = balance + penny.getFaceValue();
		}
		
		
		System.out.println( "-----------------------------" );
		System.out.print("The ending balance is: ");
		
		//	Print the balance using the formatter
		System.out.println( formatter.format(balance) );
		System.out.println("-----------------------------" );
		
	} // end main
	
} // end TwoCoinTossing

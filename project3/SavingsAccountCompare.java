/**
 * Author: Jose Rosario-Lopez
 * Date: March 8, 2017
 * Program Purpose: This program's main purpose is to test the Savings Account class
 * Input: Starting balance, monthly interest rate, withdraw amount, deposit amount, 
 * 		  and the number of months that have passed since the amount was established.
 * 		  Accept decimal numbers and Strings
 * Output: The ending balance
 */


package edu.unlv.is380.assignment3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class SavingsAccountCompare {
	
	/**
    * Displays the details of the savings account
    */
	public static void main(String[] args) {
		
		// fields
		double startingBalance = 0.0;
		double annualInterestRate = 0.0;
		int months;
		double depositAmount = 0.0; 
        double withdrawAmount = 0.0; 
        
        // Custom format for the balance output
        DecimalFormat dollar = new DecimalFormat("###,###,##0.00");
        
		// Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);

	    // Ask user to enter starting balance
	    System.out.print("Enter starting balance: $");
	    startingBalance = keyboard.nextDouble();

	    // Ask user for annual interest rate
	    System.out.print("Enter the annual interest rate:");
	    annualInterestRate = keyboard.nextDouble();

	    // Ask how long account was opened
	    System.out.print("Enter the number of months: ");
	    months = keyboard.nextInt();

	    // Output a new blank line
	    System.out.println();  
	    
	    // Create a new object (based on the SavingsAccount class) and passing the values entered by user
	    SavingsAccount account = new SavingsAccount( annualInterestRate, startingBalance);

	    // Loop through as many months the user entered
	    for (int i = 1; i <= months; i++) {
	       
	        // Get amount to withdraw each month
	        System.out.print("Enter amount to withdraw for month " + i + ": $");
	        withdrawAmount = keyboard.nextDouble();
	
	        // Subtract the withdrawals
	        account.withdraw(withdrawAmount);
	        
	        // Get amount to deposit each month
	        System.out.print("Enter amount to deposit for month: " + i + ": $");
	        depositAmount = keyboard.nextDouble();

	        // Add deposit amount
	        account.deposit(depositAmount);
	        
	        // Add the monthly interest earned
	        account.addInterest();

	        // Output the balance (formatted) for each month
	        System.out.println("The balance at the end of month " + i + " is: $" +  dollar.format( account.getBalance() ) );
	        System.out.println(); 
	        
	    } // end for-loop

	    // close keyboard
	    keyboard.close();

	    // Output the ending balance (formatted)
        System.out.println("The ending balance is: $" + dollar.format( account.getBalance() )); 
	    
	} //end main();


} //end SavingsAccountCompare class

/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program calculates the payroll information for different employees. 
 * Input: Employees' name, pay rate, and number of hours he/she worked last week.
 * Output: Payroll information
 */

package edu.unlv.is380.assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollDemo {

	public static void main(String[] args) {
		
		// Variable to hold user's input
		Scanner kb = new Scanner(System.in);
		
		// Flag for when the loop should stop
		String moreItem ="y"; 
		
		// Create an ArrayList to hold objects.
		ArrayList<Object> listOfObjects = new ArrayList<Object>();
		
		// Variable to hold total wage amount
		double totalWage = 0;
		
		// While the user wishes to continue entering data
		while (moreItem.equalsIgnoreCase("y")) {
			
			System.out.print( "\n" );
			
			// Prompt user to enter name
			System.out.print("Please enter the name of the employee: ");
			String empName = kb.nextLine();

			// Prompt user to enter pay rate
			System.out.print("Please enter the pay rate: ");
			double payRate = kb.nextDouble();

			// Prompt user to enter numbers of hours worked last week
			System.out.print("Please enter the number of hours worked: ");
			int numOfHours = kb.nextInt();

			// Creating a new object, based on the Payroll class.
			Payroll line = new Payroll(empName, payRate, numOfHours);
			
			// Adding the object to the ArrayList
			listOfObjects.add(line);
		
			// Consume the enter key
			kb.nextLine();
			
			// Ask the user if they would like to add additional items
			System.out.print("Enter additional payroll information? (Y/N) ");
			
			moreItem = kb.nextLine().substring(0,1);

		} //end while-loop

			System.out.println("\r");
			System.out.println("The payroll information entered:");
		 
			// Display the object
			System.out.print( listOfObjects.toString() );

	      // Loop through the array list and output the total wage to pay
	      for(int i=0; i < listOfObjects.size(); i++) {
	    	  totalWage += ((Payroll) listOfObjects.get(i)).calWage() ;
	      }
	      
	      // Display total wage
	      System.out.println("\r");
	      System.out.println("The total wage to pay is: $" + totalWage );
		
	} // end main()

}

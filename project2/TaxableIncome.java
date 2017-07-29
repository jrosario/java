/**
 * Author: Jose Rosario-Lopez
 * Date: February 21, 2017
 * Program Purpose: 		This program will compute the income tax for an individual.
 * 							The program will ask the user to enter the total taxable income for the year, then
 * 							based on the tax bracket, it will calculate the tax amount due to the user.
 * Input:			int		Accept integer (positive) numbers.
 * Output:			String	Output patterns based on user input. 
 */

package edu.unlv.is380.assignment2;

//Import the Scanner class for user input
import java.util.Scanner;

public class TaxableIncome {

	private static Scanner userInput;

	public static void main(String[] args) {
		
		// Total taxable income of the year entered by the user
		double income = 0.00;		
		
		// Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);

	    // Get the user's input
		System.out.print("Please enter the total taxable income: ");
		
		// Repeat until the user enters a valid value
		while (!keyboard.hasNextDouble()) {
			
			// Read and discard the invalid input
			keyboard.next();
						
			// Ask the user again for a valid input
			System.out.print("Please enter a valid taxable income: ");
			
		}
		
		// The user has entered a valid integer. Store this and proceed.
		 income = keyboard.nextDouble();
		
		// Print a new line
		System.out.println();
		
		// Run the calculation based on user input
		calculateTax(income);
	}
	
	
	
	/**
	 * The purpose of this method is to calculate the total taxable income of the year.
	 * 
	 * The program then uses the tax bracket (as shown below) to calculate the tax amount:
	 *		10% on taxable income from $0 to $9,325, plus
	 *		15% on taxable income over $9,325 to $37,950, plus 
	 *		25% on taxable income over $37,950 to $91,900, plus 
	 *		28% on taxable income over $91,900 to $191,650, plus 
	 *		33% on taxable income over $191,650 to $416,700, plus 
	 * 		35% on taxable income over $416,700 to $418,400, plus 
	 *		39.60% on taxable income over $418,400
	 *	
	 * @param income 	This is the value entered by the user
	 * @void 			Display the user's tax rate & total tax due to the end-user.
	 */
	private static void calculateTax(double income) {
		
		// These are the tax rates
		final double A_TAXRATE = 0.10;
		final double B_TAXRATE = 0.15;
		final double C_TAXRATE = 0.25;
		final double D_TAXRATE = 0.28;
		final double E_TAXRATE = 0.33;
		final double F_TAXRATE = 0.35;
		final double G_TAXRATE = 0.396;
		
		
		// These are the range brackets that a user will fall within
		final int A_BRACKET = 0;
		final int B_BRACKET = 9325;
		final int C_BRACKET = 37950;
		final int D_BRACKET = 91900;
		final int E_BRACKET = 191650;
		final int F_BRACKET = 416700;
		final int G_BRACKET = 418400;
				
		// To hold the value 
		double difference = 0;
		
		// Accumulator initialized to 0
		double total = 0;
		
		// If the number entered is less than 0, display a user-friendly error message.
		if(income < 0) 
		{
			userInput = new Scanner(System.in);
			System.out.println("Invalid input. Please enter a positive value.");
			
			// Repeat until next item is an integer
			while (!userInput.hasNextDouble()) 
			{        
				// Read and discard the invalid input
				userInput.next(); 
				
				// Re-prompt
			    System.out.print("Please enter an integer: "); 
			}
			
			// Get the integer
			income = userInput.nextDouble();
			
		} 
		else if (income >= A_BRACKET && income <= B_BRACKET ) 
		{ 
			
			//Tax rate of 10%
			total = income * A_TAXRATE;
			
			System.out.println("Tax Rate: " + A_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		}
		else if ( income >=B_BRACKET && income <= C_BRACKET ) 
		{	
				
			//Tax rate of 15%
			
			difference = C_BRACKET - B_BRACKET;
			total = (B_BRACKET * A_TAXRATE) + (difference * B_TAXRATE);
			
			System.out.println("Tax Rate: " + B_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else if ( income >= C_BRACKET && income <= D_BRACKET ) 
		{
			//Tax rate of 25%
			
			difference = D_BRACKET - C_BRACKET;
			
			total = (B_BRACKET * A_TAXRATE) + 
					( (C_BRACKET - B_BRACKET) * B_TAXRATE) + 
					(difference * C_TAXRATE);
			
			System.out.println("Tax Rate: " + C_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else if ( income >= D_BRACKET && income <= E_BRACKET ) 
		{
			// Tax rate of 28%
			difference = E_BRACKET - D_BRACKET;
			
			total = (B_BRACKET * A_TAXRATE) + 
					( (C_BRACKET - B_BRACKET) * B_TAXRATE) + 
					( (D_BRACKET - C_BRACKET) * C_TAXRATE) + 
					(difference * D_TAXRATE);
			
			System.out.println("Tax Rate: " + D_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else if ( income >= E_BRACKET && income <= F_BRACKET ) 
		{
			// Tax rate of 33%
			difference = F_BRACKET - E_BRACKET;
			
			total = (B_BRACKET * A_TAXRATE) + 
					( (C_BRACKET - B_BRACKET) * B_TAXRATE) + 
					( (D_BRACKET - C_BRACKET) * C_TAXRATE) + 
					( (E_BRACKET - D_BRACKET) * D_TAXRATE) + 
					(difference * E_TAXRATE);
			
			System.out.println("Tax Rate: " + E_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else if ( income >= F_BRACKET && income <= G_BRACKET ) 
		{
			// Tax rate of 35%
			difference = G_BRACKET - F_BRACKET;
			
			total = (B_BRACKET * A_TAXRATE) + 
					( (C_BRACKET - B_BRACKET) * B_TAXRATE) + 
					( (D_BRACKET - C_BRACKET) * C_TAXRATE) + 
					( (E_BRACKET - D_BRACKET) * D_TAXRATE) +
					( (F_BRACKET - E_BRACKET) * E_TAXRATE) +
					(difference * F_TAXRATE);
			
			System.out.println("Tax Rate: " + F_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else if ( income > G_BRACKET) 
		{
			// Tax rate of 39.6%
			total = (B_BRACKET * A_TAXRATE) + 
					( (C_BRACKET - B_BRACKET) * B_TAXRATE) + 
					( (D_BRACKET - C_BRACKET) * C_TAXRATE) + 
					( (E_BRACKET - D_BRACKET) * D_TAXRATE) + 
					( (F_BRACKET - E_BRACKET) * E_TAXRATE) +
					( (G_BRACKET - F_BRACKET) * F_TAXRATE) +
					(income - G_BRACKET) * G_TAXRATE;
			
			System.out.println("Tax Rate: " + G_TAXRATE * 100 + "%");
			System.out.println("Income Tax: $" + total);
		} 
		else {
			System.out.println("Invalid value.");		
		}
		
		System.out.println();

	}
} // end TaxableIncome()

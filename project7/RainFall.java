/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program collects data and calculates the average rainfall over a period of years.  
 * Input: The number of years, the rainfall (in inches) for each month
 * Output: Number of months, total rainfall, average monthly rainfall
 */

package edu.unlv.is380.extracredit1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RainFall {

	public static void main(String[] args) {
			// Variable to hold the number of years
			int numberOfYears;
			
			// Variable to hold the number of month
			int numberOfMonths;
			
			// Variables used to do calculations
			double totalInchesOfRainfall = 0; 
			double averageRainfallPerMonth = 0; 
			double accumulatedRainfall = 0; 
			
			DecimalFormat formatter = new DecimalFormat("#0.00");
			
			// Create a Scanner object for keyboard input.
			Scanner kb = new Scanner(System.in);
			
			// Get the number of years.
			System.out.print("Enter the number of years: ");
			numberOfYears = kb.nextInt();
			
			// Validate the input for number of years.
			while(numberOfYears < 1) 
			{
				// Display error message
				System.out.print("Invalid. Enter 1 or greater: ");
				numberOfYears = kb.nextInt();
			}
			
			// Calculate total number of months
			numberOfMonths = numberOfYears * 12;
			
			// Visual instruction for the user 
			System.out.println("Enter the rainfall, in inches, for each month.");
			
			// Loop through the total number of years (rows)
			for(int i=1; i <= numberOfYears; i++)
			{
				// Loop through the 12 months for that year (cols)
				for (int j=1; j<=12; j++) {
					
					// Create a Scanner object for user's input.
					Scanner inputRainfall = new Scanner(System.in);
					
					// Display the following format: Year X month Y, e.g., Year 1 month 6.
					System.out.print("Year " + i + " month  " + j + ": ");
					
					// Store the input value into 'totalInchesOfRainfall' variable
					totalInchesOfRainfall = inputRainfall.nextDouble();
					
					// Additional user input validation
					while(totalInchesOfRainfall < 0) 
					{
						// Display error message
						System.out.print("Invalid. Enter 0 or greater: ");
						totalInchesOfRainfall = inputRainfall.nextDouble();
					}
					
					// Adding the totalInchesOfRainfall
					accumulatedRainfall += totalInchesOfRainfall;
				} //end inner for-loop
			} //end outer for-loop
			
			// Calculate and display the average rainfall per month
			averageRainfallPerMonth = accumulatedRainfall / numberOfMonths;
			
			// Display the number of months
			System.out.println("Number of Months: " + numberOfMonths);
			
			// Display the total inches of rainfall
			System.out.println("Total rainfall: " + accumulatedRainfall + " inches");
			
			// Display the average monthly rainfall
			System.out.println("Average monthly rainfall: " + formatter.format(averageRainfallPerMonth) + " inches");

	}

}

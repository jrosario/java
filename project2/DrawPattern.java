/**
 * Author: Jose Rosario-Lopez
 * Date: February 21, 2017
 * Program Purpose: 		This program will draw a certain pattern. 
 * 							Based on the number entered by the user, a set of (reversed) triangles will be displayed on the screen. 
 * 							NOTE: This program will accept only positive integers.
 * Input:			int		Accept integer (positive) numbers.
 * Output:			String	Triangle patterns based on user input. 
 */

package edu.unlv.is380.assignment2;

// Import the Scanner class for user input
import java.util.Scanner;

public class DrawPattern {

	public static void main(String[] args) {
		
		// Placeholder variable for number (entered by user)
		int num; 
		
		// Create a Scanner object for keyboard input.
		Scanner kb = new Scanner(System.in);
		
		// Get the user's input.
		System.out.print("Please enter a positive integer: ");
		
		// Set number entered
		num = kb.nextInt();
		
		// Validate the number entered.
		while (num <= 0) {
			System.out.print("Please enter a positive integer: ");
			num = kb.nextInt();
		}
	
		// Assigning the character design pattern
		String characterA = "#";
		String characterB = "*";
	
		//Count the number entered by the user, and use that as the total number of (vertical) lines to display
		for (int i = 0; i < num; i++) {
			
			// Display the left part of the triangle.
			for(int j=0; j <= i; j++){
				System.out.print(characterA);
			}
			
			// Display the middle part of the triangle.
			for (int k = num*2-1; k > i*2; k--) {
				System.out.print(characterB);
			}

			// Display the right part of the triangle.
			for(int j=0; j <= i; j++){
				System.out.print(characterA);
			}
			
			// Display a new line  
			System.out.println();
			
		} //end outer-most loop	
	} // end main
} // end DrawPattern

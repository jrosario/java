/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program writes all the odd numbers between the lower bound and the upper bound (inclusive) to the destination file.
 * Input: destination file, lower bound number, and upper bound number
 * Output: All the odd numbers between the lower bound and the upper bound (inclusive).
 */

package edu.unlv.is380.extracredit1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OddNumbers {

	// IOException is a more broad way to handle exceptions
	public static void main(String[] args) throws IOException {
		// Store filename
		String filename;
		
		 // Variable to hold the lower bound
	    int lowerBound = 0;  
	    
	    // Variable to hold the upper bound
	    int upperBound = 0;

	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);

	    // Get the filename.
	    System.out.print("Please enter the filename: ");
	    filename = keyboard.nextLine();
	    
	    // Get the lower bound number
	    System.out.print("Please enter an integer as the lower bound: ");
	    lowerBound = keyboard.nextInt();
	    
	    // Get the upper bound number
	    System.out.println("Please enter an integer as the upper bound");
	    System.out.print("(NOTE: The upper bound should be greater than the lower bound.): ");
	    upperBound = keyboard.nextInt();

	    //Consume the remaining newline character.
	    keyboard.nextLine();
  
	    // Open the file.
	    FileWriter fw = new FileWriter(filename, true);
	    PrintWriter outputFile = new PrintWriter(fw);
  
	    // Get data and write it to the file.
	    for (int i = lowerBound; i <= upperBound; i++) {

	    	// If the number is not divisible by 2, then it is odd
	    	if( i % 2 != 0){
                // Command-line preview of the output
	    		//System.out.print(i + " ");
	    		
	    		// Write the result to the file.
		    	outputFile.println( i );
	    	}
	    	
	    }// end for loop
  
	    // Close the file.
	    outputFile.close();
	    
	    // Display to the user that the data has been written to the destination file
	    System.out.println("Data written to the file.");

	}

}

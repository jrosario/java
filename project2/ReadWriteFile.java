/**
 * Author: Jose Rosario-Lopez
 * Date: February 21, 2017
 * Program Purpose: 		This program will draw a certain pattern. 
 * 							Based on the number entered by the user, a set of (reversed) triangles will be displayed on the screen. 
 * 							NOTE: This program will accept only positive integers.
 * Input:			String	The source (input) file to read into the program
 * Output:			String	The destination (output) filename. 
 * 							Once entered, the file contents from the source file will be copied into the destination file.
 */

package edu.unlv.is380.assignment2;

// Importing the necessary classes
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Create a Scanner object for keyboard input.
	      Scanner keyboard = new Scanner(System.in);
	      
	      // To hold the line number
	      String line;

	      // Get the source file.
	      System.out.print("Please enter the source filename: ");
	      String filename = keyboard.nextLine();

	      // Open the file and read its contents.
	      File file = new File(filename);
	      Scanner inputFile = new Scanner(file);

	      // Get the destination source.
	      System.out.print("Please enter the destination filename: ");
	      String output = keyboard.nextLine();
	      
	      // Open the file and write to it.
	      FileWriter fw = new FileWriter(output, true);
	      PrintWriter outputFile = new PrintWriter(fw);
	      
	      // Counter initialized at 1
	      int count = 1;
	      
	      // Read the next line in the file
	      while(inputFile.hasNext()) {
	    	  
	    	  // Read the first line from the file.
	    	  line = inputFile.nextLine();
	      
	    	  // Display the line in the console (useful for debugging)
	    	  System.out.println(count + ": " + line );
	    	   
	    	  // Write the content into the file.
	 	      outputFile.println(count + ": " + line );  
	    
	 	      // Increase counter by 1
	 	      count = count + 1;	
	      
	      } // end while-loop
	      
	        
	      // Close the input file reference.
	      inputFile.close();
	      
	      // Close the output file reference.
	      outputFile.close();
	      
	      // User-friendly message
	      System.out.println("Success! Data was written to the destination file.");
	
	} // end main()
	
	
} //end ReadWriteFile

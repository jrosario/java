/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program calculates the average between three test scores and returns a letter grade
 * Input: Three test scores
 * Output: The letter grade
 */

package edu.unlv.is380.extracredit1;

import java.util.Scanner;

public class AverageScore {

	public static void main(String[] args) {
		//  Variable to store the average test scores
		int average = 0; 
		
		// Variable to store the letter grade
		String grade;
		
		// Variable to store test score #1
	    int firstTestScore = 0;
	    
	    // Variable to store test score #2
	    int secondTestScore = 0;
	    
	    // Variable to store test score #3
	    int thirdTestScore = 0;

	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);

	    // Get the filename.
	    System.out.print("Please enter the first score: ");
	    firstTestScore = keyboard.nextInt();
	    
	    // Get the lower bound number
	    System.out.print("Please enter the second score: ");
	    secondTestScore = keyboard.nextInt();
	    
	    // Get the upper bound number
	    System.out.print("Please enter the third score: ");
	    thirdTestScore = keyboard.nextInt();

	    // Consume the remaining newline character.
	    keyboard.nextLine();
	    
	    // Get the average of the test scores and assigning it to the 'average' variable
	    average = getAverageScore(firstTestScore, secondTestScore, thirdTestScore);
	    
	    // Output into the console
	    //System.out.print(average);
	    
	    // Get the letter grade and assign it to 'grade' variable
	    grade = calculateGrade(average);
	    
	    // Display the average and the associated letter grade
	    System.out.print("The average score is: " + average + ", which is " + grade);
	    

	} //end main
	
	/**
	 * The purpose of this method is to calculate the average test score, based on three test scores
	 * @param int Test score #1
	 * @param int Test score #2
	 * @param int Test score #3
	 * @return int The average of the three test scores
	 */
	private static int getAverageScore(int scoreOne, int scoreTwo, int scoreThree) {
		return (scoreOne + scoreTwo + scoreThree) / 3;
	}
	
	
	
	/**
	 * The purpose of this method is to determine the letter grade. The letter grade is determined by the switch-case.
	 * @param int Accepts the test overall average score as the parameter 
	 * @return string The letter grade
	 */
	private static String calculateGrade(int average) {
		
		// Variable to hold the letter grade that will be shown to the user.
		String letterGrade;
		
		// Divide the average by 10. If it matches a case, assign it that respective letter value. Otherwise, assign it an 'F' grade.
		switch (average/10)
		{
		 case 9: letterGrade = "A";
         break;
		 
		 case 8: letterGrade = "B";
		 break;
		 
		 case 7: letterGrade = "C";
         break;
		 
		 case 6: letterGrade = "D";
		 
		 default:
         letterGrade = "F"; 
		}

		// Return the letter grade that invoked the calculateGrade() function
		return letterGrade;
	}
	

}

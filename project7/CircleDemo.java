/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program is to test the Circle class.
 * Input: Radius
 * Output: The area, diameter and circumference of the clock.
 */

package edu.unlv.is380.extracredit1;

import java.util.Scanner;

public class CircleDemo {

	public static void main(String[] args) {
		// Variable to store the user's input
		double radius = 0;
		
		// Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	    
	    // Prompt the user to enter the radius
	    System.out.print("Please enter the circle's radius: ");
	    
	    // Store this value into the 'radius' variable
	    radius = keyboard.nextDouble();
	    
	    // Create a Circle object named clock. Pass the user's input in to the Circle class.
	    Circle clock = new Circle(radius);
	   
	    // Print out the area, diameter and circumference of the clock.
	    System.out.println( "The area is: " + clock.getArea() );
	    System.out.println( "The diameter is: " +  clock.getDiameter() );
	    System.out.println( "The circumference is: " + clock.getCircumference() );
	
	}

}

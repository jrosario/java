/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program sets and gets the necessary fields to print out the area, diameter and circumference of the clock.
 * Input: Radius
 * Output: Area, Diameter, and Circumference of the clock
 */

package edu.unlv.is380.extracredit1;

public class Circle {
	// A variable to hold the user input
	private double radius;
	
	// A final double initialized
	public final static double PI = 3.1415926;
	
	
	/**
	 * Accepts the radius as an argument. Sets this input as the radius
	 * @param double radius
	 */
	public Circle(double rad) {
		radius = rad;
	}
	
	/**
	 * No-arg constructor. Default to 10.
	 */
	public Circle() { 
		radius = 10;
	}

	/**
	 * A get method for the radius field.
	 * @return double The radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 *  A set method for the radius field that sets the radius with the value that the user entered
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 *  Returns the area, which is calculated as: area = PI * radius * radius
	 * @return double The area of the clock
	 */
	public double getArea() {
		return PI * radius * radius;
	}
	
	/**
	 * Returns the diameter, which is calculated as: diameter = radius *2
	 * @return double The diameter of the clock
	 */
	public double getDiameter() {
		return radius * 2;
	}
	
	/**
	 * Returns the circumference, which is calculated as: circumference = 2 * PI * radius
	 * @return double The circumference of the clock
	 */
	public double getCircumference() {		
		return 2 * PI * radius;
	}
	
} //end Circle class

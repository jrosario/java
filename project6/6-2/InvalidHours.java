package edu.unlv.is380.assignment6;

public class InvalidHours extends Exception {

	public InvalidHours(double h){
		super("An invalid number is given for the number of hours worked: " + h);
	}
}

package edu.unlv.is380.assignment6;

public class InvalidPayRate extends Exception {
	public InvalidPayRate(double r){
		super("An invalid number is given for the hourly pay rate: "+r);
	}
}

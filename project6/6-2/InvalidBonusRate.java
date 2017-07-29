package edu.unlv.is380.assignment6;

public class InvalidBonusRate extends Exception {
	/**
	* InvalidBonusRate is a Class. It extends the Exception
	*/
	public InvalidBonusRate(double br){
		// when e.getMessage() is called, it goes here to print the message.
		// This is another example of calling the super class constructor
		super("An invalid number is given for the bonus rate: " + br);
	}

}

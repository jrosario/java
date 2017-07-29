package edu.unlv.is380.assignment6;

import java.text.DecimalFormat;

/**
 * The program simulates the behavior of a pay roll.
 * @author Han-fen Hu
 *
 */

public class PayRoll {
	//Field
	String name;		// to hold the name of the employee
	double hoursWorked;	// to hold the hours the employee worked
	double payRate;		// to hold the pay rate of this pay roll
	
	// Constant
	final double MIN_PAY_RATE = 10.00;	// The minimum pay rate
	
	/**
	 * The constructor that sets the value of name, hours worked, and pay rate.
	 * @param n Name of the employee who gets the pay.
	 * @param h Hours the employee worked.
	 * @param r Pay rate of the pay roll.
	 * @throws InvalidHours When the numbers of hours is negative or greater than 84.
	 */
	public PayRoll (String n, double h, double r) throws InvalidHours, InvalidPayRate{
		this.name=n;
		
		if (h<0 | h > 84)
			throw new InvalidHours(h);
		else 
			this.hoursWorked = h;

		if (r<MIN_PAY_RATE | r > 25)
			throw new InvalidPayRate(r);
		else
			this.payRate = r;
	}

	/**
	 * The getName method returns the name of the employee
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setName method sets the name of the employee
	 * @param name The name of the employee;
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The getHoursWorked method returns the hours the employee worked.
	 * @return the hours the employee worked for this pay roll period
	 */
	public double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * The setHoursWorked method sets the number of hours the employee worked
	 * @param h The number of hours the employee worked
	 * @throws NegativeAmount When the numbers of hours the employee worked is negative
	 */
	public void setHoursWorked(double h) throws InvalidHours{
		if (h<0)
			throw new InvalidHours(h);
		else 
			this.hoursWorked = h;
	}

	/**
	 * The getPayRate method returns the pay rate of the pay roll.
	 * @return the pay rate
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * The setPayRate method sets the pay rate of the pay roll.
	 * @param r The pay rate
	 * @throws InvalidPayRate 
	 */
	public void setPayRate(double r) throws InvalidPayRate {
		if (r<MIN_PAY_RATE | r > 25)
			throw new InvalidPayRate(r);
		else
			this.payRate = r;
	}
	
	/**
	 * The calcGrossPay method calculates and returns the gross pay
	 * @return The gross pay of the pay roll
	 */
	public double calcGrossPay () {
		return hoursWorked * payRate;
	}
	
	/** 
	 * The toString method returns the content of the object
	 * @return The content of the object
	 */
	public String toString(){
		// Define the formatter for the output
		DecimalFormat formatter = new DecimalFormat("0.00");
		
		return name + " worked for " + hoursWorked +" hours.\n"+
				"The pay rate is " + payRate +" per hour.\n"+
				"The gross pay is $" + formatter.format(this.calcGrossPay());
	}
}

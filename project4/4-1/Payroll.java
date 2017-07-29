/**
 * Author: Han-fen Hu
 * Date: 2017.03.20
 * Program Purpose: This program simulates the data and behavior of a payroll.  
 */
package edu.unlv.is380.assignment4;

public class Payroll {
	// constants
	public final double MINIMUM_RATE = 10.25;	// defines the minimum hourly pay rate
	public final int REGULAR_HOUR = 40;		// defines the number of regular hours
	public final double OVERTIME_RATE = 1.5;	// defines the pay rate for overtime hours
	
	// fields
	private String empName; // employee name
	private double payRate; // payRate for an employee
	private int numOfHours; // hours worked for an employee
	
	// no-arg constructors. It will set the empName to null, payrate and numOfHours to 0.
	public Payroll(){}

	/**
	 * parameterized constructor. It accepts value for each field
	 * @param empName
	 * @param payRate
	 * @param numOfHours
	 */
	public Payroll(String n, double r, int h) {
		empName = n;
		
		// if the rate is less than the minimum pay rate
		// set it to the minimum pay rate
		if (r < MINIMUM_RATE)
			payRate = MINIMUM_RATE;
		else
			payRate = r;
		
		// if the hours is negative, set it to 0
		if (h<0)
			numOfHours = 0;
		else
			numOfHours = h;
	}

	// getters and setters
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double rate) {
		// if the rate is less than the minimum pay rate
		// set it to the minimum pay rate
		if (rate < MINIMUM_RATE)
			payRate = MINIMUM_RATE;
		else
			payRate = rate;
	}

	public void setPayRate(String rateString) {
		// convert the string to a double number
		double rate = Double.parseDouble(rateString);

		// if the rate is less than the minimum pay rate
		// set it to the minimum pay rate
		if (rate < MINIMUM_RATE)
			payRate = MINIMUM_RATE;
		else
			payRate = rate;
	}
	
	public int getNumOfHours() {
		return numOfHours;
	}

	public void setNumOfHours(int numOfHours) {
		// if the hours is negative, set it to 0
		if(numOfHours<0)
			this.numOfHours=0;
		else 
			this.numOfHours = numOfHours;
	}
	
	public void setNumOfHours(String hourString){
		// convert String to a integer number
		int hours = Integer.parseInt(hourString);
		
		numOfHours = hours;
	}	

	/**
	 * This method calculates the total wage based on the numOfHours and payRate
	 * @return total wage
	 */
	public double calWage(){
		if(numOfHours > REGULAR_HOUR)
			return payRate * ((numOfHours-REGULAR_HOUR)* OVERTIME_RATE+ REGULAR_HOUR);
		else
			return payRate * numOfHours;		
	}
	
	/**
	 * Override the default toString() method to show the content of the object
	 * @return string that contains the information of the object
	 */
	public String toString(){
		return empName+" worked "+ numOfHours+ " hour(s) at $"+ payRate +" per hour.\n";
	}
	
}

package edu.unlv.is380.assignment6;

import edu.unlv.is380.labwork18.NegativeStartingBalance;

/**
 * The program simulates the behavior of a pay roll with a bonus.
 * @author Han-fen Hu
 *
 */
public class BonusPayRoll extends PayRoll {

	// field
	double bonusRate;
	/**
	 * This constructor accepts values and assign them to corresponding fields
	 * @param n name of the employee
	 * @param r pay rate for this employee
	 * @param h number of hours worked
	 * @param br bonus rate of the employee
	 * @throws InvalidHours Inherited from the super class
	 * @throws InvalidPayRate Inherited from the super class
	 * @throws InvalidBonusRate Inherited from the super class
	 */

	public BonusPayRoll(String n, double h, double r, double br) throws InvalidHours, InvalidPayRate, InvalidBonusRate {
		super(n, h, r);
			
		/** If an invalid number is given in the bonus rate, 
		 * then throw the InvalidBonusRate exception when the error occurs.
		 * This would be a negative number or a number greater than 1
		*/
		
		 if (br < 0 || br > 1) {
			 throw new InvalidBonusRate(br);
		 } else {  
			 bonusRate = br;
		 }
		 
		
	}
	/**
	 * Retrieve the value for bonus rate
	 * @return bonus rate for the employee
	 */
	public double getBonusRate() {
		return bonusRate;
	}
	
	/**
	 * Set the value for bonus rate
	 * @param bonusRate Given bonus rate
	 */
	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}
	
	/**
	 * Overwrite the method of the super class
	 * @return the new gross pay taken bonus into consideration
	 */
	public double calcGrossPay(){
		return hoursWorked * payRate * (1+bonusRate);
	}
	
	/**
	 * This method returns the amount of the bonus
	 * @return the amount of the bonus
	 */
	public double getBonus(){
		return hoursWorked * payRate * bonusRate;
	}

	

}

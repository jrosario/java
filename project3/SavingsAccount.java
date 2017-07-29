/**
 * Author: Jose Rosario-Lopez
 * Date: March 8, 2017
 * Program Purpose: This application servers to build the getters/setters for Savings Account.
 * Input: Starting balance, monthly interest rate, withdraw amount, deposit amount, 
 * 		  and the number of months that have passed since the amount was established.
 * 		  Accept decimal numbers and Strings
 * Output: The user's savings account's ending balance.
 */


package edu.unlv.is380.assignment3;

public class SavingsAccount {
	
	//data fields
	private double interestRate;
	private double balance;
	
	
    /**
     * No-argument constructor. Sets the interest rate and balance to 0.
     */
	public SavingsAccount() {
		interestRate = 0;
		balance = 0;
	}
	
	/**
     * Accepts the double numbers interest rate and the amount of starting balance.
     * @param iRate The annual interest rate. 
     * @param bal The account's balance. 
     */
	public SavingsAccount(double iRate, double bal){
		
		//If the input starting balance is less than zero, set the field balance to zero (0).
		if (bal < 0) 
		{
			balance = 0;
		}
		
		// If the input interest rate is less than 0, set the field interestRate to zero (0).
		if (iRate < 0) 
		{
			interestRate = 0;
		}
		
		// If the input interest rate is greater than 0.01 (i.e., 1%), divide the number by 100 before setting the value to the field interestRate.
		if (iRate > 0.01)
		{
			iRate = iRate / 100;
		}
		
		this.interestRate = iRate;
		balance = bal;

	}
	
	
	
	/**
     * Overload method that accepts two strings as the interest rate and the starting balance. 
     * @param iRateStr The annual interest rate. 
     * @param balString The account's balance. 
     */
	public SavingsAccount(String iRateStr, String balString){
	
		double iRateVal = Double.parseDouble(iRateStr);
		double balVal =  Double.parseDouble(balString);
		
		//If the input starting balance is less than zero, set the field balance to zero (0).
		if (balVal < 0) 
		{
			balance = 0;
		}
		
		//If the input interest rate is less than 0, set the field interestRate to zero (0)
		if (iRateVal < 0) 
		{
			interestRate = 0;
		}
		
		//If the input interest rate is greater than 0.01 (i.e., 1%), divide the number by 100 before setting the value to the field interestRate.
		if (iRateVal > 0.01)
		{
			iRateVal = iRateVal / 100;
		}
		
		this.interestRate = iRateVal;
		balance = balVal;
	
	}

	
	/**
     * No-argument constructor. This will get the interest rate.
     */
	public double getInterestRate() {
		
		// If the input interest rate is less than 0, set the field interestRate to zero (0).
		if (interestRate < 0) 
		{
			this.interestRate = 0;
		}
		
		// If the input interest rate is greater than 0.01 (i.e., 1%), divide the number by 100 before setting the value to the field interestRate.
		if (interestRate > 0.01)
		{
			this.interestRate = interestRate / 100;
		}
		
		return this.interestRate;
	}
	
	
	
	/**
     * Sets the interest rate. 
     * @param interestRate The annual interest rate. 
     */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	
	/**
     * Overload method that sets the interest rate. 
     * @param iRateStr The annual interest rate. 
     */
	public void setInterestRate(String iRateStr) {
		double iRateVal = Double.parseDouble(iRateStr);
		this.interestRate = iRateVal;
	}
	
	

	/** Method to retrieve the account's balance.
     * @return The account's balance
     */
	public double getBalance() {
		return balance;
	}
	
	

	/** Method to add the amount of a deposit to the balance
     * @return The account's balance
     */
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	
	/** Overloaded method to add the amount of a deposit to the balance with String as the parameter
     * @return The account's balance
     */
	public void deposit(String amount) {
		double depositAmount = Double.parseDouble(amount);
		balance += depositAmount;
	}
	

	
	
	/** Method to subtract the amount of a withdrawal from the balance
     * @return The account's balance
     */
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	
	
	/** Overloaded method to subtract the amount of a withdrawal from the balance with String as the parameter.
     * @return The account's balance
     */
	public void withdraw(String amount) {
		double withdrawAmount = Double.parseDouble(amount);
		balance -= withdrawAmount;
	}
	

	
	/**
     * Adding the amount of monthly interest to the balance.
     */
    public void addInterest()
    {
        double monthlyInterest = getBalance() * getAnnualInterestRate();
        balance += monthlyInterest;       
    }

   

    /**
     * @return The annual interest rate
     */
    public double getAnnualInterestRate()
    {
        return interestRate; 
    }

    
    
    /**
     * @return The monthly interest rate.
     */
    public double getMonthlyInterestRate()
    {
        return interestRate / 12; 
    }

	
	
} //end SavingsAccount class

/**
 * This class represents a Loan record.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

import java.util.Date;

public class Loan {
	// Fields
	private int loanNum;
	private String customerNum;
	private String copyNum;
	private String startDate;
	private String dueDate;
	private String returnDate;

	//Constructors
	/**
	 * No-arg constructor
	 */
	public Loan() {}

	
	/**
	 * Constructor with every field
	 * @param loanNum Loan number
	 * @param customerNum Customer number
	 * @param copyNum Street Copy number
	 * @param startDate Date loaned
	 * @param dueDate Due date
	 * @param returnDate Returned date
	 */
	public Loan(int loanNum, String customerNum, String copyNum, String startDate, String dueDate, String returnDate) {
		super();
		this.loanNum = loanNum;
		this.customerNum = customerNum;
		this.copyNum = copyNum;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}
	
	/**
	 * Constructor with 5 fields.
	 * @param loanNum Loan number
	 * @param customerNum Customer number
	 * @param copyNum Street Copy number
	 * @param startDate Date loaned
	 * @param dueDate Due date
	 */
	public Loan(int loanNum, String customerNum, String copyNum, String startDate, String dueDate) {
		super();
		this.loanNum = loanNum;
		this.customerNum = customerNum;
		this.copyNum = copyNum;
		this.startDate = startDate;
		this.dueDate = dueDate;
	}
	
	/**
	 * Constructor with 2 fields.
	 * @param loanNum Loan number
	 * @param returnDate Returned date
	 */
	public Loan(int loanNum, String returnDate) {
		super();
		this.loanNum = loanNum;
		this.returnDate = returnDate;
	}
	
	/**
	 * Constructor with 1 field.
	 * @param loanNum Loan number
	 */
	public Loan(int loanNum) {
		super();
		this.loanNum = loanNum;
	}
	
	/**
	 * Constructor with 1 field.
	 * @param returnDate Return date
	 */
	public Loan(String returnDate) {
		super();
		this.returnDate = returnDate;
	}
	
	
	
	
	// All getters
	public int getLoanNum() {
		return loanNum;
	}
	
	public String getCustomerNum() {
		return customerNum;
	}
	
	public String getCopyNum() {
		return copyNum;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public String getReturnDate() {
		return returnDate;
	}
	
	
	// All setters
	public void setLoanNum(int loanNum) {
		this.loanNum = loanNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}
	
	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}

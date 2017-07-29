/**
 * This class represents that Data Access Object (DAO) for Loan.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

import java.util.List;

import Project.Loan;

public interface LoanDAO {
	/**
	 * This method gets all the loan records.
	 * @return A List with Loan objects
	 */
   public List<Loan> getAllLoans();
   
   /**
    * This method retrieves a loan record based on the given loan number.
    * @param loanNumber Represents the primary key, loan number.
    * @return a loan object
    */
   public Loan getLoanByNumber(int loanNumber);
   
   /**
    * This method inserts a loan record into the database
    * @param aLoan a loan object
    * @return Whether the insertion is successful or not
    */
   public boolean insertLoan(Loan aLoan);
   
   /**
    * This method extends the date a loan record in the database
    * @param aLoan a loan object
    * @return Whether the update is successful or not
    */
   public boolean updateExtendLoan(Loan aLoan);
   
   /**
    * This method updates the return date of a loan record in the database
    * @param aLoan a loan object
    * @return Whether the update is successful or not
    */
   public boolean updateReturnLoan(Loan aLoan);
   
   /**
    * This method deletes a loan record based on the given loan number.
    * @param loanNum represents the primary key, loan number.
    * @return Whether the deletion is successful or not.
    */
   public boolean deleteLoan(int loanNum);
}

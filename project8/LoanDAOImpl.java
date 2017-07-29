/**
 * This class implements the Interface Loan DAO.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Project.GameDBConstants;
import Project.Loan;
//import edu.unlv.is380.labwork20.CoffeeDBConstants;
//import edu.unlv.is380.labwork20.CoffeeDBUtil;
//import edu.unlv.is380.labwork20.Customer;

public class LoanDAOImpl implements LoanDAO {

	@Override
	public List<Loan> getAllLoans() {
		List<Loan> loanList =  new ArrayList<Loan>();
		
		try {
			// Connect to the database.
			Connection conn = GameDBUtil.getDBConnection();
			Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String sql = "SELECT * from " + GameDBConstants.LOAN_TABLE_NAME;
			
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            // Move to last row
            result.last();                 
            
            // Get row number
            int numRows = result.getRow(); 
            
            // Move to the first row
            result.first();                
      
            // Create a array list for the data.
            ArrayList<String> loanArrayList = new ArrayList<String>();
            
            for (int row = 0; row < numRows; row++) {
            	// create a new object and fill the field with the values from the result set.
            	loanList = (List<Loan>) new Loan();
            	
            	//Add the object to the list
            	loanList.add((Loan) result);

               // Go to the next row in the ResultSet.
               result.next();
            }
            
            stmt.close();
            GameDBUtil.closeDBConnection(conn);
  	
		}catch (Exception ex) {
			//User-friendly error message.
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		return loanList;
	} //end getAllLoans method
	
	

	@Override
	/**
	 * The getLoanByNumber method retrieves the loan information.
	 * Error handling: Exception User-friendly error message
	 * @param loanNumber The loan number being searched
	 * @return A loan
	 */
	public Loan getLoanByNumber(int loanNumber) {
		Loan aLoan =  new Loan();
		try {
			//Connect to the database
			Connection conn = GameDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			//SQL statement that selects all the columns from the loan table.
			String sql = "SELECT * from " + GameDBConstants.LOAN_TABLE_NAME+
					     "WHERE "+GameDBConstants.LOAN_PK_NAME+" = "+loanNumber;
			
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            // create a new object and fill the field with the values from the result set.
            aLoan  = new Loan(
            					result.getInt(0), 
            					result.getString(1), 
            					result.getString(2), 
            					result.getString(3), 
            					result.getString(4), 
            					result.getString(5) 
            				);

            stmt.close();
            
            //close database connection
            GameDBUtil.closeDBConnection(conn);   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return aLoan;
	}

	@Override
	/**
	 * The insertLoan method inserts a loan record.
	 * Error handling: Exception User-friendly error message
	 * @param Loan The loan being inserted
	 * @return Boolean
	 */
	public boolean insertLoan(Loan aLoan) {
		boolean flag = false;
		try {
			//Create a new Connection object and connect to the database
			Connection conn = GameDBUtil.getDBConnection();
			
			//Create a new Statement object
			Statement stmt = conn.createStatement();

			// SQL query used to insert a new record into the loan table
			String sql = "INSERT INTO " + GameDBConstants.LOAN_TABLE_NAME+
					     " VALUES ("+
					     	aLoan.getLoanNum()+", '"+
					     	aLoan.getCustomerNum()+"', '"+
					     	aLoan.getCopyNum()+"', '"+
					     	aLoan.getStartDate()+"', '"+
					     	aLoan.getDueDate()+"', "+
							null+")";
			//Visually see the SQL statement
			System.out.println(sql);
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			//If the statement executed successfully, switch flag to true
			if (rows == 1) {
				flag = true;
			}
			
            stmt.close();
            
            // close connection to database
            GameDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	} //end insertLoan method

	@Override
	/**
	 * The updateLoan method updates a loan record.
	 * Error handling: Exception User-friendly error message
	 * @param Loan The loan being updated.
	 * @return Boolean
	 */
	public boolean updateExtendLoan(Loan aLoan) {
		boolean flag = false;
		try {
			//Create a new Connection object and connect to the database.
			Connection conn = GameDBUtil.getDBConnection();
			
			//Create a new Statement object
			Statement stmt = conn.createStatement();
			
			//SQL statement that updates the table, setting the column's old value to the new value that is passed
			String sql = "UPDATE " + GameDBConstants.LOAN_TABLE_NAME +
							" SET Due_Date = '" +aLoan.getReturnDate() +
								"' WHERE Loan_Num = "+aLoan.getLoanNum();
			
			//Visually see the SQL statement
			System.out.println(sql);
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			// if the statement executed successfully, switch flag to true
			if (rows == 1) {
				flag = true;
			}
			
            stmt.close();
            
            //close connection to database
            GameDBUtil.closeDBConnection(conn);
   
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}
	
	@Override
	/**
	 * The updateLoan method updates a loan record.
	 * Error handling: Exception User-friendly error message
	 * @param Loan The loan being updated.
	 * @return Boolean
	 */
	public boolean updateReturnLoan(Loan aLoan) {
		boolean flag = false;
		try {
			//Create a new Connection object and connect to the database.
			Connection conn = GameDBUtil.getDBConnection();
			
			//Create a new Statement object
			Statement stmt = conn.createStatement();
			
			//SQL statement that updates the table, setting the column's old value to the new value that is passed
			String sql = "UPDATE " + GameDBConstants.LOAN_TABLE_NAME +
							" SET Return_Date = '" +aLoan.getReturnDate() +
								"' WHERE Loan_Num = "+aLoan.getLoanNum();
			
			//Visually see the SQL statement
			System.out.println(sql);
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			// if the statement executed successfully, switch flag to true
			if (rows == 1) {
				flag = true;
			}
			
            stmt.close();
            
            //close connection to database
            GameDBUtil.closeDBConnection(conn);
   
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}

	@Override
	/**
	 * The deleteLoan method inserts a loan record.
	 * Error handling: Exception User-friendly error message
	 * @param Loan The loan being deleted.
	 * @return Boolean
	 */
	public boolean deleteLoan(int loanNum) {
		boolean flag = false;
		try {
			//Create a new Connection object and connect to the database.
			Connection conn = GameDBUtil.getDBConnection();
			
			//Create a new Statement object
			Statement stmt = conn.createStatement();
			
			// SQL statement to delete the loan, based on the given loan number
			String sql = "Delete FROM " + GameDBConstants.LOAN_TABLE_NAME+
					     " WHERE Loan_Num = '"+ loanNum +"'";
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			// switch flag to true
			if (rows ==1) {
				flag = true;
			}
			
            stmt.close();
            
            //close database connection
            GameDBUtil.closeDBConnection(conn);
   	
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

		return flag;
	}



}

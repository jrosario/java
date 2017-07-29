/**
 * This class retrieves all the records from the database
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Project.GameDBConstants;
import Project.Loan;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class LoanRetrieval extends JFrame {
	
	//Constant used to format the date
	private static final String DATE_FORMAT = "yyyy-MM-dd";
 	
	private JPanel contentPane;
	private JLabel lblTotalRecords;
	private JLabel lblCurrentRecord;
	private JLabel lblLoanNumber;
	private JLabel lblStartDate;
	
	// Create the Connection object
	Connection conn;
	
    // Create the ResultSet object
    ResultSet result;
    
    private JLabel lblLoanNum;
    private JLabel lblCustomerNum;
    private JLabel lblCopyNum;
    private JLabel lblLoanStart;
    private JLabel lblLoanDue;
    private JLabel lblLoanReturn;
    private JButton btnFirst;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnLast;
    private JButton btnMainMenu;
    private JButton btnDelete;
    private JButton btnUpdateReturn;
    private JButton btnExtendDueDate;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanRetrieval frame = new LoanRetrieval();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoanRetrieval() {
		setTitle("Loan Retrieval");
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Loans", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTotalRecords = new JLabel("");
		lblTotalRecords.setBounds(21, 226, 117, 16);
		contentPane.add(lblTotalRecords);
		
		lblCurrentRecord = new JLabel("");
		lblCurrentRecord.setBounds(21, 196, 127, 16);
		contentPane.add(lblCurrentRecord);
		
		lblLoanNumber = new JLabel("Loan Number:");
		lblLoanNumber.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblLoanNumber.setBounds(35, 30, 98, 16);
		contentPane.add(lblLoanNumber);
		
		JLabel lblCustomerNumber = new JLabel("Customer Number: ");
		lblCustomerNumber.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCustomerNumber.setBounds(35, 60, 137, 16);
		contentPane.add(lblCustomerNumber);
		
		JLabel lblCopyNumber = new JLabel("Copy Number:");
		lblCopyNumber.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCopyNumber.setBounds(35, 90, 104, 16);
		contentPane.add(lblCopyNumber);
		
		lblStartDate = new JLabel("Start Date:");
		lblStartDate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStartDate.setBounds(35, 120, 123, 16);
		contentPane.add(lblStartDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDueDate.setBounds(35, 150, 104, 16);
		contentPane.add(lblDueDate);
		
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(new BtnFirstActionListener());
		btnFirst.setBounds(158, 190, 91, 29);
		contentPane.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new BtnPreviousActionListener());
		btnPrevious.setBounds(248, 190, 91, 29);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new BtnNextActionListener());
		btnNext.setBounds(338, 190, 91, 29);
		contentPane.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new BtnLastActionListener());
		btnLast.setBounds(428, 190, 91, 29);
		contentPane.add(btnLast);
		
		lblLoanNum = new JLabel("");
		lblLoanNum.setBounds(180, 30, 123, 16);
		contentPane.add(lblLoanNum);
		
		lblCustomerNum = new JLabel("");
		lblCustomerNum.setBounds(180, 60, 175, 16);
		contentPane.add(lblCustomerNum);
		
		lblCopyNum = new JLabel("");
		lblCopyNum.setBounds(180, 90, 127, 16);
		contentPane.add(lblCopyNum);
		
		lblLoanStart = new JLabel("");
		lblLoanStart.setBounds(180, 120, 123, 16);
		contentPane.add(lblLoanStart);
		
		lblLoanDue = new JLabel("");
		lblLoanDue.setBounds(180, 150, 127, 16);
		contentPane.add(lblLoanDue);
		
		lblLoanReturn = new JLabel("");
		lblLoanReturn.setBounds(150, 202, 137, 16);
		contentPane.add(lblLoanReturn);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(402, 226, 117, 29);
		contentPane.add(btnMainMenu);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new BtnDeleteActionListener());
		btnDelete.setBounds(402, 95, 117, 29);
		contentPane.add(btnDelete);
		
		btnUpdateReturn = new JButton("Return");
		btnUpdateReturn.addActionListener(new BtnUpdateActionListener());
		btnUpdateReturn.setBounds(402, 25, 117, 29);
		contentPane.add(btnUpdateReturn);
		
		btnExtendDueDate = new JButton("Extend");
		btnExtendDueDate.addActionListener(new BtnExtendDueDateActionListener());
		btnExtendDueDate.setBounds(402, 60, 117, 29);
		contentPane.add(btnExtendDueDate);
	} //end LoanSearch method
	
	
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowActivated(WindowEvent e) {
			try {
				//Connect to the database
				getDBConnection();
				
				// Move to the last row
				result.last();		    		
				
				// Get the current row number
				int numRows = result.getRow(); 
				
				// Move back to the first row
				result.first();		 
				
				// Display total number of rows in the database
				lblTotalRecords.setText("Total records: " + numRows);

				//Update the labels to show the content of the current row
				showRowContent(result);
			}
			catch (Exception ex){
				//Display user-friendly error message.
				System.out.println("ERROR: " + ex.getMessage());
			}
		}

		@Override
		public void windowClosing(WindowEvent e) {
			try {
				//Close the database connection
				conn.close();
			} 
			catch (Exception ex) {
				//Display user-friendly error message.
				System.out.println("ERROR: " + ex.getMessage());			
			}
		}
	} //end WindowListener
	
	
	/**
	 * The ActionListener of btnLast, as an inner class
	 * Error Handling: Displays a user-friendly message
	 */
	private class BtnLastActionListener implements ActionListener {
		/**
		 * The actionPerformed method will show the user the very last record 
		 */
		public void actionPerformed(ActionEvent e) {
			try {
				//get the last record
				result.last();
				
				//update the labels
				showRowContent(result);
				
			} catch (SQLException ex) {
				//display a user-friendly message
				System.out.println("ERROR: " + ex.getMessage());
				//e1.printStackTrace();
			}
		}
	}
	
	/**
	 * The ActionListener of btnNext, as an inner class
	 * Error Handling: Displays a user-friendly message
	 */
	private class BtnNextActionListener implements ActionListener {
		/**
		 * The actionPerformed method will show the user the next record 
		 */
		public void actionPerformed(ActionEvent e) {
			try {
				//get the next record
				result.next();
				
				//update the labels
				showRowContent(result);
				
			} catch (SQLException ex) {
				//display a user-friendly message
				System.out.println("ERROR: " + ex.getMessage());
				//e1.printStackTrace();
			}
		}
	}
	
	/**
	 * The ActionListener of btnPrevious, as an inner class
	 * Error Handling: Displays a user-friendly message
	 */
	private class BtnPreviousActionListener implements ActionListener {
		/**
		 * The actionPerformed method will show the user the previous record 
		 */
		public void actionPerformed(ActionEvent e) {
			try{
				//Move to the previous row
				result.previous();
				
				//Update the labels to show the content of the current row
				showRowContent(result);
				
			} catch (Exception ex){
				//display a user-friendly message
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}
	
	/**
	 * The ActionListener of btnFirst, as an inner class
	 * 	Error Handling: A user-friendly message.
	 */
	private class BtnFirstActionListener implements ActionListener {
		/**
		 * The actionPerformed method will show the user the first record 
		 */
		public void actionPerformed(ActionEvent e) {
			try{
				//Move to the first row
				result.first();
				
				//Update the labels to show the content of the current row
				showRowContent(result);
				
			} catch (Exception ex){
				//display a user-friendly message
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}
	
	
	/**
	 * The ActionListener of btnMainMenu, as an inner class
	 */
	private class BtnMainMenuActionListener implements ActionListener {
		/**
		 * The actionPerformed method will take the user back to the Main Menu window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a MainMenu object
			MainMenu mainMenu = new MainMenu();
			
			// set the visibility of the MainMenu to true.
			mainMenu.setVisible(true);			
			
			//Dispose the current frame
			LoanRetrieval.this.dispose();
		}
	}
	
	
	/**
	 * The ActionListener of btnDelete, as an inner class
	 * Error Handling: A user-friendly message.
	 */
	private class BtnDeleteActionListener implements ActionListener {
		/**
		 * The actionPerformed method gets user input from text field, prepares the SQL statement
		 * and then executes the statement.
		 * After deletion, the text field is reset.
		 * Error Handling: The loan number cannot be empty.
		 */
		public void actionPerformed(ActionEvent e) {
			
			int loanNum = 0;
			
			// Get the user input from text fields
		    String textLoanNum = lblLoanNum.getText();
		    
		    // if the customer number is empty, show message.
		    if (textLoanNum.isEmpty())
		    {
		    	JOptionPane.showMessageDialog(null, "The loan number cannot be empty");
		    	
		    } 
		    // if the loan data is good
		    else 
		    {
		    	loanNum = Integer.parseInt(textLoanNum);
		    	
		    	
		    	// Create a Loan object, and fill the field with the value
//			    Loan client = new Loan(loanNum);
			    
			    // Create a DAO object
			    LoanDAO loanDao = new LoanDAOImpl();
			    
			    // use the DAO object to insert the record
			    if (loanDao.deleteLoan(loanNum) ) {
//			    if (loanDao.deleteLoan(client) ) {
		    		// Message to the user, showing the end of execution
			    	JOptionPane.showMessageDialog(null, "The record was deleted.");
			    }
			    else {
		    		// Message to the user, showing the failure of execution
		    		JOptionPane.showMessageDialog(null, "The record was not deleted. \nPlease try again.");
			    }
		    }
		} //end actionPerformed
	} //end BtnDeleteActionListener
	
	
	
	/**
	 * The ActionListener of btnUpdate, as an inner class
	 */
	private class BtnUpdateActionListener implements ActionListener {
		/**
		 * The actionPerformed method will update the Return Date of the record
		 */
		public void actionPerformed(ActionEvent e) {

			String dateToday;
			
			// Get the row to be updated
			String textLoanNum = lblLoanNum.getText();
		    
		    int loanNumber = 0;
		    
		    // if the field is empty, show message.
		    if(textLoanNum.isEmpty() ) {
		    	JOptionPane.showMessageDialog(null, "The loan number cannot be empty.");
		    }
		    else {
		    	loanNumber = Integer.parseInt(textLoanNum);
		    	
		    	dateToday = getDateToday();
		    	
			    // Create a Loan object, and fill the field with the value
			    Loan client = new Loan(loanNumber, dateToday);
			    
			    // Create a DAO object
			    LoanDAO loanDao = new LoanDAOImpl();
			    
			    // use the DAO object to insert the record
			    if (loanDao.updateReturnLoan(client) ) {
		    		// Message to the user, showing the end of execution
			    	JOptionPane.showMessageDialog(null, "The record was updated.");
			    } 
			    else {
		    		// Message to the user, showing the failure of execution
		    		JOptionPane.showMessageDialog(null, "The record was not updated. \nPlease try again.");
			    }
		    }
		} //end actionPerformed
	} //end BtnUpdateActionListener
	
	
	/**
	 * The ActionListener of btnExtendDueDate, as an inner class
	 */
	private class BtnExtendDueDateActionListener implements ActionListener {
		/**
		 * The actionPerformed method will update the Due Date of the record
		 */
		public void actionPerformed(ActionEvent e) {
			
			String tomorrow;
			
			// Get the row to be updated
			String textLoanNum = lblLoanNum.getText();
		    
		    int loanNumber = 0;
		    
		    // if the field is empty, show message.
		    if(textLoanNum.isEmpty() ) {
		    	JOptionPane.showMessageDialog(null, "The loan number cannot be empty.");
		    }else {
		    	loanNumber = Integer.parseInt(textLoanNum);
		    	
		    	tomorrow = getDateTomorrow();
		    
			    // Create a Loan object, and fill the field with the value
			    Loan client = new Loan(loanNumber, tomorrow);
			    
			    // Create a DAO object
			    LoanDAO loanDao = new LoanDAOImpl();
			    
			    // use the DAO object to insert the record
			    if (loanDao.updateExtendLoan(client) ) {
		    		// Message to the user, showing the end of execution
			    	JOptionPane.showMessageDialog(null, "The due date has been extended.");
			    } 
			    else {
		    		// Message to the user, showing the failure of execution
		    		JOptionPane.showMessageDialog(null, "The record was not updated. \nPlease try again.");
			    }
		    }

		} //end actionPerformed
	}//end BtnUpdateActionListener
	

	
	/**
	 * The getDateToday method gets today's current date
	 * @return Today's date
	 */
	private String getDateToday() {
		//Create a Calendar object
		Calendar cal = Calendar.getInstance();
		
		//Create a SimpleDateFormat object
		SimpleDateFormat formattedDate = new SimpleDateFormat(DATE_FORMAT);

		//return the formatted date
		String formatted = formattedDate.format(cal.getTime());

    	return formatted;
	} //end getDateToday()
	
	
	/**
	 * The getDateTomorrow method gets tomorrow's date
	 * @return Tomorrow's date
	 */
	private String getDateTomorrow() {
		
		//variable to hold output
		String formatted;
		
		//Creating a SimpleDateFormat object with custom formatting
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		
		// convert date to calendar
		Calendar cal = Calendar.getInstance();
		
		//add a day to the date
		cal.add(Calendar.DATE, 1);
	
		//format the date
		formatted = dateFormat.format(cal.getTime());

		return formatted;
	}
	
	
	/**
	 * The getDBConnection method is used to establish the DB connection
	 * Error Handling: A user-friendly message.
	 */
	private void getDBConnection(){
	    try {
	    	// Create a connection to the database.
		    conn = DriverManager.getConnection(GameDBConstants.DB_URL,GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
		       
		    // Create a Statement object.
		    Statement stmt = conn.createStatement();
		         
		    // Create a string with a SELECT statement.
		    String sql = "SELECT * FROM " + GameDBConstants.LOAN_TABLE_NAME;
		         
		    // Send the statement to the DBMS.
		    result = stmt.executeQuery(sql);
		 }
		 catch(Exception ex) {
			 //Output user-friendly message.
			 System.out.println("ERROR: " + ex.getMessage());
		 }		
	}	
	
	/**
	 * The showRowContent method displays the content of the current row in a result set.
	 * Five labels are used to display the content of the Loan_Num, Cust_Num, Copy_Num, Start_Date, and Due_Date columns
	 * Another label is used to display the row number.
	 * Error Handling: A user-friendly message.
	 * @param result A ResultSet
	 */
	private void showRowContent(ResultSet result) {
		try {
			//Display the content of the current row
			lblLoanNum.setText(result.getString("Loan_Num"));
			lblCustomerNum.setText(result.getString("Cust_Num"));
			lblCopyNum.setText(result.getString("Copy_Num"));
			lblLoanStart.setText(result.getString("Start_Date"));
			lblLoanDue.setText(result.getString("Due_Date"));
		
			//Display the current row number
			lblCurrentRecord.setText("Current Record: " + result.getRow() );
			
		} catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	} //end showRowContent method
	
}

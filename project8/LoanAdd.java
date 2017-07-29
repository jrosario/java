/**
 * This class represents adding a Loan record.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

package Project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Project.GameDBConstants;
import Project.Loan;


public class LoanAdd extends JFrame {

	private JPanel contentPane;
	
	//used to hold user's input
	private JTextField txtCustomerNumber;
	private JTextField txtCopyNumber;
	
	private JButton btnCheckout;
	private JDateChooser txtStartDate;
	private JDateChooser txtDueDate;
	private JLabel lblDueDate;
	private static User user;
	
	// Create the Connection object
	static Connection conn;
	
	// Create the Statement object
	Statement stmt;
	
	// Create the Statement object
	ResultSet result;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanAdd frame = new LoanAdd(user);
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
	public LoanAdd(User user) {
		
		setTitle("Add Loan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerNumer = new JLabel("Customer Number:");
		lblCustomerNumer.setBounds(30, 30, 145, 16);
		contentPane.add(lblCustomerNumer);
		
		JLabel lblCopyNumber = new JLabel("Copy Number:");
		lblCopyNumber.setBounds(30, 60, 122, 16);
		contentPane.add(lblCopyNumber);
		
		txtCustomerNumber = new JTextField();
		txtCustomerNumber.setBounds(187, 25, 130, 26);
		txtCustomerNumber.setText(user.getPhoneNumber());
		contentPane.add(txtCustomerNumber);
		txtCustomerNumber.setColumns(10);
		
		txtCopyNumber = new JTextField();
		txtCopyNumber.setBounds(187, 55, 130, 26);
		contentPane.add(txtCopyNumber);
		txtCopyNumber.setColumns(10);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new BtnCheckoutActionListener());
		btnCheckout.setBounds(187, 176, 117, 29);
		contentPane.add(btnCheckout);
		
		txtStartDate = new JDateChooser();
		txtStartDate.setDateFormatString("yyyy-MM-dd");
		txtStartDate.setBounds(190, 88, 125, 26);
		contentPane.add(txtStartDate);
		
		txtDueDate = new JDateChooser();
		txtDueDate.setDateFormatString("yyyy-MM-dd");
		txtDueDate.setBounds(189, 123, 125, 26);
		contentPane.add(txtDueDate);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(30, 90, 111, 16);
		contentPane.add(lblStartDate);
		
		lblDueDate = new JLabel("Due  Date");
		lblDueDate.setBounds(30, 120, 111, 16);
		contentPane.add(lblDueDate);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(47, 176, 117, 29);
		contentPane.add(btnMainMenu);
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate localDate = LocalDate.now();
		 //System.out.println(dtf.format(localDate));
		 ((JTextField)txtStartDate.getDateEditor().getUiComponent()).setText(dtf.format(localDate));
	}
	
	/**
	 * The clearContent method clears the text field.
	 * It also sets the focus to the first (customer number) textfield.
	 */
	private void clearContent() {
		//Clear text fields
		txtCustomerNumber.setText("");
		txtCopyNumber.setText("");
		((JTextField)txtDueDate.getDateEditor().getUiComponent()).setText("") ;
		
		//set focus on the textfield
		txtCustomerNumber.requestFocus();
		
		// Display the results.
	    System.out.println("Textfield has been cleared.");
	} //end clearContent()

	/**
	 * The ActionListener of btnCheckout, as an inner class
	 */
	private class BtnCheckoutActionListener implements ActionListener {
		/**
		 * The actionPerformed method gets user input from text fields, prepare the SQL statement
		 * and then executes the statement.
		 * After insertion, the text fields are reset.
		 * Error Handling: The customer number cannot be empty.
		 */
		public void actionPerformed(ActionEvent e) {
			int rowCount;
			int customerNumber = 0;
			
			// Get the user input from text field
		    String textCustomerNum=txtCustomerNumber.getText();
		    String copyNumber=txtCopyNumber.getText();
		    String due = ((JTextField)txtDueDate.getDateEditor().getUiComponent()).getText();
	
		    // if the customer number is empty, show message.
		    if (textCustomerNum.length() < 1)
		    {
		    	JOptionPane.showMessageDialog(null, "The customer number cannot be empty");
		    	txtCustomerNumber.requestFocus();
		    	
		   // if the game copy number is empty 	
		    } else if (copyNumber.isEmpty())  {
		    	JOptionPane.showMessageDialog(null, "The copy number cannot be empty.");
		    	txtCopyNumber.requestFocus();
		    	
		    // if the due date is empty	
		    } else if (due.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Please enter the due date.");
		    	txtDueDate.requestFocus();
		    }
		    // if the loan data is good
		    else {
		    	// get how many total rows are currently in the database
		    	rowCount = getRowCount();
		    	
		    	//increase the count by 1
			    rowCount++;
			    
			    //convert user's input string to int
		    	//customerNumber = Integer.parseInt(textCustomerNum);
		    	
			    copyNumber = txtCopyNumber.getText();    
			    String startDate  = ((JTextField)txtStartDate.getDateEditor().getUiComponent()).getText();
			    String dueDate  = ((JTextField)txtDueDate.getDateEditor().getUiComponent()).getText();
			       
			    // Create a customer object, and fill the fields with the values
			    Loan client = new Loan(rowCount, textCustomerNum, copyNumber, startDate, dueDate);
			    
			    // Create a DAO object
			    LoanDAO loanDao = new LoanDAOImpl();
			    
			    // use the DAO object to insert the record
			    if (loanDao.insertLoan(client) ) {
		    		// Message to the user, showing the end of execution
			    	JOptionPane.showMessageDialog(null, "The record was inserted.");
			    	clearContent();
			    }
			    else {
		    		// Message to the user, showing the failure of execution
		    		JOptionPane.showMessageDialog(null, "The record was not inserted. \nPlease try again.");
		    		clearContent();
			    }
			    
			    //Sets the status of the copy to out.
			    try {
			    	//Creates the connection and the Statement object
					conn = DriverManager.getConnection(GameDBConstants.DB_URL, GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
					Statement stmt = conn.createStatement();
					
					//Creates the SQL Statement.
					String sqlStatement = "UPDATE game_copy Set Status = 'OUT', " +
							"loan_num = " + client.getLoanNum() +
					" WHERE copy_num = '" + client.getCopyNum() + "'";
					
					//Executes the SQL statement.
					stmt.execute(sqlStatement);
					
					//Closes the connection.
					conn.close();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
				}
		    }
			
		} //end actionPerformed
	}//end BtnCheckoutActionListener
	
	
	/**
	 * The ActionListener of btnMainMenu, as an inner class
	 */
	private class BtnMainMenuActionListener implements ActionListener {
		/**
		 * The actionPerformed method will take the user back to the Main Menu window
		 */
		public void actionPerformed(ActionEvent e) {
			// Instantiate a MainMenu object
			MainMenu loanRetrieval = new MainMenu();
			
			// set the visibility of the LoanRetrieval to true.
			loanRetrieval.setVisible(true);			
			
			//Dispose the current frame
			LoanAdd.this.dispose();
		}
	}
	
	
	
	/**
	 * The getRowCount method gets the total number of rows from the loan table.
	 * Error handling: SQL Exception error message
	 * @return The total row count
	 */
	public int getRowCount() {
		int count = 0;
		
		String sql = "";
		
		try
		{
		   // Create a connection to the database.
		    conn = DriverManager.getConnection(GameDBConstants.DB_URL,GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
		    
		    stmt = conn.createStatement();   
		    
		    // Count the total number of rows in the table
		    sql = "SELECT COUNT(*) FROM loan";
		    
		    // Send the statement to the DBMS.
		    result = stmt.executeQuery(sql);
		    
		    result.next();

		    count = result.getInt(1);
  
		}
		catch(SQLException e1) {
				e1.getMessage();
		}
		
		return count;
	} //end getRowCount method 
}

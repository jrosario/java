/**
 * Author: Jose Rosario-Lopez
 * Date: April 24, 2017
 * Program Purpose: This application connects to the CoffeeDB database and allows the 
 * 					user to insert a new row into the Customer table.
 * 					Basic user input validation is also introduced.
 * Input: Customer Number, Name, Address, City, State, and Zip Code.
 * Output: Data insertion into the CoffeeDB database's Customer table. 
 */

package edu.unlv.is380.assignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class InsertCustomerData extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerNumber;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZipCode;
	private JButton btnClearAll;
	private JButton btnSave;
	private JButton btnExit;

	// Create the Connection object
	static Connection conn;
	
	// Create the Statement object
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		getDBConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCustomerData frame = new InsertCustomerData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} //end main()

	
	
	
	
	/**
	 * Create the frame.
	 */
	public InsertCustomerData() {
		setTitle("Insert Customer Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Assign labels and position them on the frame
		JLabel lblCustomerNumber = new JLabel("Customer Number:");
		lblCustomerNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerNumber.setBounds(9, 12, 119, 16);
		contentPane.add(lblCustomerNumber);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(67, 50, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(67, 91, 61, 16);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(67, 133, 61, 16);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setBounds(67, 173, 61, 16);
		contentPane.add(lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZipCode.setBounds(67, 209, 61, 16);
		contentPane.add(lblZipCode);
		
		
		// Textfields are defined and assigned as to hold user input.
		txtCustomerNumber = new JTextField();
		txtCustomerNumber.setBounds(167, 8, 130, 26);
		contentPane.add(txtCustomerNumber);
		txtCustomerNumber.setColumns(10);
		txtCustomerNumber.requestFocus();
		
		txtName = new JTextField();
		txtName.setBounds(167, 45, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(167, 86, 130, 26);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(167, 128, 130, 26);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(167, 168, 130, 26);
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(167, 204, 130, 26);
		contentPane.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		// Adding functionality buttons and attaching their respective event listeners
		btnSave = new JButton("Save");
		btnSave.addActionListener(new BtnSaveActionListener());
		btnSave.setBounds(315, 242, 117, 29);
		contentPane.add(btnSave);
		
		btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new BtnClearAllActionListener());
		btnClearAll.setBounds(167, 242, 117, 29);
		contentPane.add(btnClearAll);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new BtnExitActionListener());
		btnExit.setBounds(26, 242, 117, 29);
		contentPane.add(btnExit);
	} //end InsertCustomerData()
	
	
	/**
	 * This method is used to establish the DB connection
	 * 
	 */
	private static void getDBConnection(){
		// Create named constants for the URL, username and password. These are used to connect to the DB.
	    final String DB_URL = "jdbc:mysql://localhost:3306/coffeeDB";
	    final String USER_NAME = "root";
	    final String PASSWORD = "root";
	    
	    try {
	    	// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		    System.out.println("Database connection is successful");
		 }
		 catch(Exception ex) {
			 // Output any error message(s) as to why the application could not connect
			 System.out.println("ERROR: " + ex.getMessage());
		 } // end try-catch
	} //end getDBConnection()
	

	/**
	 * Implementing the Action Listener that is triggered once the user clicks on Save button.
	 * When the button is pressed, it assigns the values entered in the input fields.
	 * Then it will check to see if values are empty. 
	 * If they are not empty, it will INSERT the values into the DB.
	 */
	private class BtnSaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {		
			try {
			
				// To hold the input entered by the user
				String textCustomerNumber;
				String textName;
				String textAddress;
				String textCity;
				String textState;
				String textZipCode;
				
				// To assign the input values
				textCustomerNumber = txtCustomerNumber.getText().trim();
				textName = txtName.getText().trim();
				textAddress = txtAddress.getText().trim();
				textCity = txtCity.getText().trim();
				textState = txtState.getText().trim();
				textZipCode = txtZipCode.getText().trim();
				
				// This if-else logic serves to prevent the user from entering blank data into the table.
				if(
					//If the input fields are not empty
					!textCustomerNumber.isEmpty() && 
					!textName.isEmpty() && 
					!textAddress.isEmpty() && 
					!textCity.isEmpty() &&
					!textState.isEmpty() &&
					!textZipCode.isEmpty()
				){
					// Create a Statement object.
					stmt = conn.createStatement();
					
					// Create a string with an INSERT statement.
					String sql = "INSERT INTO Customer VALUES ('"
									+ textCustomerNumber + "','" 
									+ textName + "','"
									+ textAddress + "','"
									+ textCity + "','"
									+ textState + "','"
									+ textZipCode + "')";
					
					// Console log the SQL statement
					System.out.println(sql);
					
					// Send the statement to the DBMS and get result of rows affected
					int row = stmt.executeUpdate(sql);
					
					// Console log row count
					System.out.println(row);
					
					//If no rows were affected
					if (row <= 0)  {
						 System.out.println("Row was not inserted.");
						 JOptionPane.showMessageDialog(null, "The row was not inserted");
					}
					
					//If 1 row is affected
					if (row == 1) {
						System.out.println(row + " row has been inserted.");
						
						// Show a message that the record has been successfully inserted
						JOptionPane.showMessageDialog(null, "The record has been inserted.");
						
						//Reset all the text fields and set the focus to the first input
						clearContent();	
					} 	
				}
				else 
				{
					// Show a dialog window with the error that they can't submit blank/empty data.
					JOptionPane.showMessageDialog(null, "Cannot insert blank values into the database.");
					
					// Set the form focus to the first field, so the user doesn't have to click on it.
					txtCustomerNumber.requestFocus();
				}
			} catch (SQLException e1) {
				System.out.println("ERROR: " + e1.getMessage());
				e1.printStackTrace();
			} // end try-catch
		} // end actionPerformed
	} //end Save ActionListener
	
	
	/**
	 * Implementing the Action Listener that is triggered once the user clicks on Clear All button.
	 * When the button is pressed, it resets all the fields and sets the focus to the first input textfield.
	 */
	private class BtnClearAllActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clearContent();
		}
	} //end ClearAll ActionListener


	/**
	 * Implementing the Action Listener that is triggered once the user clicks on Exit button.
	 * When the button is pressed, it prompts the user one last time to verify that they really want to close the program.
	 * This prevents the program from closing just incase the user accidently clicked on this button.
	 */
	private class BtnExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Exit Program?",  "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
			
			// If the user selected 'Yes'
			if(dialogResult == JOptionPane.YES_OPTION){
				try {
					// Close connection to the DBMS
					conn.close();
					System.out.println("Database connection is closed.");
					
					// Exit the program
					System.exit(0);
				} catch (SQLException e1) {

					e1.printStackTrace();
				} //end try-catch
			} // end-if
		} //end actionPerformed
	} //end Exit ActionListener
	
	
	
	/**
	 * The clearContent method clears the text of all text input fields.
	 * It also sets the focus to the first textfield.
	 */
	private void clearContent() {
		txtCustomerNumber.setText("");
		txtName.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtZipCode.setText("");
		
		//set focus on the textfield
		txtCustomerNumber.requestFocus();
		
		// Display the results.
	    System.out.println("Textfields have been cleared.");
	}
}

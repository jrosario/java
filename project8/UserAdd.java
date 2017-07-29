/**
 * This class represents adding a User record.
 * @author Jose Rosario-Lopez
 * @version 1.0
 */


package Project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class UserAdd extends JFrame {

	private JPanel contentPane;
	private JLabel lblDOB;
	private JLabel lblState;
	private JLabel lblCity;
	private JLabel lblStreet;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblPhoneNumber;
	private JLabel lblEmail;
	
	//Fields to hold user's input
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JButton btnMainMenu;
	
	// Create the Connection object
	static Connection conn;
	
	// Create the Statement object
	Statement stmt;
	
	private JButton btnClearAllFields;
	private JButton btnAddUser;
	private JDateChooser txtDOB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Connect to the databse
		getDBConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAdd frame = new UserAdd();
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
	public UserAdd() {
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(30, 30, 93, 16);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(30, 60, 82, 16);
		contentPane.add(lblLastName);
		
		lblStreet = new JLabel("Street");
		lblStreet.setBounds(30, 90, 61, 16);
		contentPane.add(lblStreet);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(30, 120, 61, 16);
		contentPane.add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(30, 150, 61, 16);
		contentPane.add(lblState);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(30, 180, 61, 16);
		contentPane.add(lblZip);
		
		lblDOB = new JLabel("DOB");
		lblDOB.setBounds(30, 210, 61, 16);
		contentPane.add(lblDOB);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(30, 240, 93, 16);
		contentPane.add(lblPhoneNumber);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(30, 270, 61, 16);
		contentPane.add(lblEmail);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(153, 22, 211, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(153, 52, 211, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(153, 82, 211, 26);
		contentPane.add(txtStreet);
		txtStreet.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(153, 112, 211, 26);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(153, 142, 211, 26);
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setBounds(153, 172, 211, 26);
		contentPane.add(txtZip);
		txtZip.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(153, 232, 211, 26);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(153, 262, 211, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(64, 318, 100, 29);
		contentPane.add(btnMainMenu);
		
		btnClearAllFields = new JButton("Clear All");
		btnClearAllFields.addActionListener(new BtnClearAllFieldsActionListener());
		btnClearAllFields.setBounds(264, 318, 100, 29);
		contentPane.add(btnClearAllFields);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new BtnAddUserActionListener());
		btnAddUser.setBounds(164, 318, 100, 29);
		contentPane.add(btnAddUser);
		
		txtDOB = new JDateChooser();
		txtDOB.setBackground(Color.WHITE);
		txtDOB.setDateFormatString("yyyy-MM-dd");
		txtDOB.setBounds(153, 200, 208, 26);
		contentPane.add(txtDOB);
	}

	
	
	/**
	 * This method is used to establish the DB connection
	 * 
	 */
	private static void getDBConnection(){
	    try {
	    	// Create a connection to the database.
		    conn = DriverManager.getConnection(GameDBConstants.DB_URL,GameDBConstants.USER_NAME, GameDBConstants.PASSWORD);
		    System.out.println("Database connection is successful");
		 }
		 catch(Exception ex) {
			 // Output any error message(s) as to why the application could not connect
			 System.out.println("ERROR: " + ex.getMessage());
		 } // end try-catch
	} //end getDBConnection()
	
	
	
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
			UserAdd.this.dispose();
		} //end actionPerformed
	} //end ActionListener
	
	
	/**
	 * The ActionListener of btnClearAllFields, as an inner class
	 */
	private class BtnClearAllFieldsActionListener implements ActionListener {
		/**
		 * The actionPerformed method will trigger the clearContent() method.
		 */
		public void actionPerformed(ActionEvent e) {
			clearContent();
		}
	}
	

	/**
	 * The ActionListener of btnAddUser, as an inner class
	 */
	private class BtnAddUserActionListener implements ActionListener {
		/**
		 * The actionPerformed method gets user input from text fields, prepare the SQL statement
		 * and then executes the statement.
		 * After insertion, the text fields are reset.
		 * Error Handling: Cannot insert blank fields into the database.
		 */
		public void actionPerformed(ActionEvent e) {
			
			try {
				// To hold the input entered by the user
				String textFirstName;
				String textLastName;
				String textStreet;
				String textCity;
				String textState;
				String textZip;
				String textEmail;
				String textPhone;
				
				// To assign the input values
				textFirstName = txtFirstName.getText().trim();
				textLastName = txtLastName.getText().trim();
				textStreet = txtStreet.getText().trim();
				textCity = txtCity.getText().trim();
				textState = txtState.getText().trim();
				textZip = txtZip.getText().trim();
				textEmail = txtEmail.getText().trim();
				textPhone = txtPhone.getText().trim();
				String textDOB  = ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText();
	
				// This if-else logic serves to prevent the user from entering blank data into the table.
				if(
					//If the input fields are not empty
					!textFirstName.isEmpty() && 
					!textLastName.isEmpty() && 
					!textStreet.isEmpty() && 
					!textCity.isEmpty() &&
					!textState.isEmpty() &&
					!textZip.isEmpty() &&
					!textDOB.isEmpty() &&
					!textEmail.isEmpty() &&
					!textPhone.isEmpty()
				){
					
					// Create a Statement object.
					stmt = conn.createStatement();
					
					// Create a string with an INSERT statement.
					String sql = "INSERT INTO Customer VALUES ("
									+ textPhone + ",'" 
									+ textFirstName + "','"
									+ textLastName + "','"
									+ textEmail + "','"
									+ textStreet + "','"
									+ textCity + "','"
									+ textState + "','"
									+ textZip + "','"
									+ textDOB + "')";
					
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
					txtFirstName.requestFocus();
				}
			} catch (SQLException e1) {
				System.out.println("ERROR: " + e1.getMessage());
				e1.printStackTrace();
			} // end try-catch
		}
	} //end Add User ActionListener
	
	
	
	
	/**
	 * The clearContent method clears the text of all text input fields.
	 * It also sets the focus to the first textfield.
	 */
	private void clearContent() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtStreet.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtZip.setText("");
		txtEmail.setText("");
		((JTextField)txtDOB.getDateEditor().getUiComponent()).setText("");
		txtPhone.setText("");
		
		//set focus on the textfield
		txtFirstName.requestFocus();
		
		// Display the results.
	    System.out.println("Textfields have been cleared.");
	} //end clearContent()
}

package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class UserSearch extends JFrame {
    //Constants for URL, user name, and password
    final String DB_URL = "jdbc:mysql://localhost:3306/gamesDB";	//URL
    final String USER_NAME = "root";								//Username
    final String PASSWORD = "";										//Password

	
	private JPanel contentPane;
	private JTextField txtPhone;
	private JList lstUsers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSearch frame = new UserSearch();
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
	public UserSearch() {
		setTitle("Search User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(35, 60, 209, 14);
		getContentPane().add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(35, 85, 220, 20);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new BtnSearchActionListener());
		btnSearch.setBounds(35, 205, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new BtnSelectActionListener());
		btnSelect.setBounds(145, 205, 89, 23);
		contentPane.add(btnSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 115, 275, 75);
		contentPane.add(scrollPane);
		
		lstUsers = new JList();
		lstUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstUsers);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(255, 205, 121, 23);
		contentPane.add(btnMainMenu);

	}
	private class BtnSearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Fields
			String phoneNum;
			boolean found;
			String firstName = "";
			String lastName = "";
			String name;
			
			//Get data
			phoneNum = txtPhone.getText();
			
			try {
				//Connect to DB
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				//Statement object
				Statement stmt = conn.createStatement();
				
				//Create list model
				DefaultListModel userModel = new DefaultListModel();
				
				//SELECT statement
				String sqlStatement =
				          "SELECT * FROM customer WHERE Cust_Phone_Num = '" +
				          phoneNum + "'";
				//Send statement
			    ResultSet result = stmt.executeQuery(sqlStatement);
			    
			    if (result.next())
			    {
			    	found = true;
		    		JOptionPane.showMessageDialog(null, "User(s) found.");
			    	do
			    	{
			    		firstName = result.getString("First_Name");
			    		lastName = result.getString("Last_Name");
			    		name = (firstName + " " + lastName);
			    		userModel.addElement(name);
			    	} while (result.next());
			    }
			    else
			    {
			    	found = false;
			    	JOptionPane.showMessageDialog(null, "User(s) not found.");
			    }
			    //Add Model to JList
			    lstUsers.setModel(userModel);
			    
			    //Close Connection
			    conn.close();
			    
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
			}
		}
	}
	private class BtnSelectActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Fields
			String phoneNum;
			String name;
			String firstName;
			String lastName;
			
			//Create User Object
			User user = new User();
			
			//Get data
			phoneNum = txtPhone.getText();
			name = (String) lstUsers.getSelectedValue();
			String [] nameSplit = name.split("\\s+");
			firstName = nameSplit[0];
			lastName = nameSplit[1];
			
			try {
				//Connect to DB
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				//Create Statement
				Statement statement = conn.createStatement();
				
				//Create SQL Statement
				String sqlStmt =
						"SELECT * FROM customer WHERE Cust_Phone_Num = '"
								+ phoneNum + "'" + " AND First_Name = '"
								+ firstName + "'" + " AND Last_Name = '"
								+ lastName + "'";
				//Send Statement
				ResultSet rslt = statement.executeQuery(sqlStmt);
				
				//Set Values
				rslt.next();
				user.setPhoneNumber(rslt.getString("Cust_Phone_Num"));
				user.setFirstName(rslt.getString("First_Name"));
				user.setLastName(rslt.getString("Last_Name"));
				user.setAddress(rslt.getString("Address"));
				user.setCity(rslt.getString("City"));
				user.setState(rslt.getString("State"));
				user.setZip(rslt.getString("ZIP"));
				user.setDateOfBirth(rslt.getString("DOB"));
				
				//Close Connection
				conn.close();
				
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
			}
			
			//Create UserInfo frame
			UserInfo newFrame = new UserInfo(user);
			//Make UserInfo frame visible
			newFrame.setVisible(true);
			//Close this frame
			UserSearch.this.dispose();
			
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MainMenu main = new MainMenu();
			main.setVisible(true);
			UserSearch.this.dispose();
		}
	}
}

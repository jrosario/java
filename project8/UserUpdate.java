package Project;

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
import java.sql.*;
import java.awt.event.ActionEvent;

public class UserUpdate extends JFrame {
    //Constants for URL, user name, and password
    final String DB_URL = "jdbc:mysql://localhost:3306/gamesDB";	//URL
    final String USER_NAME = "root";								//Username
    final String PASSWORD = "";										//Password
    
    private static User user = new User();

	private JPanel contentPane;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnUpdate;
	private JLabel lblCity;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdate frame = new UserUpdate(user);
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
	public UserUpdate(User user) {
		this.user = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 75, 80, 15);
		getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(10, 25, 80, 15);
		getContentPane().add(lblPhone);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(100, 72, 310, 20);
		getContentPane().add(txtAddress);
		txtAddress.setText(user.getAddress());
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(100, 22, 310, 20);
		getContentPane().add(txtPhone);
		txtPhone.setText(user.getPhoneNumber());
		txtPhone.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new BtnDeleteActionListener());
		btnDelete.setBounds(10, 227, 89, 23);
		getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new BtnUpdateActionListener());
		btnUpdate.setBounds(214, 227, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new BtnClearActionListener());
		btnClear.setBounds(115, 227, 89, 23);
		getContentPane().add(btnClear);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(10, 125, 80, 15);
		contentPane.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(100, 122, 310, 20);
		txtCity.setText(user.getCity());
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 175, 80, 15);
		contentPane.add(lblState);
		
		txtState = new JTextField();
		txtState.setBounds(100, 172, 50, 20);
		txtState.setText(user.getState());
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		JLabel lblZip = new JLabel("ZIP:");
		lblZip.setBounds(180, 175, 80, 15);
		contentPane.add(lblZip);
		
		txtZip = new JTextField();
		txtZip.setBounds(270, 172, 140, 20);
		txtZip.setText(user.getZip());
		contentPane.add(txtZip);
		txtZip.setColumns(10);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(313, 227, 111, 23);
		contentPane.add(btnMainMenu);
	}
	private class BtnClearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtAddress.setText("");
			txtPhone.setText("");
			txtCity.setText("");
			txtState.setText("");
			txtZip.setText("");
		}
	}
	private class BtnDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Fields
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String DOB = user.getDateOfBirth();
			
			try {
				//Connect to DB
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				//Statement Object
				Statement stmt = conn.createStatement();
				
				//DELETE Statement
				String sql =
						"DELETE FROM customer WHERE "
						+ "First_Name = '" + firstName + "' AND "
						+ "Last_Name = '" + lastName + "' AND "
						+ "DOB = '" + DOB + "'";
				
				stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "User deleted.");
				
				//Close Connection
				conn.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,  "ERROR: " + e1.getMessage());
			}
		}
	}
	private class BtnUpdateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Fields
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String DOB = user.getDateOfBirth();
			
			String upAddress = txtAddress.getText();
			String upPhone = txtPhone.getText();
			String upCity = txtCity.getText();
			String upState = txtState.getText();
			String upZip = txtZip.getText();
			
			try {
				//Connect to DB
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				//Statement Object
				Statement stmt = conn.createStatement();
				
				if (!(txtAddress.getText().equals("")))
				{
					//UPDATE Statement
					String sqlAddress =
							"UPDATE customer SET "
									+ "Address = '" + upAddress + "' "
									+ "WHERE First_Name = '" + firstName + "' "
									+ "AND Last_Name = '" + lastName + "' "
									+ "AND DOB = '" + DOB + "'";
				
					//Send Statement
					stmt.executeUpdate(sqlAddress);
				}
				
				if (!(txtPhone.getText().equals("")))
				{
					//UPDATE Statement
					String sqlPhone =
							"UPDATE customer SET "
									+ "Cust_Phone_Num = '" + upPhone + "' "
									+ "WHERE First_Name = '" + firstName + "' "
									+ "AND Last_Name = '" + lastName + "' "
									+ "AND DOB = '" + DOB + "'";
				
					//Send Statement
					stmt.executeUpdate(sqlPhone);
				}
				
				if (!(txtCity.getText().equals("")))
				{
					//UPDATE Statement
					String sqlCity =
							"UPDATE customer SET "
									+ "City = '" + upCity + "' "
									+ "WHERE First_Name = '" + firstName + "' "
									+ "AND Last_Name = '" + lastName + "' "
									+ "AND DOB = '" + DOB + "'";
				
					//Send Statement
					stmt.executeUpdate(sqlCity);
				}
				
				if (!(txtState.getText().equals("")))
				{
					//UPDATE Statement
					String sqlState =
							"UPDATE customer SET "
									+ "State = '" + upState + "' "
									+ "WHERE First_Name = '" + firstName + "' "
									+ "AND Last_Name = '" + lastName + "' "
									+ "AND DOB = '" + DOB + "'";
				
					//Send Statement
					stmt.executeUpdate(sqlState);
				}
				
				if (!(txtZip.getText().equals("")))
				{
					//UPDATE Statement
					String sqlZip =
							"UPDATE customer SET "
									+ "ZIP = '" + upZip + "' "
									+ "WHERE First_Name = '" + firstName + "' "
									+ "AND Last_Name = '" + lastName + "' "
									+ "AND DOB = '" + DOB + "'";
				
					//Send Statement
					stmt.executeUpdate(sqlZip);
					JOptionPane.showMessageDialog(null, "Customer info updated.");
					
				}
				//Close Connection
				conn.close();
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,  "ERROR: " + e1.getMessage());
			}
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MainMenu main = new MainMenu();
			main.setVisible(true);
			UserUpdate.this.dispose();
		}
	}
}

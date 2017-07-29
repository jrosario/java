package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class UserInfo extends JFrame {
    //Constants for URL, user name, and password
    final String DB_URL = "jdbc:mysql://localhost:3306/gamesDB";	//URL
    final String USER_NAME = "root";								//Username
    final String PASSWORD = "";										//Password
    
    //Create user object
    private static User user = new User();
    
    //Create list model
    private DefaultListModel userModel;

	private JPanel contentPane;
	private JTextArea txtAreaUserInfo;
	private JButton btnUpdate;
	private JButton btnCheckout;
	private JButton btnReturn;
	private JButton btnExtend;
	private JScrollPane scrollPane;
	private JList lstLoans;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo(user);
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
	public UserInfo(User user) {
		this.user = user;
		String custNum = user.getPhoneNumber();
		String loanNum;
		String copyNum;
		Date startDate;
		Date dueDate;
		Date returnDate;
		
		setTitle("User Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAreaUserInfo = new JTextArea();
		txtAreaUserInfo.setBounds(10, 5, 400, 75);
		getContentPane().add(txtAreaUserInfo);
		//Set Text
		txtAreaUserInfo.setText("Name: " + user.getFirstName() + " " + user.getLastName() 
									+ "\n" + "Phone Number: " + user.getPhoneNumber()
									+ "\n" + "Date of Birth: " + user.getDateOfBirth()
									+ "\n" + "Address: " + user.getAddress()
									+ ", " + user.getCity()
									+ ", " + user.getState()
									+ " " + user.getZip());
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new BtnUpdateActionListener());
		btnUpdate.setBounds(10, 90, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new BtnCheckoutActionListener());
		btnCheckout.setBounds(10, 230, 89, 23);
		getContentPane().add(btnCheckout);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new BtnReturnActionListener());
		btnReturn.setBounds(109, 230, 89, 23);
		getContentPane().add(btnReturn);
		
		btnExtend = new JButton("Extend");
		btnExtend.addActionListener(new BtnExtendActionListener());
		btnExtend.setBounds(208, 230, 89, 23);
		getContentPane().add(btnExtend);
		
		JLabel lblLoans = new JLabel("Loans:");
		lblLoans.setBounds(10, 124, 46, 14);
		contentPane.add(lblLoans);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 400, 75);
		contentPane.add(scrollPane);
		
		lstLoans = new JList();
		lstLoans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstLoans);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(307, 230, 103, 23);
		contentPane.add(btnMainMenu);

	    try {	    
	 	    //Connect to DB
	    	Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	    	
	    	//Statement Object
	    	Statement stmt = conn.createStatement();
	    	
		    userModel = new DefaultListModel();
		    
		    //SELECT Statement
		    String sql =
		    		"SELECT * FROM loan WHERE Cust_Num = '"
		    		+ custNum + "'";
		    //Send Statement
		    ResultSet result = stmt.executeQuery(sql);
		    
		    //Display loans
		    while (result.next())
		    {
		    	loanNum = result.getString("Loan_Num");
		    	copyNum = result.getString("Copy_Num");
		    	startDate = result.getDate("Start_Date");
		    	dueDate = result.getDate("Due_Date");
		    	returnDate = result.getDate("Return_Date");
		    	if (returnDate == null)
		    	{
		    		userModel.addElement("Item: " + copyNum + "; " + "Date Borrowed: " + startDate
		    							+ "; " + "Date Due: " + dueDate);
			    	
			    	//Add Model to JList
			    	lstLoans.setModel(userModel);
		    	}
		    	
		    }
		    
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
		}
	}
	private class BtnUpdateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Create UserUpdate Frame
			UserUpdate update = new UserUpdate(user);
			//Make frame visible
			update.setVisible(true);
			
			//Close this frame
			UserInfo.this.dispose();
		}
	}
	private class BtnCheckoutActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Create Checkout Frame
			LoanAdd loanAdd = new LoanAdd(user);
			//Make frame visible
			loanAdd.setVisible(true);
			
			//Close this frame
			UserInfo.this.dispose();
		}
	}
	private class BtnReturnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Fields
			String selectedLoan = (String) lstLoans.getSelectedValue();
			String[] selectedSplit = selectedLoan.split("[;:]\\s");
			String copyNum = selectedSplit[1];
			
			String returnDate;
			int num = lstLoans.getSelectedIndex();
			
			//Remove selected
			userModel.removeElementAt(num);
			
			//Create DateFormat
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Create calendar
			Calendar cal = Calendar.getInstance();
			returnDate = format.format(cal.getTime());
			
			 try {	    
			 	    //Connect to DB
			    	Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			    	
			    	//Statement Object
			    	Statement stmt = conn.createStatement();
				    
				    //UPDATE Statement
				    String sql =
				    		"UPDATE loan SET Return_Date = '"
				    		+ returnDate + "' WHERE Copy_Num = '"
				    		+ copyNum + "'";
				    //Send Statement
				    stmt.executeUpdate(sql);
				    
				    //New Statement to update the game copy as IN.
				    sql = "UPDATE game_copy SET status = 'IN' WHERE copy_num = '" + copyNum + "'";
				    //Executes the statement to return the game to IN status.
				    stmt.executeUpdate(sql);
				    
				    //Closes the connection.
				    conn.close();
				    
			 } catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
				}
			
		}
	}
	private class BtnExtendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Fields
			String selectedLoan = (String) lstLoans.getSelectedValue();
			String[] selectedSplit = selectedLoan.split("[;:]\\s");
			String copyNum = selectedSplit[1];
			String dueDate;
			int num = lstLoans.getSelectedIndex();
			
			//Create DateFormat
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Create calendar
			Calendar cal = Calendar.getInstance();
			
			
			try {
				//Connect to DB
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				
				//Statement Object
				Statement stmt = conn.createStatement();
				
				//SELECT Statement
				String sql =
						"SELECT Due_Date FROM loan WHERE Copy_Num = '"
							+ copyNum + "'";
				//Send Statement
				ResultSet result = stmt.executeQuery(sql);
				result.next();
				
				//Set due date
				dueDate = result.getString("Due_Date");
				cal.setTime(format.parse(dueDate));
				cal.add(Calendar.DATE, 1);
				String newDueDate = format.format(cal.getTime());
				//UPDATE Statement
				String sqlStatement =
						"UPDATE loan SET Due_Date = '" +
								newDueDate + "' WHERE Copy_Num = '" +
								copyNum + "'";
				//Send Statement
				stmt.executeUpdate(sqlStatement);
				
				userModel.getElementAt(num);
				//userModel = new DefaultListModel();
				userModel.clear();
			    
			    //SELECT Statement
			    sql =
			    		"SELECT * FROM loan WHERE Cust_Num = '"
			    		+ user.getPhoneNumber() + "'";
			    //Send Statement
			    result = stmt.executeQuery(sql);
			    
			    //Display loans
			    while (result.next())
			    {
			    	String loanNum = result.getString("Loan_Num");
			    	copyNum = result.getString("Copy_Num");
			    	Date startDate = result.getDate("Start_Date");
			    	Date dDueDate = result.getDate("Due_Date");
			    	Date returnDate = result.getDate("Return_Date");
			    	if (returnDate == null)
			    	{
			    		userModel.addElement("Item: " + copyNum + "; " + "Date Borrowed: " + startDate
			    							+ "; " + "Date Due: " + dDueDate);
				    	
				    	//Add Model to JList
				    	lstLoans.setModel(userModel);
			    	}
			    	
			    }
				conn.close();
				
				
			} catch (SQLException | ParseException e1) {
				JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
			}
		}
	}
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MainMenu main = new MainMenu();
			main.setVisible(true);
			UserInfo.this.dispose();
		}
	}
}

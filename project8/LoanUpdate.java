/**
 * This class updates the Return Date to of the specified Loan record
 * @author Jose Rosario-Lopez
 * @version 1.0
 */

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Project.Loan;

public class LoanUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoanNumber;
	private JButton btnUpdate;
	private JLabel lblLoanNumber;
	private JDateChooser txtReturnDate;
	private JButton btnClear;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanUpdate frame = new LoanUpdate();
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
	public LoanUpdate() {
		setTitle("Update Return Date");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLoanNumber = new JLabel("Loan Number:");
		lblLoanNumber.setBounds(34, 42, 113, 16);
		contentPane.add(lblLoanNumber);
		
		txtLoanNumber = new JTextField();
		txtLoanNumber.setBounds(150, 37, 130, 26);
		contentPane.add(txtLoanNumber);
		txtLoanNumber.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new BtnUpdateActionListener());
		btnUpdate.setBounds(30, 86, 117, 29);
		contentPane.add(btnUpdate);
		
		txtReturnDate = new JDateChooser();
		txtReturnDate.setDateFormatString("yyyy-MM-dd");
		txtReturnDate.setBounds(294, 37, 119, 26);
		contentPane.add(txtReturnDate);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new BtnClearActionListener());
		btnClear.setBounds(160, 86, 117, 29);
		contentPane.add(btnClear);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new BtnMainMenuActionListener());
		btnMainMenu.setBounds(294, 86, 117, 29);
		contentPane.add(btnMainMenu);
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate localDate = LocalDate.now();
		 //System.out.println(dtf.format(localDate));
		 ((JTextField)txtReturnDate.getDateEditor().getUiComponent()).setText(dtf.format(localDate));
	}

	/**
	 * The ActionListener of btnUpdate, as an inner class
	 */
	private class BtnUpdateActionListener implements ActionListener {
		/**
		 * The actionPerformed method gets user input from text field, prepares the SQL statement
		 * and then executes the statement.
		 * After updating, the text field is reset.
		 * Error Handling: The loan number cannot be empty.
		 */
		public void actionPerformed(ActionEvent e) {
			// Get the user input from text fields
		    String inputLoanNum = txtLoanNumber.getText();
		    
		    int loanNumber = 0;
		    
		    // if the field is empty, show message.
		    if(inputLoanNum.isEmpty() ) {
		    	System.out.println("The loan number cannot be empty.");
		    	JOptionPane.showMessageDialog(null, "The loan number cannot be empty.");
		    	clearContent();
		    }
		    
		    // if the input length is less empty, show message.
		    else if (inputLoanNum.length() < 1)
		    {
		    	System.out.println("The loan number cannot be empty.");
		    	JOptionPane.showMessageDialog(null, "The loan number cannot be empty.");
		    	clearContent();
		    } // if the loan number is good
		    else {
		    	loanNumber = Integer.parseInt(inputLoanNum);
		    	String returnDate  = ((JTextField)txtReturnDate.getDateEditor().getUiComponent()).getText();
		    	
			    // Create a loan object, and fill the field with the value
			    Loan client = new Loan(loanNumber, returnDate);
			    
			    // Create a DAO object
			    LoanDAO loanDao = new LoanDAOImpl();
			    
			    // use the DAO object to insert the record
			    if (loanDao.updateReturnLoan(client) ) {
		    		// Message to the user, showing the end of execution
			    	JOptionPane.showMessageDialog(null, "The record was updated.");
			    	System.out.println("The record was updated.");
	
			    	//clears the text field and sets the focus to it.
			    	clearContent();
			    } 
			    else {
		    		// Message to the user, showing the failure of execution
		    		JOptionPane.showMessageDialog(null, "The record was not updated. \nPlease try again.");
		    		System.out.println("The record was not updated.Please try again.");
		    		clearContent();
			    }
		    }
		} // end actionPerformed
	} //end BtnUpdateActionListener
	
	
	/**
	 * The clearContent method clears the text of all text input fields.
	 * It also sets the focus to the first textfield.
	 */
	private void clearContent() {
		txtLoanNumber.setText("");
		
		//set focus on the textfield
		txtLoanNumber.requestFocus();
		
		// Display the results.
	    System.out.println("Textfields have been cleared.");
	} //end clearContent()
	
	
	/**
	 * The ActionListener of btnClear, as an inner class
	 */
	private class BtnClearActionListener implements ActionListener {
		/**
		 * The actionPerformed method will trigger the clearContent() method.
		 */
		public void actionPerformed(ActionEvent e) {
			clearContent();
		}
	}
	
	private class BtnMainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Instantiate a MainMenu object
			MainMenu mainMenu = new MainMenu();
			
			// set the visibility of the MainMenu to true.
			mainMenu.setVisible(true);			
			
			//Dispose the current frame
			LoanUpdate.this.dispose();
		}
	}
}

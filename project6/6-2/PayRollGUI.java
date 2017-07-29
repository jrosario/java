/**
 * Author: Jose Rosario-Lopez
 * Date: May 3, 2017
 * Program Purpose: This application takes into consideration the employee's name (given by the end-user),
 * 					amount of hours worked, the pay rate, bonus rate (if applicable) and then calculate it.
 * 					Once the calculation is complete, the result will be displayed in the GUI's text area.
 * Input: Name, hours worked, pay rate, bonus rate
 * Output: name, hoursWorked, payRate, $grossPay, $bonus, bonusRate
 */

package edu.unlv.is380.assignment6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.unlv.is380.assignment4.Payroll;
import edu.unlv.is380.labwork18.BankAccount;
import edu.unlv.is380.labwork18.NegativeAmount;
import edu.unlv.is380.labwork18.NegativeStartingBalance;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayRollGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtHours;
	private JTextField txtPayRate;
	private JTextField txtBonusRate;
	private JTextArea txtResult;
	private JButton btnCalculate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayRollGUI frame = new PayRollGUI();
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
	public PayRollGUI() {
		setTitle("Pay Roll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheName = new JLabel("Enter the name:");
		lblEnterTheName.setBounds(23, 19, 137, 16);
		contentPane.add(lblEnterTheName);
		
		txtName = new JTextField();
		txtName.setBounds(20, 36, 250, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEnterTheHours = new JLabel("Enter the hours worked:");
		lblEnterTheHours.setBounds(23, 86, 226, 16);
		contentPane.add(lblEnterTheHours);
		
		txtHours = new JTextField();
		txtHours.setBounds(20, 108, 250, 26);
		contentPane.add(txtHours);
		txtHours.setColumns(10);
		
		JLabel lblEnterThePay = new JLabel("Enter the pay rate:");
		lblEnterThePay.setBounds(23, 160, 226, 16);
		contentPane.add(lblEnterThePay);
		
		txtPayRate = new JTextField();
		txtPayRate.setBounds(20, 181, 250, 26);
		contentPane.add(txtPayRate);
		txtPayRate.setColumns(10);
		
		JLabel lblEnterTheBonus = new JLabel("Enter the bonus rate (between 0 and 1):");
		lblEnterTheBonus.setBounds(23, 230, 247, 16);
		contentPane.add(lblEnterTheBonus);
		
		txtBonusRate = new JTextField();
		txtBonusRate.setBounds(20, 246, 250, 26);
		contentPane.add(txtBonusRate);
		txtBonusRate.setColumns(10);
		
		txtResult = new JTextArea();
		txtResult.setBounds(23, 314, 260, 91);
		contentPane.add(txtResult);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new BtnCalculateActionListener());
		btnCalculate.setBounds(85, 275, 117, 29);
		contentPane.add(btnCalculate);
	}
	
	/**
	 * The ActionListener of btnCalculate, as an inner class
	 */
	private class BtnCalculateActionListener implements ActionListener {
		/**
		 * The actionPerformed method gets user input from text fields, run calculations, then display the results in the GUI
		 * Error Handling: Exception message is displayed
		 */
		public void actionPerformed(ActionEvent e) {
			
			//Fields
			String name = txtName.getText();	// to hold the name of the employee
			Double hours = Double.parseDouble(txtHours.getText());	// to hold the hours the employee worked
			Double payRate = Double.parseDouble(txtPayRate.getText()); // to hold the pay rate of this pay roll
			Double bonusRate = Double.parseDouble(txtBonusRate.getText()); // to hold the bonus rate of this pay roll
			
			// Try to run the following, else catch the exceptions and display the appropriate message.
			try {
				// Instantiating an object of BonusPayRoll class using the name, hours worked, pay rate and the bonus rate.
				BonusPayRoll bonusPayRoll = new BonusPayRoll(name, hours, payRate, bonusRate);
				
				// Display the results in the text area
				txtResult.setText
					(bonusPayRoll.toString() + 
							", \n including the bonus of $" +
							bonusPayRoll.getBonus() +
							" \n(based on the bonus rate of " +
							bonusPayRoll.getBonusRate() + ")." );
			// Catching the appropriate invalid user inputs for hour/pay rate/bonus rate, then throwing the errors when it captures it.
			} catch (InvalidHours e1) {
				// If the user enters an invalid number of hours
				System.out.println(e1.getMessage() );
			} catch (InvalidPayRate e1) {
				// shown if the user enters an invalid pay rate amount
				System.out.println(e1.getMessage() );
			} catch (InvalidBonusRate e1) {
				// shown if the user enters an invalid bonus rate amount
				System.out.println(e1.getMessage() );
			}
		} // end actionPerformed
	} // end BtnCalculateActionListener
} //end PayRollGUI

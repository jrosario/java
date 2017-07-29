/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program calculates the cost of a meal based on the user’s selection. 
 * Input: Total sales for the month
 * Output: The amount of sales tax (county sales tax, state sales tax, and total sales tax)
 */

package edu.unlv.is380.assignment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class MonthlySalesTax extends JFrame {

	private JPanel contentPane;
	private JTextField txtMonthlyTaxInput;
	private JLabel lblCountySalesTax;
	private JLabel lblStateSalesTax;
	private JLabel lblTotalSalesTax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthlySalesTax frame = new MonthlySalesTax();
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
	public MonthlySalesTax() {
		setTitle("Monthly Sales Tax");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Display the label to the user
		JLabel lblEnterSalesTax = new JLabel("Please enter the total sales for the month:");
		lblEnterSalesTax.setBounds(23, 22, 277, 16);
		contentPane.add(lblEnterSalesTax);
		
		// Text field used to gather user's input
		txtMonthlyTaxInput = new JTextField();
		txtMonthlyTaxInput.setBounds(21, 50, 130, 26);
		contentPane.add(txtMonthlyTaxInput);
		txtMonthlyTaxInput.setColumns(10);
		
		// Event-driven button to calculate the tax
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new BtnActionListener());
		btnCalculate.setBounds(23, 88, 117, 29);
		contentPane.add(btnCalculate);
		
		// Labels used to display the output
		lblCountySalesTax = new JLabel("");
		lblCountySalesTax.setBounds(23, 170, 389, 16);
		contentPane.add(lblCountySalesTax);
		
		lblStateSalesTax = new JLabel("");
		lblStateSalesTax.setBounds(23, 200, 389, 16);
		contentPane.add(lblStateSalesTax);
		
		lblTotalSalesTax = new JLabel("");
		lblTotalSalesTax.setBounds(23, 228, 389, 16);
		contentPane.add(lblTotalSalesTax);
	}
	
	// Inner listener triggered when the user clicks the Calculate button
	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Create a DecimalFormat object called formatTotal used to format the output
			DecimalFormat formatTotal = new DecimalFormat("$###,###,###,##0.00");
			
			// Constants used to define the tax percents (in decimal format)
			final double COUNTY_SALES_TAX = 0.02;
			final double STATE_SALES_TAX = 0.04;
			
			// Variable to hold user's input
			String input;
			
			double countyTotal = 0.0;
			double stateTotal = 0.0;
			
			// Hold the grand total value that will be displayed
			double grandTotal = countyTotal + stateTotal;
			
			// Assign the value entered by the user into the 'input' variable.
			input = txtMonthlyTaxInput.getText();
			
			// Operations to gather and set total values
			countyTotal = COUNTY_SALES_TAX * Double.parseDouble(input);
			stateTotal = STATE_SALES_TAX * Double.parseDouble(input);
			grandTotal = countyTotal + stateTotal;
			
			// Display the result
			lblCountySalesTax.setText("County sales tax: " + formatTotal.format(countyTotal));
			lblStateSalesTax.setText("State sales tax: " + formatTotal.format(stateTotal));
			lblTotalSalesTax.setText("Total sales tax: "+  formatTotal.format(grandTotal));
		}
	}
}

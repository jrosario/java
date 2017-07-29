/**
 * Author: Jose Rosario-Lopez
 * Date: April 6, 2017
 * Program Purpose: This application displays the total for a customer's visit to Joe's Automotive.
 * 					Joe performs the routine maintenance services and he also performs other nonroutine services. 
 * 					He charges for parts and labor ($20 per hour).
 * 					For some loyal customers, Joe can choose to give a 10% or 20% discount to the total.
 * Input: Routine Service(s), Nonroutine Services (labor hours and/or total number of parts), discount of 0, 10% off, or 20%
 * Output: The total for a customer's visit. 
 */

package edu.unlv.is380.assignment5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class JoesAutomotive extends JFrame {

	private JPanel contentPane;
	private RoutineServicePanel routineServicePanel;
	private DiscountPanel discountPanel;
	private NonroutineServicePanel nonroutineServicePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoesAutomotive frame = new JoesAutomotive();
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
	public JoesAutomotive() {
		setTitle("Joe's Automotive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Adding the panels to the regions
		routineServicePanel = new RoutineServicePanel();
		contentPane.add(routineServicePanel, BorderLayout.WEST);
		
		discountPanel = new DiscountPanel();
		contentPane.add(discountPanel, BorderLayout.EAST);
		
		nonroutineServicePanel = new NonroutineServicePanel();
		contentPane.add(nonroutineServicePanel, BorderLayout.CENTER);
		
		// Adding the calculate button and attaching an event listener to it
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new BtnCalculateActionListener());
		contentPane.add(btnCalculate, BorderLayout.SOUTH);	
	}

	/* Implementing the Action Listener that is triggered once the user clicks on Calculate button.
	 * When the button is pressed, the total is calculated, based on the service selected, the amount of labor hour(s) entered,
	 * the charge for parts entered, and the discount option selected.
	 */
	private class BtnCalculateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Format for the final total
			DecimalFormat formatter = new DecimalFormat("#0.00");
			
			// Placeholder variables used to calculate to grand total
			double subTotal0, subTotal1, subTotal2 = 0;
			
			// Get the totals for each panel: Routine, Nonroutine, and Discount and store these values into the variables
			double routineTotal = routineServicePanel.getTotal();
			double nonRoutineTotal = nonroutineServicePanel.getTotal();
			double discountTotal = discountPanel.getDiscount() ; //0, .10 or .20
			
			// Do the calculations and store the final value in subTotal2
			subTotal0 = routineTotal + nonRoutineTotal; // e.g., 145
			subTotal1 = subTotal0 * discountTotal; 		// e.g., 14.5
			subTotal2 = subTotal0 - subTotal1; 			// e.g., 145 - 14.5 = 130.5
			
			// Display the formatted total to the user in a message (info) dialog window. 
			JOptionPane.showMessageDialog(null, "The subtotal is: $" + formatter.format(subTotal2)); // 130.5
		}
	}
}

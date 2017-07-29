/**
 * Author: Jose Rosario-Lopez
 * Date: March 28, 2017
 * Program Purpose: This program calculates the cost of a meal based on the user’s selection. 
 * Input: Burger selection and/or side selection
 * Output: The cost of a meal
 */

package edu.unlv.is380.assignment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;

public class CalculateMealCost extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnClassicBurger;
	private JRadioButton rdbtnChickenSandwich;
	private JRadioButton rdbtnDoubleBurger;
	private JLabel lblTotalCost;
	private JCheckBox chckbxFries;
	private JCheckBox chckbxSoftDrink;
	private JCheckBox chckbxBananaSplit;
	private final ButtonGroup buttonGroupSandwiches = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateMealCost frame = new CalculateMealCost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creating the frame and implementing one item Listener for all the radio buttons and check boxes.
	 */
	public CalculateMealCost() {
		setTitle("Meal Cost Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Assigning label values
		JLabel lblSandwiches = new JLabel("Sandwiches:");
		lblSandwiches.setBounds(32, 28, 97, 16);
		contentPane.add(lblSandwiches);
		
		// Setting radio button values and adding the event listeners
		rdbtnClassicBurger = new JRadioButton("Classic Burger");
		rdbtnClassicBurger.addItemListener(new ItemActionListener());
		buttonGroupSandwiches.add(rdbtnClassicBurger);
		rdbtnClassicBurger.setBounds(32, 56, 141, 23);
		contentPane.add(rdbtnClassicBurger);
		
		rdbtnChickenSandwich = new JRadioButton("Chicken Sandwich");
		rdbtnChickenSandwich.addItemListener(new ItemActionListener());
		buttonGroupSandwiches.add(rdbtnChickenSandwich);
		rdbtnChickenSandwich.setBounds(32, 91, 159, 23);
		contentPane.add(rdbtnChickenSandwich);
		
		rdbtnDoubleBurger = new JRadioButton("Double Burger");
		rdbtnDoubleBurger.addItemListener(new ItemActionListener());
		buttonGroupSandwiches.add(rdbtnDoubleBurger);
		rdbtnDoubleBurger.setBounds(32, 127, 141, 23);
		contentPane.add(rdbtnDoubleBurger);
		
		JLabel lblSides = new JLabel("Sides:");
		lblSides.setBounds(269, 28, 61, 16);
		contentPane.add(lblSides);
		
		// Setting check box values and adding the event listeners
		chckbxFries = new JCheckBox("Fries");
		chckbxFries.addItemListener(new ItemActionListener());
		chckbxFries.setBounds(279, 56, 128, 23);
		contentPane.add(chckbxFries);
		
		chckbxSoftDrink = new JCheckBox("Soft Drink");
		chckbxSoftDrink.addItemListener(new ItemActionListener());
		chckbxSoftDrink.setBounds(279, 91, 128, 23);
		contentPane.add(chckbxSoftDrink);
		
		chckbxBananaSplit = new JCheckBox("Banana Split");
		chckbxBananaSplit.addItemListener(new ItemActionListener());
		chckbxBananaSplit.setBounds(279, 127, 128, 23);
		contentPane.add(chckbxBananaSplit);
		
		// Setting the label for displaying the total
		lblTotalCost = new JLabel("");
		lblTotalCost.setBounds(32, 226, 280, 16);
		contentPane.add(lblTotalCost);
	}
	
	/**
	 * Item Listener for all the radio buttons and check boxes. 
	 * When the meal option is selected/de-selected, the total cost is shown.
	 */
	private class ItemActionListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			// Format for the final total
			DecimalFormat formatCost = new DecimalFormat("#0.00");
			
			// Variables to store cost and display output
			double totalCost = 0.00;
			double sandwichCost = 0.00;
			double sideCost = 0.00;
			String resultText = "The total cost is: $ ";

			// Using isSelected() methods for JRadioButton and JCheckBox
			// If the radio buttons are selected, update the total cost
			if(rdbtnClassicBurger.isSelected()) {
				sandwichCost = 5.50;
				totalCost += sandwichCost;
			}
			
			if(rdbtnChickenSandwich.isSelected()) {
				sandwichCost = 4.50;
				totalCost += sandwichCost;
			}
							
			if(rdbtnDoubleBurger.isSelected()) {
				sandwichCost = 6.50;
				totalCost += sandwichCost;
			}
			
			
			// If the check boxes are de/selected, update the total cost
			if(chckbxFries.isSelected()) {
				sideCost = 3.00;
				totalCost += sideCost;
			}
			
			if(chckbxSoftDrink.isSelected()) {
				sideCost = 2.00;
				totalCost += sideCost;
			}
			
			if(chckbxBananaSplit.isSelected()) {
				sideCost = 5.00;
				totalCost += sideCost;
			} 
			
			// Display the formatted total to the user
			lblTotalCost.setText(resultText + formatCost.format(totalCost) );
			
		}
	}
} //end CalculateMealCost class

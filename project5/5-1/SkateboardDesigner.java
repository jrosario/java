/**
 * Author: Jose Rosario-Lopez
 * Date: April 6, 2017
 * Program Purpose: This application holds decks, axles, and wheel design options. 
 * The user should select a deck design, an axle design, and a wheel design.
 * Input: Deck, Axle, and Wheel design selections
 * Output: The total cost of the skateboard design. 
 */

package edu.unlv.is380.assignment5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SkateboardDesigner extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbbxDecks;
	private JComboBox cmbbxAxle;
	private JComboBox cmbbxWheel;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkateboardDesigner frame = new SkateboardDesigner();
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
	public SkateboardDesigner() {
		setTitle("Skateboard Designer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Assigning the initial (left-side) label name and boundaries to indicate what the combo boxes are.
		JLabel lblDecks = new JLabel("Decks");
		lblDecks.setBounds(29, 28, 61, 16);
		contentPane.add(lblDecks);
		
		JLabel lblTruckAssemblies = new JLabel("Truck Assemblies");
		lblTruckAssemblies.setBounds(29, 83, 128, 16);
		contentPane.add(lblTruckAssemblies);
		
		JLabel lblWheels = new JLabel("Wheels");
		lblWheels.setBounds(29, 132, 61, 16);
		contentPane.add(lblWheels);
		
		// Label that will be used to display the total cost to the user after they select an item from the combo box(es)
		lblResult = new JLabel("");
		lblResult.setBounds(29, 199, 347, 16);
		contentPane.add(lblResult);
		
		// Creating the combo boxes and adding the unique items to their respective boxes.
		// Also handling action events by adding an action event listener class, which has an actionPerformed method
		cmbbxDecks = new JComboBox();
		cmbbxDecks.addActionListener(new cmbbxActionListener());
		cmbbxDecks.setModel(new DefaultComboBoxModel(new String[] {"The Master Thrasher: $60", "The Dictator: $45", "The Street King: $50"}));
		cmbbxDecks.setBounds(164, 24, 212, 27);
		contentPane.add(cmbbxDecks);
		
		cmbbxAxle = new JComboBox();
		cmbbxAxle.addActionListener(new cmbbxActionListener());
		cmbbxAxle.setModel(new DefaultComboBoxModel(new String[] {"7.75 inch axle: $35", "8 inch axle: $40", "8.5 inch axle: $45"}));
		cmbbxAxle.setBounds(164, 79, 212, 27);
		contentPane.add(cmbbxAxle);
		
		cmbbxWheel = new JComboBox();
		cmbbxWheel.addActionListener(new cmbbxActionListener());
		cmbbxWheel.setModel(new DefaultComboBoxModel(new String[] {"51 mm: $20", "55 mm: $22", "58 mm: $24", "61 mm: $28"}));
		cmbbxWheel.setBounds(164, 128, 212, 27);
		contentPane.add(cmbbxWheel);
	}


	/* When the user selects an item in a combo box, the combo box fires this action event listener's actionPerformed method,
	* which passes an ActionEvent object as an argument.
	*/
	
	private class cmbbxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Creating named constants (prices) for the decks, assembly axles, and wheels
			final int DECK_MASTER_THRASHER = 60;
			final int DECK_DICTATOR = 45;
			final int DECK_STREET_KING = 50;
			 
			final int AXLE_7_75_INCH = 35;
			final int AXLE_8_INCH = 40;
			final int AXLE_8_5_INCH = 45;
			 
			final int WHEEL_51_MM = 20;
			final int WHEEL_55_MM = 22;
			final int WHEEL_58_MM = 24;
			final int WHEEL_61_MM = 28;
			
			// Format for the final total
			DecimalFormat formatter = new DecimalFormat("#0.00");
			
			// Variables to hold the selected index
			int indexDeck, indexAxle, indexWheel;
			
			// Placeholder variable for total cost
			double total = 0;

			// Get the currently selected index from the combo boxes and assign it to the variables
			indexDeck = cmbbxDecks.getSelectedIndex();		// Can be: 0, 1, or 2
			indexAxle = cmbbxAxle.getSelectedIndex();		// Can be: 0, 1, or 2
			indexWheel = cmbbxWheel.getSelectedIndex();		// Can be: 0, 1, 2, or 3
			
			
			// Switch statement that receives the selected Deck index and assigns it a cost. It defaults to 0 otherwise
			switch(indexDeck) {
				case 0:
					//System.out.println("Deck: " + indexDeck);
					total += DECK_MASTER_THRASHER;
				break;
				
				case 1: 
					//System.out.println("Deck: " + indexDeck);
					total += DECK_DICTATOR;
				break;
				
				case 2:
					//System.out.println("Deck: " + indexDeck);
					total += DECK_STREET_KING;
				break;
				
				default:
					total += 0;
				break;
			}
			
			
			// Switch statement that receives the selected Axle index and assigns it a cost. It defaults to 0 otherwise
			switch(indexAxle) {
				case 0:
					//System.out.println("Axle: " + indexAxle);
					total += AXLE_7_75_INCH;
				break;
			
				case 1: 
					//System.out.println("Axle: " + indexAxle);
					total += AXLE_8_INCH;
				break;
			
				case 2:
					//System.out.println("Axle: " + indexAxle);
					total += AXLE_8_5_INCH;
				break;
				
				default:
					total += 0;
				break;
			}
			
			
			// Switch statement that receives the selected Wheel index and assigns it a cost. It defaults to 0 otherwise
			switch(indexWheel) {
				case 0:
					//System.out.println("Wheel: " + indexWheel);
					total += WHEEL_51_MM;
				break;
			
				case 1: 
					//System.out.println("Wheel: " + indexWheel);
					total += WHEEL_55_MM;
				break;
			
				case 2:
					//System.out.println("Wheel: " + indexWheel);
					total += WHEEL_58_MM;
				break;
				
				case 3:
					//System.out.println("Wheel: " + indexWheel);
					total += WHEEL_61_MM;
				break;
				
				default:
					total += 0;
				break;
			}
			
			
			// Display the formatted total to the user
			lblResult.setText("The total is: $" + formatter.format(total) );
		}
	}

}

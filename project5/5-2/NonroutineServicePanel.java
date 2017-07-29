/**
 * Author: Jose Rosario-Lopez
 * Date: April 6, 2017
 * Program Purpose: This application serves to develop the JPanel for nonroutine services. In this panel, the price for labor per hour is fixed, as of today, at $20.
 * 					This also provides a method that calculates the total cost for nonroutine services. 
 * 					For example, when the user enters 3 hours of labor and 50 for parts, the method will return 110.
 * Output: The total cost for a customer's nonroutine service. 
 */

package edu.unlv.is380.assignment5;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class NonroutineServicePanel extends JPanel {
	private JTextField txtLabor;
	private JTextField txtParts;
	private JLabel lblLabor;
	private JLabel lblHours;
	private JLabel lblParts;
	
	// Creating named constant for the labor hours. Value is fixed.
	public final int LABOR_PER_HOUR = 20;

	/**
	 * Create the panel.
	 */
	public NonroutineServicePanel() {
		
		//Setting the border with a proper title
		setBorder(new TitledBorder(null, "Nonroutine Services", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// Grid Layout with 1 column, 5 rows.
		setLayout(new GridLayout(5, 1, 0, 0));
		
		// Adding Labels
		lblLabor = new JLabel("Labor:");
		add(lblLabor);
		
		// Setting the default text of the labor hour text field to 0.
		txtLabor = new JTextField();
		txtLabor.setText("0");
		add(txtLabor);
		txtLabor.setColumns(10);
		
		lblHours = new JLabel("hours");
		add(lblHours);
		
		lblParts = new JLabel("Parts:");
		add(lblParts);
		
		// Setting the default text of the parts text field to 0.
		txtParts = new JTextField();
		txtParts.setText("0");
		add(txtParts);
		txtParts.setColumns(10);

	}
	
	// Method that calculates and returns the total cost for the non-routine service
	public double getTotal() {
		String textLaborValue = txtLabor.getText();
		String textPartsValue = txtParts.getText();
		
		double laborOutput = Double.parseDouble(textLaborValue);
		double partsOutput = Double.parseDouble(textPartsValue);
		double output = 0;
		
			output = (laborOutput * LABOR_PER_HOUR) + partsOutput;
	
		return output;
	}

}

package edu.unlv.is380.assignment5;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

public class DiscountPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnRegular;
	private JRadioButton rdbtn20Off;
	private JRadioButton rdbtn10Off;

	/**
	 * Create the panel.
	 */
	public DiscountPanel() {
		setBorder(new TitledBorder(null, "Discount", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 1, 0, 0));
		
		rdbtnRegular = new JRadioButton("RegularPrice", true);
		buttonGroup.add(rdbtnRegular);
		add(rdbtnRegular);
		
		rdbtn10Off = new JRadioButton("10% Off");
		buttonGroup.add(rdbtn10Off);
		add(rdbtn10Off);
		
		rdbtn20Off = new JRadioButton("20% Off");
		buttonGroup.add(rdbtn20Off);
		add(rdbtn20Off);

	}
	
	public double getDiscount(){
		if(rdbtnRegular.isSelected())
			return 0;
		else if(rdbtn10Off.isSelected())
			return .10;
		else if(rdbtn20Off.isSelected())
			return .20;
		else
			return 0;
	}

}

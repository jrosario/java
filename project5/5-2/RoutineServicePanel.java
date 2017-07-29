package edu.unlv.is380.assignment5;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class RoutineServicePanel extends JPanel {
	private JCheckBox chckbxTireRotation;
	private JCheckBox chckbxMufflerReplacement;
	private JCheckBox chckbxInspection;
	private JCheckBox chckbxTransmissionFlush;
	private JCheckBox chckbxRadiatorFlush;
	private JCheckBox chckbxLubeJob;
	private JCheckBox chckbxOilChange;

	/**
	 * Create the panel.
	 */
	public RoutineServicePanel() {
		setBorder(new TitledBorder(null, "Routine Services", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(7, 1, 0, 0));
		
		chckbxOilChange = new JCheckBox("Oil Change");
		add(chckbxOilChange);
		
		chckbxLubeJob = new JCheckBox("Lube Job");
		add(chckbxLubeJob);
		
		chckbxRadiatorFlush = new JCheckBox("Radiator Flush");
		add(chckbxRadiatorFlush);
		
		chckbxTransmissionFlush = new JCheckBox("Transmission Flush");
		add(chckbxTransmissionFlush);
		
		chckbxInspection = new JCheckBox("Inspection");
		add(chckbxInspection);
		
		chckbxMufflerReplacement = new JCheckBox("Muffler Replacement");
		add(chckbxMufflerReplacement);
		
		chckbxTireRotation = new JCheckBox("Tire Rotation");
		add(chckbxTireRotation);

	}
	
	public double getTotal(){
		double total=0;
		if(chckbxOilChange.isSelected())
			total+=AutoJob.OIL_CHANGE.getPrice();
		if(chckbxLubeJob.isSelected())
			total+=AutoJob.LUBE_JOB.getPrice();
		if(chckbxRadiatorFlush.isSelected())
			total+=AutoJob.RADIATOR_FLUSH.getPrice();
		if(chckbxTransmissionFlush.isSelected())
			total+=AutoJob.TRANSMISSION_FLUSH.getPrice();
		if(chckbxInspection.isSelected())
			total+=AutoJob.INSPECTION.getPrice();
		if(chckbxMufflerReplacement.isSelected())
			total+=AutoJob.MUFFLER_REPLACEMENT.getPrice();
		if(chckbxTireRotation.isSelected())
			total+=AutoJob.TIRE_ROTATION.getPrice();
		return total;
	}

}

/**
 * Author: Jose Rosario-Lopez
 * Date: March 8, 2017
 * Program Purpose: This application serves to randomly generate a side (either heads or tails).
 * Input: Side and face value
 * Output: The ending balance
 */


package edu.unlv.is380.assignment3;

import java.util.Random;

public class Coin {
	
	//fields
	private String sideUp;
	private Double faceValue;
	

	//constructor
	public Coin(){
		
		// Instantiate the Random class and create a new object
		Random rand = new Random();
		
		if( rand.nextInt(2) == 0 ){
			sideUp = "Heads";
		} else {
			sideUp = "Tails";
		}
	
	} //end Coin()
	
	
	/**
     * Generating a random side with each toss
     */
	public void toss() {
		Random rand = new Random();
		
		if( rand.nextInt(2) == 0 ){
			sideUp = "Heads";
		} else {
			sideUp = "Tails";
		}
	} // end toss()

	
	
	
	/** Method to get which side landed
     * @return The side (heads or tail)
     */
	public String getSideUp() {
		return sideUp;
	}

	
	
	/** Method to get the face value of a coin toss
     * @return The face value
     */
	public Double getFaceValue() {
		return faceValue;
	}

	
	
	/** Method to set the face value of a coin toss
     * @return The face value of that coin
     */
	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}

	
} //end Coin

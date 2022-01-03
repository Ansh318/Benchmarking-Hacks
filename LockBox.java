//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CLass Fish Tank that will stimulate various features in the graphic user interface application. 
// Course:   CS 300 Fall 2021
//
// Author:   (Ansh Agarwal)
// Email:    (argarwal@wisc.edu)
// Lecturer: (Mouna Kacem)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment. 
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (Aryaman Agarwal(Peer Mentor) helped me understand the logic of generating a password of given length)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;


/**
 * @author anshagarwal
 */
public class LockBox {
	protected static Random randGen;
	private String password;
	private boolean isOpen;

	/**
	 * @param passwordLength 
	 * Constructor of the LockBox class which generates a random password of only numbers and assigns the value to the private variable password
	 * Length of password is equal to passwordLength
	 */
	public LockBox(int passwordLength) {
		if (randGen == null) {
			randGen = new Random();
		}
		
		if(passwordLength <= 0) {
			throw new IllegalArgumentException("Invalid password length");
		}
		int val = 1;
		for (int i = 0; i < passwordLength ; i++) {
			val *= 10;
		}
		password = String.valueOf(randGen.nextInt(val - 1));
	}
	/**
	 * @param Guess
	 * Check if the guess is equal to the password
	 * Set the instance field isOpen to true if the guess is the same as the password
	 */
	public void authenticate(String guess) {
		if (guess.equals(password)) {
			isOpen = true;
		}
	}
	/**
	 * 
	 * @return password of Lockbox 
	 */
	public String hackMe() {
		return password;
	}
	/**
	 * 
	 * @return Instance field isOpen
	 */
	public boolean isOpen() {
		return isOpen;
	}
	/**
	 * Reset the LockBox by setting the instance field isOpen to False
	 */
	public void reset() {
		isOpen = false;
	}
}

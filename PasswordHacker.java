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
// Persons:         (None)
// Online Sources:  (None)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * @author anshagarwal
 */
public class PasswordHacker {
	private LockBox toPick;
	private int passwordLength;
	
	/**
	 * @param passwordLength 
	 * This constructor should store the provided password length for future reference and
	 * Creates a new LockBox with a password of the same length.
	 */
	public PasswordHacker(int passwordLength) {
		 this.passwordLength = passwordLength;
         toPick = new LockBox(passwordLength);
       
	}
	/**
	 * Resets the LockBox so that user has something to hack into.
	 * Asks for a password 
	 * use the password to open the LockBox.
	 */
	public void hack() {
		toPick.reset();
		String password = toPick.hackMe();
		toPick.authenticate(password);
		
	}
	/**
	 * Resets the LockBox so that user has something to hack into.
	 * generate guesses methodically until the LockBox opens.
	 */
	public void bruteForce() {
		toPick.reset();
		int count = 0;
		while(true){
            String password = generateGuess(count);
            toPick.authenticate(password);
            if(toPick.isOpen())
                    break;
            count++;
    }
		
	}
	/**
	 * Given the number of times the user guesses a password (count), produce the password to try on this iteration. 
	 * @param count
	 * @return Guess
	 */
	public String generateGuess(int count) {
		int val1 = 1;
		int val2 = 10;
		int count_copy = count;
		String Guess = "";
		
		for(int j = passwordLength; j > 0; j--) {
			int x = (count_copy % val2)/val1;

			if(j == passwordLength) {
				Guess = String.valueOf(x);  
				count_copy -= x;
			}
			else if(x == 0) {
				Guess = "0" + Guess;
			}
			else if(x == 0 && j == passwordLength) {
				Guess = "0";
			}
			else { 
				Guess = String.valueOf(x) + Guess;
				count_copy -= x;
			}
			val1 = val2;
			val2 *= 10;
		}
		return Guess;
	}
}



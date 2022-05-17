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

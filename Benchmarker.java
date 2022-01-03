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
public class Benchmarker {
	
    /**
     * Calculates the time taken to execute the PasswordHacker's Hack approach to unlock the Lockbox
     * @param ph 
     * @return elapsedTime
     */
	public static long timeHack(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.hack();
		long elapsedTime = System.currentTimeMillis() - startTime;
		return elapsedTime;
	}
    /**
     * Calculates the time taken to execute the PasswordHacker's BruteForce approach to unlock the Lockbox
     * @param ph 
     * @return elapsedTime
     */
	public static long timeBruteForce(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.bruteForce();
		long elapsedTime = System.currentTimeMillis() - startTime;
		return elapsedTime;
	}
	/**
	 * @param passwordLength
	 * @param numRuns Number of trials for the hack method and brute force method to unlock the LockBox.
	 * @return Average time taken by the hack method and brute force method to unlock the Lockbox. Return value is of type int
	 */
	public static String race(int passwordLength, int numRuns) {
		PasswordHacker ph = new PasswordHacker(passwordLength);
		long time_hack = (long) 0.0;
		long time_brute_force = (long)0.0;
		
		for (int i = 0; i < numRuns ; i ++) {
			time_hack += timeHack(ph);
			time_brute_force += timeBruteForce(ph);
		}
		
		String avg_hack = Long.toString(time_hack/numRuns);
		String avg_bf = Long.toString(time_brute_force/numRuns);
		return "Brute force " + passwordLength + ":" + avg_bf + "\n" + "Hack " + passwordLength + ":" + avg_hack;
	}

}

/*
 * Author: Chris Cordaro
 * File: mwc_driver.java
 * Course: Formal Languages and Computability CMPT_440
 * Assignment: Homework 1
 * Version: 1.0
 * 
 * 
 * 
 * This driver file will read from the standard input and creates a new MWC.java class and runs the DFA
 * 
 */

package wolf_man_cabbage;
import java.io.IOException;
/*
 * Will read from standard input and create a new instance of the mwc.java class
 * Runs the standard input through the transition table and returns to the user whether that input is valid
 * 
 */
public class driverDFA {
	
	public static void main(String[] args){
		try{
			ManWolf myMwc = new ManWolf();//new dfa
			String myInput = args[0];
			ManWolf.process(args[0]);
			while(myInput != null){
				myMwc.reset();
				myMwc.process(myInput);
				if(myMwc.accepted()){
					System.out.println("YOU ENTERED A VALID SOLUTION");
					System.exit(0);
				}else{
					System.out.println("YOU DID NOT ENTER A VALID SOLUTION");
					System.exit(0);
				}			
			}
		}catch(ArrayIndexOutOfBoundsException ex){
			System.err.println("No arg provided");
		}
	}
}

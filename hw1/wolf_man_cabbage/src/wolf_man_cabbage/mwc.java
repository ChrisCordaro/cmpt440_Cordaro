package wolf_man_cabbage;
/*
 * Author: Chris Cordaro
 * File: mwc_.java
 * Course: Formal Languages and Computability CMPT_440
 * Assignment: Homework 1
 * Version: 1.0
 * 
 * 
 * 
 * This file defines a mwc.java class which will take in a string as input and reports whether that string 
 * is a valid answer to the Wolf Goat Cabbage problem
 * 
 * 
 * 
 * This class uses code found in the textbook in order 
 * to implement a solution to the problem
 * 
 */

public class ManWolf {
	private static final int q0 = 0;//Start
	private static final int q1 = 1;
	private static final int q2 = 2;
	private static final int q3 = 3;
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;
	private static final int q7 = 7;
	private static final int q8 = 8;
	private static final int q9 = 9;//Accepting
	private static final int q10 = 10;//Error
	
	private static int state=0;
	static private int[][] delta = 
	/*
	 * Delta represents the transition table
	 */
		
			  /*W  G  C  N */		
		{     {q10, q1, q10, q10},
		      {q10, q0, q10, q2},
		      {q3, q10, q4, q1},
		      {q2, q5, q10, q10},
		      {q10, q6, q2, q10},
		      {q10, q3, q7, q10},
		      {q7, q4, q10, q10},
		      {q6, q10, q5, q8},
		      {q10, q9, q10, q7},
		      {q10, q8, q10, q10}
				
		};
	
	/*
	 * @param in is the input from the command line/project args
	 */
	
	static void process(String in){
		int index=0;
		for(int i=0; i < in.length(); i++){	
			char c = in.charAt(i);	
			try{
				if(c=='w'){
					index = 0; 
				}else if(c=='g'){
					index = 1;
				}else if(c=='c'){
					index = 2;
				}else if(c=='n'){
					index = 3;
				}else{
					index = -1;
				}		
				state = delta[state][index];
			}catch(ArrayIndexOutOfBoundsException ex){				
				state = q10;
			}
		}
	}
	
	/*
	 * resets dfa to initial state
	 */
	public void reset(){
		state = q0;
	}
	
	/*
	 * returns true if the input entered reaches the accepted state
	 */
	public boolean accepted(){
		return state==q9;
	}
}

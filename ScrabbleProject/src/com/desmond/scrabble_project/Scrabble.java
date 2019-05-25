package com.desmond.scrabble_project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Scrabble {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Welcome to Scramble lite (very-very lite). \n");
		
		Scanner userInputScan = new Scanner(System.in);
		System.out.println("Enter 'N' to start a new game. Enter 'C' to end the game.");
		
		String userText = userInputScan.next().toLowerCase();
		if(userText.equals("n")) {
			System.out.println("You entered: " + userText + ". Get ready!");
			System.out.println("==========================");
			String hand[] = initializeHand();
			String currentHand[] = getCurrentHand(hand);
			printHand(hand);
			System.out.println("");
			System.out.println("==========================");
			userGuess(currentHand);
		} else if(userText.equals("c")) {
			System.out.println("Bye Bye!"); ;
		} else {
			System.out.println("That's not an option...");
		}
		
		
//		//2. Loop thru the text file until we hit our 'n'
//		int counter = 0;
//		StringBuilder currentHand = new StringBuilder("");
//		
//		File wordFile = new File("words.txt");
//		Scanner scan = new Scanner(wordFile);
//		
//		while(counter <= n) {
//			if(counter == n) {
//				currentHand.append(scan.nextLine());
//			}
//			System.out.println(scan.nextLine());
//			System.out.println("counter is: " + counter);
//			counter++;
//			
//		}
	}
	// Input: none
	// Expected output: return an array of strings 
	public static String[] initializeHand() {
		
		String vowels[] = {"a" ,"e", "i", "o", "u"};
		String consonants[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
		
		//1. Initialize the players hand
		String currentHand[] = new String[7];
		
		int handCount = 0;
		
		//2. Fill the players array with random items from vowels / consonants arrays
		while(handCount < 7) {
			Random randomNum = new Random();
			int consonantNum = randomNum.nextInt(consonants.length);
			int vowelNum = randomNum.nextInt(vowels.length);
			
			currentHand[handCount] = consonants[consonantNum];
			if(handCount % 2 == 1 && handCount < 4) {
				currentHand[handCount] = vowels[vowelNum];
			}
			handCount++;
		}
		return currentHand;
		
		
	}
	
	// Input: an array of strings
	// Expected output: print to console player's current hand
	public static void printHand(String[] hand) {
		System.out.println("Your hand is: ");
		for(int i = 0; i < hand.length; i++) {
			if(i > 0) {
				System.out.print(", ");
			}
			System.out.print(hand[i]);
		}
	}
	
	//Input: an array with our current hand
	//Expected output: Ask user for input and print out what we guessed
	public static void userGuess(String[] currentHand) throws FileNotFoundException {
		Scanner guessObj = new Scanner(System.in);
		System.out.println("Please enter a word using the hand given to you: ");
		String guess = guessObj.next();
		System.out.println("You guessed: " + guess);
		checkGuess(guess, currentHand);
	}
	
	//Input: an array with our current hand and a string with our guess
	//Expected output: Print if we found a match or not.
	public static void checkGuess(String guess, String[] currentHand) throws FileNotFoundException {
		System.out.println("Checking your guess..");
		File wordFile = new File("shortwordslist.txt");
		Scanner scan = new Scanner(wordFile);
		Boolean foundFlag = false;
		//1. Check if it exists in our word list
		while(scan.hasNextLine()) {
			String line = scan.next();
			if(line.equals(guess)) {
				foundFlag = true;
				break;
			}
					
		}
		
		if(foundFlag) {
			System.out.println("Found "+ guess);
		} else {
			System.out.println("Did not find "+ guess);
		}
	}
	
	public static String[] getCurrentHand(String[] hand) {
		return hand;
	}

}

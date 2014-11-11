package edu.dcu.problemSolving.countingDown;

import java.util.ArrayList;

public class Combinations {

	public static void possibleStrings(int maxLength, char[] alphabet, String curr,
			ArrayList<String> combinations) {
		// If the current string has reached its maximum length
		if (curr.length() == maxLength) {
			// System.out.println(curr);
			combinations.add(new String(curr));
			// Else add each letter from the alphabet to new strings and process
			// these new strings again
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				String oldCurr = curr;
				curr += alphabet[i];
				possibleStrings(maxLength, alphabet, curr, combinations);
				curr = oldCurr;
			}
		}
	}

	public static void main(String[] args) {
		// If the current string has reached it's maximum length
		// Create an alphabet to work with
		char[] alphabet = new char[] { '+', '*', '-', '/', '%' };
		// Find all possible combinations of this alphabet in the string size of
		// 3
		ArrayList<String> combinations = new ArrayList<>();
		Combinations.possibleStrings(5, alphabet, "", combinations);

		for (String combination : combinations) {
			System.out.println(combination);
		}

		System.out.println("total " + combinations.size());
	}
}

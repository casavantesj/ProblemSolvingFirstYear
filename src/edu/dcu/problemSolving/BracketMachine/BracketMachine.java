package edu.dcu.problemSolving.BracketMachine;

public class BracketMachine {

	public static boolean isWellBracket(String string) {
		int counter = 0;
		char[] chatString = string.toCharArray();

		for (int i = 0; i < chatString.length; i++) {

			if (chatString[i] == '(') {
				counter++;

			}

			if (chatString[i] == ')') {
				counter += -1;

			}

			if (counter == -1) {
				return false;
			}

		}

		if (counter != 0) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BracketMachine.isWellBracket("((6+8) + (5*5))"));

	}

}

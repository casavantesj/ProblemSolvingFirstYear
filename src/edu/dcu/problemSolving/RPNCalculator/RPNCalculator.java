package edu.dcu.problemSolving.RPNCalculator;

import java.util.Scanner;

public class RPNCalculator {

	public static void makeOperation(String string) {

		char[] charArray = string.toCharArray();
		char firstDigit;
		char secondDigit;
		char operator;
		int operation = 0;
		int result;
		int i = 0;
		int j = charArray.length - 1;

		while (i < j) {

			operator = charArray[j];
			firstDigit = charArray[i];
			secondDigit = charArray[i + 1];

			result = doOperation(operator, firstDigit, secondDigit);

			charArray[i + 1] = (char) (result + '0');

			i++;
			j--;
		}
	}

	public static int doOperation(char operator, char firstDigit,
			char secondDigit) {
		int result = 0;
		switch (operator) {

		case '+':
			result = (int) (firstDigit - '0') + (int) (secondDigit - '0');
			System.out.println(result);
			break;
		case '-':
			result = (int) (firstDigit - '0') - (int) (secondDigit - '0');
			System.out.println(result);
			break;
		case '/':
			result = (int) (firstDigit - '0') + (int) (secondDigit - '0');
			System.out.println(result);
			break;

		}
		return result;
	}

	public static void main(String[] args) {
		RPNCalculator.makeOperation("372+-");
	}

}

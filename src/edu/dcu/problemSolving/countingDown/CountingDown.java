package edu.dcu.problemSolving.countingDown;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CountingDown {

	public static Integer rpnCalculator(String rpnExpressions) {
		Deque<Integer> stack = new ArrayDeque<>();
		char[] allRpnExpressions = rpnExpressions.toCharArray();
		char operator;
		Integer value;
		Integer firstOperantor;
		Integer secondOperantor;
		Integer result = 0;
		for (int i = 0; i < allRpnExpressions.length; i++) {

			if (!isOperantor(allRpnExpressions[i])) {
				value = Integer.valueOf(allRpnExpressions[i] - '0');
				stack.push(value);
			} else {
				operator = allRpnExpressions[i];
				secondOperantor = stack.pop();
				System.out.println("second operator: " + secondOperantor);

				firstOperantor = stack.pop();
				System.out.println("first Operator :" + firstOperantor);

				result = implementOpeation(firstOperantor, secondOperantor, operator);

				stack.push(result);

			}

		}

		return result;
	}

	public static boolean isOperantor(char c) {
		return c == '+' || c == '-' || c == '/' || c == '*' || c == '%';
	}

	public static Integer implementOpeation(Integer firstOperantor, Integer secondOperantor,
			char operator) {
		int result = 0;
		switch (operator) {

		case '+':
			result = firstOperantor + secondOperantor;
			// System.out.println(result);
			break;
		case '-':
			result = firstOperantor - secondOperantor;
			// System.out.println(result);
			break;
		case '/':
			result = firstOperantor / secondOperantor;
			;
			// System.out.println(result);
			break;

		case '*':
			result = firstOperantor * secondOperantor;
			;
			// System.out.println(result);
			break;

		case '%':
			result = firstOperantor * secondOperantor;
			;
			// System.out.println(result);
			break;

		}
		return result;

	}

	/**
	 * eg, given 2 & [3][6][8][9] this will return [3][6], [3][8], [3][9],
	 * [6][8], [6][9], [8][9].. see unit test
	 */
	public ArrayList<String> getPermutationsOfNumberSelection(int n, String[] selection) {
		List<String[]> result = new LinkedList<String[]>();
		ArrayList<String> resultStrings = new ArrayList<>(result.size());
		permute(0, Arrays.asList(selection), result);
		for (String[] permutation : result) {
			String currString = arrayToString(permutation);
			System.out.println(currString);
			resultStrings.add(currString);
		}
		return resultStrings;
	}

	private String arrayToString(String[] permutation) {
		StringBuilder sb = new StringBuilder();
		for (String ch : permutation) {
			sb.append(ch);
		}
		return sb.toString();
	}

	private void permute(int n, List<String> selection, List<String[]> result) {
		for (int i = n; i < selection.size(); i++) {
			Collections.swap(selection, i, n);
			permute(n + 1, selection, result);
			Collections.swap(selection, n, i);
		}
		if (n == selection.size() - 1) {
			String[] copy = (String[]) Arrays.copyOf(selection.toArray(), selection.size());
			result.add(copy);
		}
	}

	// return all posibles combinations btw operands and numbers;
	public static String combine(String selectionOfNumbers, String selectionOfOperators) {
		// ArrayList<String> combinations = new ArrayList<>();

		// System.out.println(selectionOfNumbers + selectionOfOperators);

		return selectionOfNumbers + selectionOfOperators;

	}

	public static ArrayList<String> getAllPosiblesCombinations(
			ArrayList<String> selectionOfNumbers, ArrayList<String> selectionOfOperators) {
		ArrayList<String> allPosiblesCombinations = new ArrayList<>();

		for (String numberCombination : selectionOfNumbers) {
			for (String operatorCombination : selectionOfOperators) {
				allPosiblesCombinations.add(combine(numberCombination, operatorCombination));
			}
		}
		return allPosiblesCombinations;
	}

	public static String doOperations(ArrayList<String> allPosiblesCombination,
			Integer espectedNumber) {
		Integer result;

		for (String combination : allPosiblesCombination) {
			result = CountingDown.rpnCalculator(combination);

			if (result.equals(espectedNumber)) {

				return combination;
			}

		}
		return "no find it";

	}

	public static void main(String[] args) {

	}

}

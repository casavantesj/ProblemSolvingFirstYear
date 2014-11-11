package edu.dcu.problemSolving.countingDown;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.dcu.problemSolving.RPNCalculator.RPNCalculator;

public class CountingDownTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIfIsOperantor() {
		CountingDown countingDown = new CountingDown();
		assertTrue(countingDown.isOperantor('+'));
		assertFalse(countingDown.isOperantor('2'));
	}

	@Test
	public final void testIfImplementOperator() {
		CountingDown countingDown = new CountingDown();
		Integer result = 5;
		assertEquals(result, CountingDown.implementOpeation(2, 3, '+'));
	}

	@Test
	public final void testIfReturnCorrectValue() {
		CountingDown countingDown = new CountingDown();
		Integer result = -4;
		assertEquals(result, CountingDown.rpnCalculator("352+-"));
	}

	@Test
	public final void testIfReturnCorrectValueWithMoreNumbersS() {
		CountingDown countingDown = new CountingDown();
		Integer result = 50;
		assertEquals(result, CountingDown.rpnCalculator("37+812+-*"));
	}

	@Test
	public final void testIfReturnCombinations3of3() {
		CountingDown countingDown = new CountingDown();

		String[] selection = new String[] { "3", "2", "1" };

		assertEquals(6, countingDown.getPermutationsOfNumberSelection(3, selection).size());
	}

	@Test
	public final void testIfReturnCombinations3of4() {
		CountingDown countingDown = new CountingDown();

		String[] selection = new String[] { "3", "2", "1", "4" };

		assertEquals(24, countingDown.getPermutationsOfNumberSelection(3, selection).size());
	}

	@Test
	public final void testIfcombinePermutationsWithCombinations() {
		CountingDown countingDown = new CountingDown();

		String selectionNumbers = "321";
		// selectionNumbers.add("2");
		// selectionNumbers.add("1");

		String selectionOperantos = "+-+";
		// selectionOperantos.add("-");
		// selectionOperantos.add("+");

		CountingDown.combine(selectionNumbers, selectionOperantos);

		assertEquals("321+-+", CountingDown.combine(selectionNumbers, selectionOperantos));

	}

	@Test
	public final void testIfReturnAllPosiblesCombinations() {

		CountingDown countingDown = new CountingDown();
		String[] selection = new String[] { "3", "2", "1", "4", "6" };
		ArrayList<String> combinationNumbers = countingDown.getPermutationsOfNumberSelection(2,
				selection);

		// for(String combinationNum : combinationNumbers){
		// System.out.println(combinationNum);
		// }

		char[] alphabet = new char[] { '+', '*', '-', '/', '%' };

		ArrayList<String> combinations = new ArrayList<>();
		Combinations.possibleStrings(5, alphabet, "", combinations);

		// for(String combinationOperator : combinations){
		// System.out.println(combinationOperator);
		// }
		ArrayList<String> allPosilblesCOmbinations = CountingDown.getAllPosiblesCombinations(
				combinationNumbers, combinations);

		for (String allcombinations : allPosilblesCOmbinations) {
			System.out.println(allcombinations);
		}
		System.out.println("total " + allPosilblesCOmbinations.size());
	}

	@Test
	public final void testIfReturnResult() {

		CountingDown countingDown = new CountingDown();
		String[] selection1 = new String[] { "3", "2", "1", };
		ArrayList<String> combinationNumbers = countingDown.getPermutationsOfNumberSelection(2,
				selection1);

		for (String combinationNum : combinationNumbers) {
			System.out.println(combinationNum);
		}

		char[] alphabet = new char[] { '+', '-', };

		ArrayList<String> combinations = new ArrayList<>();
		Combinations.possibleStrings(2, alphabet, "", combinations);

		for (String combinationOperator : combinations) {
			System.out.println(combinationOperator);
		}
		ArrayList<String> allPosilblesCOmbinations = CountingDown.getAllPosiblesCombinations(
				combinationNumbers, combinations);

		
		 for (String allcombinations : allPosilblesCOmbinations) {
		 System.out.println(allcombinations); }
		 
		System.out.println("total " + allPosilblesCOmbinations.size() + "}");
		// System.out.println(CountingDown.doOperations(allPosilblesCOmbinations,
		// 4));

		assertEquals("321++", CountingDown.doOperations(allPosilblesCOmbinations, 6));
		assertEquals("321-+", CountingDown.doOperations(allPosilblesCOmbinations, 4));
	}

}

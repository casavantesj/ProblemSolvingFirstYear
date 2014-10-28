package edu.dcu.problemSolving.ticTacToe;

import static org.junit.Assert.*;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void test() {

	}

	@Test
	public void testIfAskTurn() {
		TicTacToe ticTacToe = new TicTacToe();
		assertEquals("x", ticTacToe.askTurn(1));
		assertEquals("y", ticTacToe.askTurn(2));
		assertEquals("no valid", ticTacToe.askTurn(0));
	}

	/*
	 * @Test public void getAPosition() { TicTacToe ticTacToe = new TicTacToe();
	 * // assertEquals(3, TicTacToe.possX);
	 * System.out.println("give position x"); TicTacToe.possX =
	 * ticTacToe.getAPosition(); System.out.println("give position x");
	 * TicTacToe.possY = ticTacToe.getAPosition();
	 * System.out.println("give position y");
	 * System.out.println("possition x is:" + TicTacToe.possX);
	 * System.out.println("possition y is:" + TicTacToe.possY); }
	 */

	@Test
	public void testIfisEmpty() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.table[0][0] = "X";
		ticTacToe.table[0][1] = null;
		ticTacToe.table[1][1] = "Y";
		// String[][] string = new String[3][3];
		//assertEquals(false, ticTacToe.isEmpty(0, 0));
		//assertEquals(true, ticTacToe.isEmpty(0, 1));
		//assertEquals(false, ticTacToe.isEmpty(1, 1));

	}
	
	

}

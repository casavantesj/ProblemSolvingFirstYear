package edu.dcu.problemSolving.ticTacToe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;

public class TicTacToeGameTest {

	@Test
	public void test() {

	}

	@Test
	public void testGetUserTurn() throws IOException {
		BufferedReader bufferedReader = org.mockito.Mockito
				.mock(BufferedReader.class);
		when(bufferedReader.readLine()).thenReturn("N").thenReturn("4")
				.thenReturn("2");
		TicTacToeGame game = new TicTacToeGame(bufferedReader);
		assertEquals("Y", game.getTurn());
	}

	@Test
	public void testGetANumber() throws IOException {

		BufferedReader bufferedReader = org.mockito.Mockito
				.mock(BufferedReader.class);
		when(bufferedReader.readLine()).thenReturn("8").thenReturn("0")
				.thenReturn("0");
		TicTacToeGame game = new TicTacToeGame(bufferedReader);
		assertEquals(0, game.getACoordinate());
	}

	@Test
	public void testIfEmpty() throws IOException {

		TicTacToeGame game = new TicTacToeGame();
		game.table[0][0] = "X";
		game.table[0][1] = null;
		game.table[0][2] = "Y";
		assertEquals(false, game.isEmpty(0, 0));
		assertEquals(true, game.isEmpty(0, 1));
		assertEquals(false, game.isEmpty(0, 2));
	}

	public void testIfColumnWin() throws IOException {

		TicTacToeGame game = new TicTacToeGame();

		// assertEquals(true, gameIsColumnWinner(column,turn));
	}

	public void testGetANumberByComputer() throws IOException {

		// Como testear un numero random;
		TicTacToeGame game = new TicTacToeGame();
		game.getACoordenateByComputer();
	
		//assertEquals(true, gameIsColumnWinner(column,turn));
	}
}

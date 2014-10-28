package edu.dcu.problemSolving.ticTacToe;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TicTcToeFinalTest {

	@Test
	public void testIfReturnPLayerPosition() {
		TicTcToeFinal ticTacToe = new TicTcToeFinal();

		assertEquals("X", ticTacToe.getTurn("X"));
		assertEquals("NO OPTION", ticTacToe.getTurn("Y"));
		assertEquals("O", ticTacToe.getTurn("O"));
	}

	@Test
	public void testIfScan() throws IOException {

		BufferedReader bufferedReader = org.mockito.Mockito
				.mock(BufferedReader.class);
		when(bufferedReader.readLine()).thenReturn("Y");

		TicTcToeFinal ticTacToe = new TicTcToeFinal(bufferedReader);
		assertEquals("Y", ticTacToe.scan());
	}
	
	@Test
	public void testIfDiagonalWinner() {
		TicTcToeFinal ticTacToe = new TicTcToeFinal();
		assertEquals(true, ticTacToe.isDiagonalWinner());
	}
	
	@Test
	public void testIfColumnWinner() {
		TicTcToeFinal ticTacToe = new TicTcToeFinal();
		assertEquals(true, ticTacToe.isColumWinner(2));
	}
	
	




}

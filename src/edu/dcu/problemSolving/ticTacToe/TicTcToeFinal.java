package edu.dcu.problemSolving.ticTacToe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTcToeFinal {
	BufferedReader bufferReader;
	String[][] table = new String[3][3];;

	public TicTcToeFinal() {
		bufferReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public TicTcToeFinal(BufferedReader bufferReader) {

		this.bufferReader = bufferReader;
	}

	//
	public String getTurn(String c) {
		// TODO Auto-generated method stub
		
		switch (c) {

		case "X":
		case "O":
			return c;
		default:
			return "NO OPTION";
		}

	}

	public String scan() {

		String turn = null;
		try {
			turn = bufferReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return turn;
	}

	public int askRandomPosition() {

		Random random = new Random();
		int integer = random.nextInt(3);

		return integer;
	}

	public void playGame() {
		System.out.println("Which position do you want to be: X or O");
		String stringScanTurn = scan();

		String turn = getTurn(stringScanTurn);

		System.out.println(turn);
		
		int pos = 0;

		
		do{
			// player game
		System.out.println("Give position X:");
		int posX = Integer.valueOf(scan());
		System.out.println("posX" + posX);
		System.out.println("Give position Y");
		int posY = Integer.valueOf(scan());
		System.out.println("posY" + posY);

		if (table[posX][posY] == null) {
			table[posX][posY] = turn;
		}

		if (isRowWinner(posX) || isColumWinner(posY) || isDiagonalWinner()) {
			System.out.println("Winer !!!" + turn);
		}

		print();
		pos++;
		}while(!isFull(pos));
		
	}

	public boolean isDiagonalWinner() {
		// TODO Auto-generated method stub
		return ((table[0][0] != null && table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[2][0] != null
				&& table[2][0] == table[1][1] && table[1][1] == table[0][2]));

	}

	public boolean isColumWinner(int posY) {
		// TODO Auto-generated method stub
		return (table[0][posY] != null && table[0][posY] == table[1][posY] && table[1][posY] == table[2][posY]);

	}

	public boolean isRowWinner(int posX) {// validate row full
		return (table[posX][0] != null && table[posX][0] == table[posX][1] && table[posX][1] == table[posX][2]);
	}

	public boolean isFull(int i) {// validate if the array is full
		return (i > 8);
	}

	public void print() {// print matrix
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("[" + table[i][j] + "]");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TicTcToeFinal ticTacToe = new TicTcToeFinal();
		ticTacToe.playGame();

	}

}

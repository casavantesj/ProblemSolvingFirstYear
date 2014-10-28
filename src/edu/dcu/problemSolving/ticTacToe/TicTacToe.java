package edu.dcu.problemSolving.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static int possX;
	public static int possY;
	String[][] table = new String[3][3];

	public String askTurn(int turn) {

		if (turn == 1) {
			return "x";
		}
		if (turn == 2) {
			return "y";
		}
		return "no valid";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe ticTacToe = new TicTacToe();
		Scanner scan = new Scanner(System.in);
		String turn;
		boolean checker;
		int positionX;
		int positionY;
		int positions = 0;
		boolean winner = false;

		do {
			do {

				System.out.println("Do you want to be first  or second?");
				int i = scan.nextInt();
				turn = ticTacToe.askTurn(i);
				System.out.println("turn " + turn);
				if (turn == "no valid") {
					System.out.println("turn " + turn);
					System.out.println("do again, just valid x or y");

				}
			} while (turn == "no valid");

			// check the turn
			if (turn == "x") {

				do {
					positionX = ticTacToe.getAPositionbyUser();
					positionY = ticTacToe.getAPositionbyUser();
					// verify if position is empty

					if (ticTacToe.isPositionEmpty(positionX, positionY)) {
						ticTacToe.table[positionX][positionY] = turn;
						positions++;
						if (ticTacToe.isRawWinner(positionX)
								|| ticTacToe.isColumnWinner(positionY)
								|| ticTacToe.isDiagonaWinner()) {
							System.out.println("the winner is x");
							winner = true;
						}
						checker = true;
					} else {
						System.out
								.println("the possition is not empty, choose another one:");
						checker = false;
					}
				} while (checker != true);

				// Choose turn by computer.
				do {
					positionX = ticTacToe.getAPositionbyProgram();
					System.out.println("positionX by program: " + positionX);

					positionY = ticTacToe.getAPositionbyProgram();
					System.out.println("positionY by program: " + positionY);

					if (ticTacToe.isPositionEmpty(positionX, positionY)) {
						ticTacToe.table[positionX][positionY] = turn;
						positions++;
						checker = true;
						if (ticTacToe.isRawWinner(positionX)
								|| ticTacToe.isColumnWinner(positionY)
								|| ticTacToe.isDiagonaWinner()) {
							System.out.println("the winner is y");
							winner = true;
						}
					} else {
						System.out
								.println("the possition is not empty, choose another one:");
						checker = false;
					}
				} while (checker != true);

			}
		} while (!ticTacToe.isFull(positions) && !winner);

		/*
		 * int positionX = ticTacToe.getAPosition(); int positionY =
		 * ticTacToe.getAPosition();
		 * 
		 * if (ticTacToe.isPositionEmpty(positionX, positionY)) {
		 * ticTacToe.table[positionX][positionX] = "x"; }
		 */

	}

	// return the number of a position;
	public int getAPositionbyUser() {
		int possition;
		Scanner scan;
		scan = new Scanner(System.in);
		System.out.println("get possition");
		return possition = scan.nextInt();

	}

	public int getAPositionbyProgram() {

		Random random = new Random();

		return random.nextInt(2);

	}

	public boolean isPositionEmpty(int x, int y) {
		if (table[x][y] == "X" || table[x][y] == "O") {
			return false;
		}
		return true;
	}

	public boolean isRawWinner(int x) {

		// validate row full
		return (table[x][0] != null && table[x][0] == table[x][1] && table[x][1] == table[x][2]);

	}

	public boolean isColumnWinner(int x) {

		return (table[x][0] != null && table[x][0] == table[x][1] && table[x][1] == table[x][2]);

	}

	public boolean isDiagonaWinner() {
		return ((table[0][0] != null && table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[2][0] != null
				&& table[2][0] == table[1][1] && table[1][1] == table[0][2]));
	}

	public boolean isFull(int i) {// validate if the array is full
		return (i > 8);
	}

	

}
/**/


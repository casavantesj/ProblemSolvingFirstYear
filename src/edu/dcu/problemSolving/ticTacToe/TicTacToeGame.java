package edu.dcu.problemSolving.ticTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTacToeGame {
	BufferedReader scan;
	String[][] table = new String[3][3];
	int possY;
	int possX;

	public TicTacToeGame() {
		scan = new BufferedReader(new InputStreamReader(System.in));
	}

	public TicTacToeGame(BufferedReader bufferedReader) {
		scan = bufferedReader;
	}

	public String getTurn() throws IOException {
		String turn;
		boolean isTurnValid;

		do {
			System.out.println("Which turn do you want: ");
			turn = scan.readLine();
			System.out.println("you entered " + turn);
			switch (turn) {
			case "1":
				turn = "X";
				// ask coordinates by user
				// ask coordinates by computer
				isTurnValid = true;
				break;
			case "2":

				turn = "Y";
				isTurnValid = true;
				break;
			default:
				System.out.println("Turn no valid do it again");
				isTurnValid = false;
				break;
			}
		} while (!isTurnValid);
		return turn;
	}

	public int getACoordinate() throws NumberFormatException, IOException {

		int coordinate;
		boolean isValidNumber = false;

		do {
			System.out.println("Enter a coordenate: ");
			coordinate = Integer.valueOf(scan.readLine());
			System.out.println("coordinate" + coordinate);
			if (coordinate == 0 || coordinate == 1 || coordinate == 2) {
				isValidNumber = true;
			} else {
				System.out.println("turn not valid");
			}

		} while (!isValidNumber);
		return coordinate;
	}

	public int getACoordenateByComputer() {
		Random random = new Random();

		return random.nextInt(2);

	}

	// play
	public void Userplay(String turn) throws NumberFormatException, IOException {

		int count = 0;
		boolean isWinner = false;
		do {
			int x = getACoordinate();
			int y = getACoordinate();

			if (isEmpty(x, y)) {
				table[x][y] = turn;
				count++;
			}

			if (isRowWinner(x) || isColumWinner(y) || isDiagonalWinner(x, y)) {
				System.out.println("Winer !!!" + turn);
				isWinner = true;
			} else {
				System.out.println("is winner false");
				isWinner = false;
			}

		} while (!isWinner && !isFull(count));

	}

	public void print() {
		
		System.out.println(table.length);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				System.out.print("[" + table[i][j] + "]");

			}
			System.out.print("\n");
		}

	}

	public boolean isEmpty(int x, int y) {
		if (table[x][y] == "X" || table[x][y] == "Y") {
			return false;
		}
		return true;
	}

	public boolean isColumWinner(int column) {// validate colum full
		return (table[0][column] != null
				&& table[0][column] == table[1][column] && table[1][column] == table[2][column]);
	}

	public boolean isDiagonalWinner(int x, int y) {// validate diagonal full
		return ((table[0][0] != null && table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[2][0] != null
				&& table[2][0] == table[1][1] && table[1][1] == table[0][2]));
	}

	public boolean isRowWinner(int row) {// validate row full
		return (table[row][0] != null && table[row][0] == table[row][1] && table[row][1] == table[row][2]);
	}

	public static void main(String[] args) throws IOException {
		TicTacToeGame game = new TicTacToeGame();
		String turn = game.getTurn();
		game.Userplay(turn);
		game.print();
	}

	public boolean isFull(int i) {// validate if the array is full
		return (i > 8);
	}

}

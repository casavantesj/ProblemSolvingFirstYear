package edu.dcu.problemSolving.nightTours;

import java.util.ArrayList;
import java.util.Arrays;

public class NightTour {

	final int tableSize = 6;
	int matrixSize = (tableSize * tableSize) + 1;
	int[][] table = new int[7][7];
	int[][] matrix = new int[matrixSize][matrixSize];
	ArrayList<Integer> positions = new ArrayList<Integer>();

	public void tableInicialization() {

		int position = 1;

		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table.length - 1; j++) {

				table[i][j] = position;
				position++;
			}
		}

	}

	public void printTable() {

		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table.length - 1; j++) {

				System.out.print("[" + table[i][j] + "]");

			}

			System.out.println("\n");
		}
	}

	public int getPositionSouthEast(int i) {
		return !isLastColumn(i) && !isLastRow(i) && !isPenultimateRow(i) ? i + (tableSize * 2) + 1
				: 0;
	}

	public int getPositionSouthWest(int i) {
		return !isLastRow(i) && !isPenultimateRow(i) && !isFirstColumn(i) ? i + (tableSize * 2) - 1 : 0;
	}

	public int getPositionNorthEast(int i) {
		return !isFirstRow(i) && !isSecondRow(i) && !isLastColumn(i) ? i - ((tableSize * 2) - 1) : 0;
	}

	public int getPositionNorthWest(int i) {
		return !isFirstRow(i) && !isSecondRow(i) && !isFirstColumn(i) ? i - ((tableSize * 2) + 1) : 0;
	}

	public int getPositionWestNorth(int i) {

		return !isFirstRow(i) && !isFirstColumn(i) && !isSecondColumn(i) ? (i - 2) - tableSize : 0;
	}

	public int getPositionWestSouth(int i) {

		return !isFirstColumn(i) && !isSecondColumn(i) && !isLastRow(i) ? (i - 2) + tableSize : 0;

	}

	public int getPositionEastSouth(int i) {

		return !isLastColumn(i) && !isPenultimateColumn(i) && !isLastRow(i) ? (i + 2) + tableSize
				: 0;

	}

	public int getPositionEastNorth(int i) {

		return !isLastColumn(i) && !isPenultimateColumn(i) && !isFirstRow(i) ? (i + 2) - tableSize
				: 0;

	}

	public boolean isLastColumn(int i) {

		return (i % tableSize == 0);

	}

	public boolean isFirstColumn(int i) {

		return ((i - 1) % tableSize == 0);

	}

	public boolean isSecondColumn(int i) {

		return ((i - 2) % tableSize == 0);

	}

	public boolean isPenultimateColumn(int i) {

		return ((i + 1) % tableSize == 0);

	}

	public boolean isPenultimateRow(int i) {

		return i > (tableSize * tableSize) - (tableSize * 2);

	}
	
	public boolean isSecondRow(int i) {

		return i <= (tableSize * 2);

	}

	public boolean isLastRow(int i) {

		return i > (tableSize * tableSize) - tableSize;

	}

	public boolean isFirstRow(int i) {

		return i <= tableSize;
	}

	public void matrixCreator() {

		for (int posX = 0; posX < matrixSize; posX++) {
			int posNE = getPositionNorthEast(posX);
			int posNW = getPositionNorthWest(posX);
			int posSE = getPositionSouthEast(posX);
			int posSW = getPositionSouthWest(posX);
			int posWS = getPositionWestSouth(posX);
			int posWN = getPositionWestNorth(posX);
			int posES = getPositionEastSouth(posX);
			int posEN = getPositionEastNorth(posX);

			if (posNE > 0)
				matrix[posX][posNE] = 1;
			if (posNW > 0)
				matrix[posX][posNW] = 1;
			if (posSE > 0)
				matrix[posX][posSE] = 1;
			if (posSW > 0)
				matrix[posX][posSW] = 1;
			if (posWS > 0)
				matrix[posX][posWS] = 1;
			if (posWN > 0)
				matrix[posX][posWN] = 1;
			if (posES > 0)
				matrix[posX][posES] = 1;
			if (posEN > 0)
				matrix[posX][posEN] = 1;

			// for (int posY = 0; posY < 65; posY++) {
			//
			// if (getPositionNorthEast(posX) == posY
			// || == posY
			// || getPositionSouthEast(posX) == posY
			// || getPositionSouthWest(posX) == posY) {
			//
			// matrix[posX][posY] = 1;
			// } else {
			// matrix[posX][posY] = 0;
			// }
			// }
		}

	}

	public void printMatrix() {
		for (int i = 1; i < matrixSize; i++) {
			System.out.print("|" + i + "|");
			for (int j = 1; j < matrixSize; j++) {
				System.out.print("[" + matrix[i][j] + "]");
			}

			System.out.print("\n");
		}

	}

	public boolean findPosition(ArrayList<Integer> positions, int currentPosistion) {
		if (currentPosistion == 0)
			return false;

		@SuppressWarnings("unchecked")
		ArrayList<Integer> listPositions = (ArrayList<Integer>) positions.clone();
		if (listPositions.contains(currentPosistion))
			return false;

		listPositions.add(currentPosistion);
		if (isFull(listPositions)) {
			System.out.println(listPositions.toString());
			return true;
		}
		return findPosition(listPositions, getPositionEastNorth(currentPosistion))
				|| findPosition(listPositions, getPositionEastSouth(currentPosistion))
				|| findPosition(listPositions, getPositionWestSouth(currentPosistion))
				|| findPosition(listPositions, getPositionWestNorth(currentPosistion))
				|| findPosition(listPositions, getPositionSouthWest(currentPosistion))
				|| findPosition(listPositions, getPositionSouthEast(currentPosistion))
				|| findPosition(listPositions, getPositionNorthEast(currentPosistion))
				|| findPosition(listPositions, getPositionNorthWest(currentPosistion));

		// if posNE is Occupied

		// check if NW is Occupied

		// check od SE is Occupied

		// else
		// add position to the list
		// currentPosition == position

	}

	public boolean isOccupied(ArrayList<Integer> positions, int position) {

		if (positions.contains(position)) {

			return true;
			// find another position
		}
		// add position to the list

		return false;
	}

	public boolean isFull(ArrayList<Integer> positions) {

		return (positions.size() == 36);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NightTour game = new NightTour();
		//game.matrixCreator();
		//game.printMatrix();
		
	//	game.findPosition(new ArrayList<Integer>(), 30);

		// game.tableInicialization();
		// game.printTable();
	}

}

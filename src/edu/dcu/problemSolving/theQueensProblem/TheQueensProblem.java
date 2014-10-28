package edu.dcu.problemSolving.theQueensProblem;

public class TheQueensProblem {

	int[] position = new int[8];
	int[] verticalPosition = new int[8];
	int[] diagonalIzquierda = new int[16];
	int[] diagonalDerecha = new int[16];

	public void solveProblem() {
		for (int x = 0; x < position.length - 1; x++) {
			for (int y = 0; y < position.length; y++) {

				if ((position[x] == 0) && (verticalPosition[y] == 0)
						&& (diagonalIzquierda[x + y] == 0)
						&& (diagonalDerecha[8 + (x - y)] == 0)) {
					position[x] = y;
					verticalPosition[y] = 1;
					diagonalIzquierda[x + y] = 1;
					diagonalDerecha[8 + (x - y)] = 1;

					// System.out.println(position[x] = y);
					// System.out.println(verticalPosition[y] = 1);
					// System.out.println(diagonalIzquierda[x + y] = 1);
					// System.out.println(diagonalDerecha[8+(x - y)] = 1);
				}

			}
			if (position[x] == 0) {
				position[x - 1] = 0;
				for (int y = position[x + 1]; y < position.length; y++) {

					if ((position[x] == 0) && (verticalPosition[y] == 0)
							&& (diagonalIzquierda[x + y] == 0)
							&& (diagonalDerecha[8 + (x - y)] == 0)) {
						position[x] = y;
						verticalPosition[y] = 1;
						diagonalIzquierda[x + y] = 1;
						diagonalDerecha[8 + (x - y)] = 1;

						// System.out.println(position[x] = y);
						// System.out.println(verticalPosition[y] = 1);
						// System.out.println(diagonalIzquierda[x + y] = 1);
						// System.out.println(diagonalDerecha[8+(x - y)] = 1);
					}

				}

			}

		}

		for (int posx = 0; posx < 8; posx++) {

			System.out.println(position[posx]);
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TheQueensProblem theQueensProblem = new TheQueensProblem();
		theQueensProblem.solveProblem();

	}
}

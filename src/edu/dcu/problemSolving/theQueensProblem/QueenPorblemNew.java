package edu.dcu.problemSolving.theQueensProblem;
import java.util.Scanner;

public class QueenPorblemNew {
	static int solutionCount = 0;
	
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		
		int n; // Number of Queens and size of chessboard (n x n).
		int[] positions; // Column that each Queen is in. The index is the row of the Queen.
		int currentRow; // Current row we are working on in the backtracking while loop.
		
		n = scan.nextInt();
		
		positions = new int[n];
		
		for(int i = 0; i < n; i ++)
			positions[i] = -1;
		
		currentRow = 0;
		while(true){
			positions[currentRow] ++;
			
			if(positions[currentRow] >= n){
				if(currentRow == 0)
					break;
				
				positions[currentRow] = -1;
				currentRow --;
			}
			else{
				if(validPositions(n, currentRow, positions)){
					if(currentRow == n - 1)
						printSolution(n, positions);
					else
						currentRow ++;
				}
				else{
					if(positions[currentRow] == n - 1){
						positions[currentRow] = -1;
						currentRow --;
					}
				}
			}
		}
	}
	
	public static boolean validPositions(int n, int currentRow, int[] positions){
		for(int i = 0; i <= currentRow - 1; i ++){
			for(int j = i + 1; j <= currentRow; j ++){
				// Check if the Queens are in the same column.
				if(positions[i] == positions[j])
					return false;
				
				// Check if the Queens are in the same "/" diagonal.
				if(positions[i] + i == positions[j] + j)
					return false;
				
				// Check if the Queens are in the same "\" diagonal.
				if(positions[i] - i == positions[j] - j)
					return false;
			}
		}
		
		return true;
	}
	
	public static void printSolution(int n, int[] positions){
		solutionCount ++;
		
		System.out.printf("Solution %d: ", solutionCount);
		
		for(int i = 0; i < n; i ++)
			System.out.printf("%d ", positions[i]);
		System.out.printf("\n");
		
		for(int i = 0; i < n; i ++){
			// Printing horizontal border.
			for(int j = 0; j < 2 * n; j ++)
				System.out.printf("-");
			System.out.printf("\n");
			
			// Printing row.
			for(int j = 0; j < positions[i]; j ++)
				System.out.printf("| ");
			System.out.printf("|Q");
			for(int j = positions[i] + 1; j < n; j ++)
				System.out.printf("| ");
			System.out.printf("|\n");
		}
		
		// Printing horizontal border.
		for(int j = 0; j < 2 * n; j ++)
			System.out.printf("-");
		System.out.printf("\n\n\n");
	}
}

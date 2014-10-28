package edu.dcu.problemSolving.Cipher;

import java.io.File;
import java.io.FileReader;

public class Cipher {
	static final int NUM_LETTERS = 26;
	static final int FREQ_TABLE_LETTER = 1;
	static final int FREQ_TABLE_COUNT = 0;
	
	static final String englishPath = "C:\\Users\\Jennifer\\Desktop\\CipherProblem\\english.txt";
	static final String cipherPath = "C:\\Users\\Jennifer\\Desktop\\CipherProblem\\cipher.txt";
	
	static File englishTextFile;
	static File cipherTextFile;
	
	static char[] englishText;
	static char[] cipherText;
	
	static int[][] englishFreqTable;
	static int[][] cipherFreqTable;
	
	public static void main(String[] args) {
		// Read English text.
		englishTextFile = new File(englishPath);
		try{
			FileReader fr = new FileReader(englishTextFile);
			fr.read(englishText);
			fr.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		// Read Cipher text.
		cipherTextFile = new File(cipherPath);
		try{
			FileReader fr = new FileReader(cipherTextFile);
			fr.read(cipherText);
			fr.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// DEBUG: Print englishText.
		System.out.printf("Your English text is:\n");
		for(char c: englishText){
			System.out.printf("%c", c);
		}
		System.out.printf("\n");
		
		// DEBUG: Print cipherText.
		System.out.printf("Your Cipher text is:\n");
		for(char c: englishText){
			System.out.printf("%c", c);
		}
		System.out.printf("\n");
		
		// Initialize freqTables.
		englishFreqTable = new int[NUM_LETTERS][2];
		cipherFreqTable = new int[NUM_LETTERS][2];
		
		for(int i = 0; i < NUM_LETTERS; i ++)
			englishFreqTable[i][FREQ_TABLE_COUNT] = cipherFreqTable[i][FREQ_TABLE_COUNT] = 0;
		
		for(int i = 0; i < NUM_LETTERS; i ++)
			englishFreqTable[i][FREQ_TABLE_LETTER] = cipherFreqTable[i][FREQ_TABLE_LETTER] = i;
		
		// Generate englishFreqTable.
		for(char c: englishText){
			c = Character.toLowerCase(c);
			if(c <= 'z' && c >= 'a') // If c is a letter.
				englishFreqTable[(int)(c - 'a')][FREQ_TABLE_COUNT] ++;
		}
		
		// Generate cipherFreqTable.
		for(char c: cipherText){
			c = Character.toLowerCase(c);
			if(c <= 'z' && c >= 'a') // If c is a letter.
				cipherFreqTable[(int)(c - 'a')][FREQ_TABLE_COUNT] ++;
		}
		
		// Sort freqTables.
		englishFreqTable = sort(englishFreqTable);
		cipherFreqTable = sort(cipherFreqTable);
		
		for(int i = 0; i < NUM_LETTERS; i ++){
			for(int j = 0; j < cipherText.length; j ++){
				// Check if it is a letter.
				int characterCode = (int)Character.toLowerCase(cipherText[j]);
				if(characterCode <= 'z' && characterCode >= 'a'){
					// Check if it is the letter we are currently processing in the (for int i = 0) loop.
					if(characterCode - (int)'a' == cipherFreqTable[i][FREQ_TABLE_LETTER]){
						// Replace with capital or small corresponding englishFreqTable letter.
						if(Character.isUpperCase(cipherText[j]))
							cipherText[j] = (char)(englishFreqTable[i][FREQ_TABLE_LETTER] + 'A');
						else
							cipherText[j] = (char)(englishFreqTable[i][FREQ_TABLE_LETTER] + 'a');
					}
				}
			}
		}
	}

	public static int[][] sort(int[][] m){ // Insertion sort.
		for(int i = 1; i < NUM_LETTERS; i ++){
			while(m[i][FREQ_TABLE_COUNT] < m[i - 1][FREQ_TABLE_COUNT]){ // Keep swapping until in correct position.
				int temp0 = m[i][FREQ_TABLE_COUNT];
				int temp1 = m[i][FREQ_TABLE_LETTER];
				
				m[i][FREQ_TABLE_COUNT] = m[i - 1][FREQ_TABLE_COUNT];
				m[i][FREQ_TABLE_LETTER] = m[i - 1][FREQ_TABLE_LETTER];
				
				m[i - 1][FREQ_TABLE_COUNT] = temp0;
				m[i - 1][FREQ_TABLE_LETTER] = temp1;
				
				i --;
				if(i == 0)
					break;
			}
		}
		
		return m;
	}
}

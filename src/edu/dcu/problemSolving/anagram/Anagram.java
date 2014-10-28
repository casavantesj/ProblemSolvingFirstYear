package edu.dcu.problemSolving.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.dcu.problemSolving.tokenizer.Tokenizer;

public class Anagram {

	public String readUrl(String urlName) {
		// TODO Auto-generated method stub'
		StringBuilder response = null;
		try {
			URL url = new URL(urlName);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader in = new BufferedReader(new InputStreamReader(is));

			response = new StringBuilder();
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				response.append(inputLine).append("\n");

			in.close();

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response.toString();

	}

	public String getAWord() {

		System.out.println("enter a word: ");

		Scanner scan = new Scanner(System.in);

		String line = scan.nextLine();

		return line;
	}

	public ArrayList<String> generateArrayOfStrings(String longString) {
		longString += "\n";
		char[] charString = longString.toCharArray();
		String temp = "";
		ArrayList<String> wordArray = new ArrayList<String>();

		for (int i = 0; i < charString.length; i++) {

			if (charString[i] != '\n') {

				temp += charString[i];

			} else {
				wordArray.add(temp.toString());
				temp = "";
			}
		}
		return wordArray;

	}

	public ArrayList<String> getTheAnagrams(String word, String longString) {

		ArrayList<String> allPosiblesAnagrams = new ArrayList<String>();

		ArrayList<String> anagramWords = generateArrayOfStrings(longString);

		for (int i = 0; i < anagramWords.size(); i++) {

			if (isAnagram(word, anagramWords.get(i))) {

				allPosiblesAnagrams.add(anagramWords.get(i));
			}
		}

		return allPosiblesAnagrams;

	}

	public boolean isAnagram(String word, String anagramWord) {

		if (word.length() == anagramWord.length()) {

			char[] wordChar = word.toLowerCase().toCharArray();

			char[] anagramWordChar = anagramWord.toLowerCase().toCharArray();

			Arrays.sort(anagramWordChar);

			Arrays.sort(wordChar);

			if (Arrays.equals(wordChar, anagramWordChar)) {

				return true;
			}

		}

		return false;
	}

	public void print(ArrayList<String> allAnagrams) {

		for (int i = 0; i < allAnagrams.size(); i++) {

			System.out.println(allAnagrams.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Anagram anagram = new Anagram();

		// System.out.println(anagram.isAnagram("roma", "hola"));

		String longString = anagram

		.readUrl("http://www.computing.dcu.ie/~john/dict.txt");

		String word = anagram.getAWord();

		System.out.println("the word is: " + word);
		ArrayList<String> allAnagrams = anagram
				.getTheAnagrams(word, longString);

		anagram.print(allAnagrams);
	}
}

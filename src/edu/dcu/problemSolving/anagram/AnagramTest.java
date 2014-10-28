package edu.dcu.problemSolving.anagram;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import edu.dcu.problemSolving.ticTacToe.TicTacToeGame;

public class AnagramTest {

	/*
	 * @Test public void testIfReadFile() { Anagram anagram = new Anagram();
	 * System.out.println(anagram
	 * .readUrl("http://www.computing.dcu.ie/~john/dict.txt")); }
	 */

	/*
	 * @Test public void testIfAcceptAWord() throws IOException { BufferedReader
	 * bufferedReader = org.mockito.Mockito .mock(BufferedReader.class);
	 * when(bufferedReader.readLine()).thenReturn("f"); Anagram anagram = new
	 * Anagram(); assertEquals("Hola", anagram.getAWord());
	 * 
	 * 
	 * 
	 * }
	 */

	@Test
	public void testIfAcceptAWord() {

		Anagram anagram = new Anagram();
		String longString = "hola hola hola carretenero";

		ArrayList<String> arraywords = new ArrayList<String>();
		arraywords.add("hola");
		arraywords.add("hola");
		arraywords.add("hola");
		arraywords.add("carretenero");

		assertEquals(arraywords, anagram.generateArrayOfStrings(longString));

	}

	@Test
	public void testIfIsAnagram() {

		Anagram anagram = new Anagram();

		assertEquals(true, anagram.isAnagram("hello", "hello"));

	}

	@Test
	public void testIfGetAllPosiblesAnagrams() {

		Anagram anagram = new Anagram();
		String longString = anagram
				.readUrl("http://www.computing.dcu.ie/~john/dict.txt");
		String word = "hello";

		assertEquals(" ", anagram.getTheAnagrams(word, longString));

	}
}

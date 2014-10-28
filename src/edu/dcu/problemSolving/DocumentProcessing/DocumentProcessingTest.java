package edu.dcu.problemSolving.DocumentProcessing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DocumentProcessingTest {

	@Test
	public void test() {
		DocumentProcessing documentProcessing = new DocumentProcessing();
		String[] s = "Hello, 33333\n		';';cat,,,	 ".replaceAll("[^a-zA-Z0-9]+", " ")
				.trim().split(" ");

		System.out.println(s);

		for (String string : s) {
			System.out.println(string);
		}

		// assertEquals(["Hello", "my", "cat"],
		// documentProcessing.readDocument(documentProcessingFile));

	}

}

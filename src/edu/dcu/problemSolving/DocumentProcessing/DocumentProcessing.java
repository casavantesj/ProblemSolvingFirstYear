package edu.dcu.problemSolving.DocumentProcessing;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentProcessing {
	static final int N = 10;
	static final int MAX_CHARACTERS_IN_DOCUMENT = 1000000;

	public static String[] readDocument(File documentProcessingFile) {
		char[] documentText = new char[MAX_CHARACTERS_IN_DOCUMENT];

		try {
			FileReader fr = new FileReader(documentProcessingFile);

			fr.read(documentText);

			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new String(documentText).replaceAll("[^a-zA-Z0-9]+", " ").trim()
				.split(" ");
	}

	public static File[] findTextFiles(String pathCurrentDirectory) {
		File f = new File(pathCurrentDirectory);

		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		};

		return f.listFiles(textFilter);

	}

	public static String[] getKeywords() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> keywords = new ArrayList<String>();

		while (scan.hasNext()) {
			keywords.add(scan.next());
		}

		String[] s = new String[keywords.size()];

		int i = 0;
		for (String k : keywords) {
			s[i] = k;
			i++;
		}

		return s;
	}

	public static void main(String[] args) {
		int count = 0;
		String[] keywords = getKeywords();
		int[] numKeywords = new int[N];

		File[] documents = findTextFiles(System.getProperty("user.dir"));

		for (File f : documents) {
			// System.out.println("We are here 2");

			for (String k : keywords) {
				// System.out.println("We are here 3");
				for (String t : readDocument(f)) {
					if (k.equals(t)) {
						numKeywords[count]++;
					}
				}
			}
			count++;
			if (count >= N) {
				break;
			}
		}

		// Sort keywords and documents.

		//

		for (int i = 0; i < count; i++) {
			System.out.println(documents[i]);
			// text 1 has keywords.
		}

	}
}

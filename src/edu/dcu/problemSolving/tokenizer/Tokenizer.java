package edu.dcu.problemSolving.tokenizer;

import java.util.Vector;

public class Tokenizer {

	public static void createdArray(String string) {
		String word = string + " ";
		char[] strArray = word.toCharArray();
		Vector<String> vectorStrings = new Vector<String>();
		String temp = "";
		int counter = 1;

		for (int i = 0; i < strArray.length; i++) {

			if (strArray[i] != ' ' || i == strArray.length + 1) {

				temp += strArray[i];

			} else {
				temp.toString();
				vectorStrings.add(temp);
				temp = "";
			}

		}

		for (int i = 0; i < vectorStrings.size(); i++) {
			 if( vectorStrings.get(i) != null){
				 
			
			for (int j = i + 1; j < vectorStrings.size() - 1; j++) {

				
						if( vectorStrings.get(j) != null) {

					if (vectorStrings.get(i).equals(vectorStrings.get(j))) {

						// System.out.println(vectorStrings.get(i), counter ++);
						// temporal = vectorStrings.get(i);
						vectorStrings.set(j, null);
						counter++;
						// System.out.println(vectorStrings.get(i) + counter);
						// System.out.println(temporal);

					}

				}

			}

			System.out.println(vectorStrings.get(i) + counter);
			counter = 1;

			 }}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tokenizer.createdArray("hola hola hola mola mola mola carabola");

	}

}

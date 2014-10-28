package edu.dcu.problemSolving.searching;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Serching {

	public static int findPosition(int number, ArrayList<Integer> array) {
		double startTime = System.nanoTime() / 1000;
		int position = -1;
		for (int i = 0; i < array.size(); i++) {

			if (array.get(i).equals(number)) {
				position = array.indexOf(number);
				return position;
			}

		}
		double endTime = System.nanoTime() / 1000;
		System.out.println("time: " + (endTime - startTime));
		return position;

	}

	public static boolean has(int number, ArrayList<Integer> array) {
		
		for (int i = 0; i < array.size(); i++) {

			if (array.get(i).equals(number)) {

				return true;
			}

		}
		return false;

	}

	
	public void sorting(int number, ArrayList<Integer> array){
		int temp;
		for (int i = 0; i < array.size(); i++){
			
			if(array.get(i) >= array.get(i)){
				
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		System.out.println(Serching.findPosition(6, array));

	}

}

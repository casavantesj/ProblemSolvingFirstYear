package edu.dcu.problemSolving.Primes;

public class Prime {

	public static boolean isPrimeNumbers(int number) {

		for (int i = 1; i < number - 1; i++) {

			int rem = number % (number - i);

			if (rem == 0) {
				return false;
			}
		}
		return true;

	}
	
	public static void printPrimeNumbers(int number){
		
		for(int i = 2; i < number; i++){
			
			if(isPrimeNumbers(i)){
				System.out.println(i);
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(Prime.isPrimeNumbers(3));
		Prime.printPrimeNumbers(10);

	}

}

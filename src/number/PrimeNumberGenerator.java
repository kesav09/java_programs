package number;

import java.util.Arrays;

//generate prime numbers upto a limit
/*
1. take boolean array 1-1000
2. mark arr [0] = false; 
3. mark all the rest numbers as true
4. mark all the mutiples of 2 to false, similarly for all the numbers 3, 4, 5
5. then print true and that's the prime number 

 */

public class PrimeNumberGenerator {
	
	public static void main(String[] args) {
		generatePrimeNumbers(1000);
	}
	
	public static void generatePrimeNumbers(int n) {
		boolean [] prime = new boolean[n];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i < prime.length; i++){
			if (prime[i]){// if the number is prime then mark all it's multiple as false
				System.out.print(i+",");
				for (int j = 2; i * j < prime.length; j++){
					prime[i*j] = false;
				}
			}
		}
	}
}
	
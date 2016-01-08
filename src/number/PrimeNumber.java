	package number;

public class PrimeNumber {

	public static void main(String [] args) {
			System.out.print(isPrime(17));
	}
	
	public static boolean isPrime(int num){
		if(num == 0 || num == 1) return false;
		if (num % 2 == 0) return false;
		
		for (int i = 3; i*i <=num; i++){
			if((num % i) == 0) return false;
		}
		return true;
	}
}
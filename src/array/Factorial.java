package array;

public class Factorial{
	public static void main(String[] args){
		int number = 5;
		System.out.println(factorial(number));
		System.out.println(iterativeFactorial(number));
	}
	
	public static int factorial(int number){
	
		if(number == 1 || number <= 0){
			return 1;
		}
		
		return number * factorial(number - 1);
	}
	
	public static int iterativeFactorial(int number){
		if(number <= 0 || number == 1){
			return 1;
		}
		
		int product = 1;
		for(int i=number ; i>1 ; --i){
			product*=i;
		}
		
		return product;
	}
}
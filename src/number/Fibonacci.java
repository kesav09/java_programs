package number;


public class Fibonacci {

	static int n = 5;
	
	public static void main(String [] args){
//		for(int i = 0; i < n; i++)
//			System.out.println(generateFib(i));
		generateFibIterative(10);
	}
	
	//recursive
	private static int generateFib(int n){
		if(n == 0)
			return 0;
		
		if (n == 1) 
			return 1;
		return generateFib(n-2) + generateFib(n-1);
	}
	
	//iterative
	// 0 1 1 2 3 5 8
	private static void generateFibIterative(int limit){
        int[] feb = new int[limit];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < limit; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }

        for(int i=0; i< limit; i++){
        	System.out.print(feb[i] + " ");
        }
	}
}

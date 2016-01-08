package array;

public class Fibonacci {

	static int n = 5;

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++)
			System.out.println(generateFib(i));
		generateFibIterative(5);
		iterativefibonacci(5);
		int[] num = iterativeFibonacci(5);
		System.out.println();
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + " ");
		}
	}

	// recursive
	private static int generateFib(int n) {
		if (n == 0)
			return 0;

		if (n == 1)
			return 1;
		return generateFib(n - 1) + generateFib(n - 2);
	}

	// iterative
	// 0 1 1 2 3 5 8
	private static void generateFibIterative(int limit) {
		int[] feb = new int[limit];
		feb[0] = 0;
		feb[1] = 1;
		for (int i = 2; i < limit; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		for (int i = 0; i < limit; i++) {
			System.out.print(feb[i] + " ");
		}
	}

	public static int iterativefibonacci(int n) {
		int prev = 0;
		int sum = 0;
		int prevsum = 1;
		System.out.println();
		System.out.print("0 1 ");
		for (int i = 0; i < n - 2; i++) {
			sum = prev + prevsum;
			prev = prevsum;
			prevsum = sum;
			System.out.print(sum + " ");
		}
		return sum;
	}

	public static int[] iterativeFibonacci(int n) {
		int[] num = new int[n];
		num[0] = 0;
		num[1] = 1;
		for (int i = 2; i < n; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		return num;
	}
}

package number;

public class Factors {

	public static void getFactors(int num) {
		System.out.println();
		// consider negative number
		if (num < 0) {
			num = -num;
		}

		while (num % 2 == 0) {
			System.out.print("2 ");
			num = num/2;
		}

		for (int i = 3; i * i < num; i = i + 2) {
			while (num % i == 0) {
				System.out.print(i + " ");
				num = num / i;
			}
		}

		// if not a prime number
		if (num > 2) {
			System.out.print(num);
		}
	}

	public static void main(String[] args) {

		getFactors(12);
		getFactors(15);
		getFactors(27);
		getFactors(19);
	}
}
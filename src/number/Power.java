package number;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(pow(-2, 2));
		// System.out.println(efficientPowerAlgorithm(2, 3));
		/*System.out.println(powe(2, 3));
		System.out.println(powerOld(2, -3));*/
		
		System.out.println(power(2, -6));
	}

	public static double pow(double base, int power) {

		if (base == 0)
			return 0;
		if (power == 0)
			return 1;

		if (power == 1)
			return base;
		if (power == -1)
			return (1 / base);

		double value = 1;
		int powerVal = Math.abs(power);
		while (powerVal > 0) {
			value *= base;
			powerVal--;
		}
		return (power > 0) ? value : 1 / value;
	}

	// efficient algorithm
	public static double efficientPowerAlgorithm(double base, int power) {
		if (base == 0)
			return 0;
		if (power == 0)
			return 1;
		if (power == 1)
			return base;
		if (power == -1)
			return (1 / base);

		double value = 1;

		while (true) {

			double t = power % 2;
			power = (int) Math.floor(power / 2);// floor - nearest largest integer of the argument 40.1 -> 40, -42.5 >
												// -43, 40 > 40

			if (t == 1) {
				value = value * base;
			}

			if (power == 0) {
				break;
			}

			base = base * base;
		}

		return value;
	}

	// recursive (doesn't handle negative)
	private static double powerOld(double x, double n) {
		if (n == 1.0)
			return x;
		else if (n % 2 == 1)
			return x * powerOld(x, n - 1);
		else {
			double b = powerOld(x, n / 2);
			return b * b;
		}
	}

	//doesn't handle negative.
	private static long powe(long base, long exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}

		if (exp % 2 == 0) {
			long half = powe(base, exp / 2);
			return half * half;
		} else {
			long half = powe(base, (exp - 1) / 2);
			return base * half * half;
		}
	}

	/**
	 * works in negative case too.
	 * @param base
	 * @param power
	 * @return
	 */
	public static double pow(double base, long power){
		double value;
		if(power < 0 ){
			value = powerHelper(base, (-power)); 
			value = 1 / value;
		} else {
			value = powerHelper(base, power); 
		}
		return value;
	}

	public static double powerHelper(double base, long power){
		if(power == 1){
			return base;
		} else if(power%2 != 0){
			return base * powerHelper(base,(power - 1));
		} else {
			double value = powerHelper(base,power/2);
			return value * value;
		}
	}

	
	/**
	 * works for negative/positive numbers both.
	 * complexity - O(log n)
	 * @param x
	 * @param n
	 * @return
	 */
	static double power(double x, int n) {
		if (n == 0)
			return 1;

		if (n < 0) {
			x = 1.0 / x;
			n = -n;
		}
		double ret = power(x, n / 2);
		ret = ret * ret;
		if (n % 2 != 0)
			ret = ret * x;
		return ret;
	}
}
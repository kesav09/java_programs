package number;

public class SquareRootPractice {
	public static void main(String[] args){
		System.out.println(sqaureRootIterative(8));
		System.out.println(squareRootRec(4));
		System.out.println(squareRootRec(8));
		
	}
	
	public static double sqaureRootIterative(double num){
		if(num < 0){
			num = -num;
		} else if(num == 0 || num == 1){
			return num;
		}
		
		double precision = 0.0001;
		double start = 0;
		double end = num;
		double mid;
		double midSqr;
		
		while((end - start) > precision){
			mid = (start + end)/2;
			midSqr = mid * mid;
			if(num == midSqr){
				return mid;
			} else if(num > midSqr){
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return (start + end)/2;
	}
	
	public static double squareRootRec(double num){
		return squareRootRecursive(num,0,num,0.0001);
	}


	private static double squareRootRecursive(double num,double start, double end, double precision){
		if(num < 0){
			num = -num;
		}
		
		if(num == 0 || num == 1){
			return num;
		} else if((end - start) > precision){
			double mid = (start + end) / 2;
			double midSqr = mid * mid;
			if(midSqr == num) {
				return mid;
			} else if(midSqr < num){
				return squareRootRecursive(num,mid,end,precision);
			} else {
				return squareRootRecursive(num,start,mid,precision);
			}
		} else {
			return ((start + end) / 2);
		}
	}
}

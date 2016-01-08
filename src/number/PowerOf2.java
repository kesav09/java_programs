package number;

public class PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOf2(6));
		
	}

//1. property is if a number is power of 2 then at most only one bit will be set in binary form
//2. do and with a nummber minus 1
//3. this will flip the set bit to 0 and finally '&' will give 0, if 0 then power of 2
	public static boolean isPowerOf2(int num){
		if (num < 1){
			return false;
		}
		if ((num & (num -1)) == 0){
			return true;
		}
		return false;
	}

	//brute force
//1. take initial number as 1
//2 keep multiplying by 2 until the product is >= the number
	private static boolean powerOfTwo(int number){
        int square = 1;
        while(number >= square){
            if(number == square){
                return true;
            }
            square = square*2;
        }
        return false;
    }
}



package bits;

public class CountBitSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCountOfbitSets(11));
		
	}

	public static int getCountOfbitSets(int num){
		if (num < 1){
			return 0;
		}
		int count = 0;
		while(num > 0){
			++count;
			num = num & (num-1);
		}
		return count;
	}

}

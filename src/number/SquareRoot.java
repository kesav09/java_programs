package number;


public class SquareRoot {

    public static void main(String[] args) {
    	bisection(16, 0000001);
//    	int [] num = new int[10];
//    	java.util.Random rand = new java.util.Random();	
//    	for (int i = 0; i < num.length;i++)
//    		num[i] = rand.nextInt(10 - 1)+1;
//    	for (int i = 0; i < num.length;i++)
//    		System.out.print(num[i]+",");

    }

    public static void bisection(float num, float precision) {
        float low = 0f;
        float upper = Math.max(1f, num);
        float guess = (upper + low) / 2;
        int count = 0;
        while (Math.abs(guess * guess - num) > precision && count < 100) {
            if (guess * guess > num) {
                upper = guess;
                guess = (upper + low) / 2;
            } else{
                low = guess;
                guess = (upper + low) / 2;
            }
            count++;
        }
        System.out.println("Num is " + num + " : sqroot is " + guess+ " found in loops : " + count);
    }

    public static void chop(String word){
		System.out.print(word.replaceAll(",", ""));
	}
}
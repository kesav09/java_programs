package string;

import java.util.LinkedList;

/**
 * For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
	e.g 2. "hello how are hello you" - distance is 1 
	e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
	e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 *
 */
public class ShortestLengthBetweenWords {

	public static void main(String[] args) {
		String str = "I am a good I   boy    ";
		//String str = "I am a good boy.";
		System.out.println(getDistance(str, "am", "boy"));	//4
		System.out.println(getDistance(str, "I", "boy"));	//1
		System.out.println(getDistance(str, "I", "I")); //0
		System.out.println(getDistance(str, "boy", "am")); //-1
		System.out.println(getDistance(str, "bad", "bad")); //-1
		System.out.println(getDistance(str, "good", "bad")); //-1
		System.out.println(getDistance("", null, "")); //-1
		System.out.println(getDistance(str, "", null)); //-1
	}

	//hello how you are hello you, hello, hello  - > 0
	public static int getDistance(String str,String target1, String target2){
		if(str == null || str.isEmpty() || target1 == null || target1.isEmpty() || target2 == null || target2.isEmpty()){
			return -1;
		}
		
		String[] strArray = str.split("\\s+");
		int distance = 0, closestDistance = Integer.MAX_VALUE;
		boolean isTarget1Found = false;
		for(int i=0;i<strArray.length;i++){
			if(target1.equals(strArray[i])){
				if(target1 == target2){
					return 0;
				}
				distance = 0;
				isTarget1Found = true;
			}
			
			if(target2.equals(strArray[i]) && isTarget1Found){
				closestDistance = Math.min(distance,closestDistance);
			}
			distance++;
		}
		
		if(closestDistance == Integer.MAX_VALUE || distance == 0){
			return -1;
		}
		return closestDistance;
	}

}

package array;

import java.util.BitSet;
 
/**
 * Java program to find missing elements in a Integer array containing 
 * numbers from 1 to 100.
 * FIXME refer MissingNumber.java which has implementation for both single missing and multiple missing numbers
 */
public class MissingNumberBitset {
 
    public static void main(String args[]) {

        // FIXME even using bitset we can find multiple mising numbers
        printMissingNumber(new int[]{1, 2, 4, 6}, 6);
 
//        // Only one missing number in array
//        int[] iArray = new int[]{1, 2, 3, 5};
//        int missing = getMissingNumber(iArray, 5);
//        System.out.printf("Missing number in array %s is %d %n", 
//                           Arrays.toString(iArray), missing);
    }
   /**
    * A general method to find missing values from an integer array in Java.
    * This method will work even if array has more than one missing element.
    */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
 
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
 
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
 
    }
   /**
    * Java method to find missing number in array of size n containing
    * numbers from 1 to n only.
    * can be used to find missing elements on integer array of 
    * numbers from 1 to 100 or 1 - 1000
    */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
 
        return expectedSum - actualSum;
    }
 
}
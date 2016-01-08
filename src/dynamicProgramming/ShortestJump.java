package dynamicProgramming;

import static org.testng.AssertJUnit.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class ShortestJump {
	public static void main(String[] args) {
		int[] a1 = { 2, 3, 1, 1, 4 };
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(4);
		System.out.println(getShortestJumps(a1));
		assertEquals(expected, getShortestJumps(a1));

		int[] a2 = { 3, 1, 10, 1, 4 };
		expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(2);
		expected.add(4);
		System.out.println(getShortestJumps(a2));
		assertEquals(expected, getShortestJumps(a2));
	}

	public static List<Integer> getShortestJumps(int[] jump) {
		final List<Integer> list = new ArrayList<Integer>();
		if (jump.length == 0) {
			return list;
		}
		int cursor = 0;
		int best = 0;
		int range = 0;
		int remaining = 1;
		while (cursor + 1 < jump.length) {
			if (cursor + jump[cursor] > range) {
				// jumping from here would extend us further than other alternatives so far
				range = cursor + jump[cursor];
				best = cursor;
				if (range >= (jump.length - 1)) {
					// in fact, this jump would take us to the last member, we have a solution
					list.add(best);
					break;
				}
			}
			if (--remaining == 0) {
				// got to the end of our previous jump, move ahead by our best.
				list.add(best);
				remaining = range - cursor;
			}

			cursor++;
		}
		// always add the last member of the array
		list.add(jump.length - 1);
		return list;
	}
}

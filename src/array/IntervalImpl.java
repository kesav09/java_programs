package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;
 
	Interval() {
		start = 0;
		end = 0;
	}
 
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
 
public class IntervalImpl {
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		//Collections.sort(intervals, new IntervalComparator());
		// Inline sort
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2){
				return i1.start - i2.start;
			}
		});
 
		ArrayList<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		int totalRange = 0;
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				totalRange = totalRange + (prev.end - prev.start);
				result.add(prev);
				prev = curr;
			}
		}
		totalRange = totalRange + (prev.end - prev.start);
		System.out.println("Total Range: " + totalRange);
		result.add(prev);
 
		return result;
	}
	
	public static void main(String[] args){
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(3, 6));
		list.add(new Interval(8, 9));
		list.add(new Interval(1, 5));
		list.add(new Interval(1, 3));
		list.add(new Interval(1, 8));
		list.add(new Interval(3, 10));
		list.add(new Interval(15, 25));
		
		list = merge(list);
		for(Interval i: list){
			System.out.println("start: " + i.start + " end: "+i.end);
		}
	}
}
 
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

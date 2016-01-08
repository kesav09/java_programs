package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Intervals{
	void addIntervals(int from, int to);
	int getTotalCoveredLength();
}

public class ClosedIntervalsRange implements Intervals {

	List<Point> list = new ArrayList<Point>();

	public static void main(String [] args) {
		ClosedIntervalsRange obj = new ClosedIntervalsRange();
		obj.addIntervals(3, 6);
		obj.addIntervals(8, 9);
		obj.addIntervals(1, 5);
		System.out.println(obj.getTotalCoveredLength());
	}

	@Override
	public void addIntervals(int x, int y) {
		list.add(new Point(x, y));
	}

	@Override
	public int getTotalCoveredLength() {
		
		Collections.sort(list);
		for (Point p : list){
			System.out.println(p.x+" "+p.y);
		}
		int totalLen = 0;
		Point lastPoint = new Point(0, 0);

		for (Point point : list) {
			if (point.x > lastPoint.y) {   //located apart
				totalLen += point.y - point.x;
				lastPoint = point;
			} else if (point.x == lastPoint.x && lastPoint.y < point.y) { //start from same origin
				totalLen += point.y - lastPoint.y;
				lastPoint = point;
			} else if (point.x < lastPoint.y && point.y > lastPoint.y) { //in between
				totalLen += point.y - lastPoint.y;
				lastPoint = point;
			}
		}
		return totalLen;
	}
}

class Point implements Comparable<Point> {
	
	public int x, y;
	
	Point(int x, int y) {
		if (x > y){
			throw new IllegalArgumentException("x can't be greater than y");
		}
		
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		return o == null ? 0 : (this.x - o.x);
	}
}
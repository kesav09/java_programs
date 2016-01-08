package array;

import java.util.List;

public class NestedIntegerConcrete {
	public int getSum(List<NestedInteger> list, int depth){
		if(list == null || list.isEmpty()){
			return 0;
		}
		
		int sum=0;
		for(NestedInteger nestedInt:list){
			if(nestedInt.isInteger()){
				sum = sum + (nestedInt.getInteger() * depth);
			} else {
				return sum + getSum(nestedInt.getList(),depth+1) ;
			}
		}
		return sum;
	}

	public int getSum(List<NestedInteger> list){
		if(list == null || list.isEmpty()){
			return 0;
		} else {
			return getSum(list,1);
		}		
	}
	
	
}

/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, one 6 at depth2) 
*/ 
/** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
interface NestedInteger { 
	// Returns true if this NestedInteger holds a single integer, rather than a nested list 
	public boolean isInteger(); 

	// Returns the single integer that this NestedInteger holds, if it holds a single integer 
	// Returns null if this NestedInteger holds a nested list 
	public Integer getInteger(); 

	// Returns the nested list that this NestedInteger holds, if it holds a nested list 
	// Returns null if this NestedInteger holds a single integer 
	public List<NestedInteger> getList(); 
}

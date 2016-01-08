package sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingListOfStrings {
	/*// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.

	//Write a program to sort the list of n strings of length m without using any existing API.
	//The algorithm should be efficient in terms of time and space

	m*nlogn
	cat, tag, elem,tam

	cat,elem,tag,tam



	k.m.n.logn


	sort using arrays.sort:
		 using comparator
	            		 Arrays.sort(new String[]{"",""}, fromIndex, toIndex, new Comparator<String>() {
	    	            	
	    	            	public int compare(String str1,String str2){
	    	            		return str1.compareTo(str2);
	    	            	}
	    				});
	*/
	public static void main(String[] args){
		String[] str = {"cat","tam","tag","elem","talm"};
		System.out.print("input: ");
		for(String s:str){
			System.out.print(" "+s);
		}
		List<String> list = new LinkedList<String>(Arrays.asList(str));
		SortingListOfStrings.sortListOfString(list);
		System.out.println();
		System.out.print("sorted string: ");
		for(String s: list){
			System.out.print(" "+s);
		}
	}
	public static void sortListOfString(List<String> list){
		//sort by first character.
	    sortBasedOnKthCharacter(list,0,list.size() - 1 ,0);
	    
	    //sort by index eg: {tam tag talm} - > tag,talm,tam for every index
	    sortByIndex(list);
	}

	//tag,cat tag,elem
	public static void sortByIndex(List<String> list){
	    int index = 0;
	    //abc,bdc,elem,tag,tam,talm,tal
	    for(int i=0;i<list.size() - 1;i++){
	        
	        
	        if(list.get(i).charAt(0) == list.get(i + 1).charAt(0)) {
	            index = i;
	             int maxLength = list.get(index).length();
	             
	             //tag,tam,tal,tan
	            while(index + 1 < list.size() && list.get(index).charAt(0) == list.get(index + 1).charAt(0)){
	                if(maxLength < list.get(index + 1).length()){
	                	maxLength = list.get(index + 1).length();
	                }
	                index++;
	            }
	            
	            int k=1;
	            	while(k<maxLength){
	            		  sortBasedOnKthCharacter(list,i,index,k++);
	            	}
	           i = index + 1;
	           continue;
	        }
	    }
	}


	// k - kth element to be sorted by.
	public static void sortBasedOnKthCharacter(List<String> list,int start, int end, int k){
	    if(start>=end){
	        return;
	    }
	    
	    int pivot = partition(list,start,end,k);
	    
	    sortBasedOnKthCharacter(list,start,pivot - 1,k);
	    sortBasedOnKthCharacter(list,pivot + 1,end,k);
	    
	    return;
	}

	//cat,tag,tam,elem, 0,3, p-1 tag,cat tag,elem
	//cat,elem,tag,tam
	public static int partition(List<String> list, int start,int end, int k){
	    
	    int pivot = ( start + end ) / 2 ;
	    int i = start;
	    int j = end;
	    
	    while(i<j){
	    	while(i < list.size() && k >= list.get(i).length()){
	    		i++;
	    	}
	    	
	    	while(j < list.size() && k >= list.get(j).length()){
	    		--j;
	    	}
	    	
	        while(i < list.size() && (k < list.get(pivot).length() && k < list.get(i).length()) && list.get(pivot).charAt(k) > list.get(i).charAt(k)){
	            i++;
	        }
	        
	        while(j > 0 && (k < list.get(pivot).length() && k < list.get(j).length()) && list.get(pivot).charAt(k) < list.get(j).charAt(k)){
	            --j;
	        }
	        
	        if((i<j) && (k < list.get(i).length() && k < list.get(j).length()) && list.get(i).charAt(k) == list.get(j).charAt(k)){
	        	break;
	        }
	        if(i<j){
	            String iTemp = list.get(i);
	            String jTemp = list.get(j);
	            list.set(i,jTemp);
	            list.set(j,iTemp);
	        }
	    }
	    
	    return j;
	}
	    	    
}

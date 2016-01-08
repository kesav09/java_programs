package string;

public class FindAndReplaceOld {
	
	public static void main(String[] args){
		System.out.println(findAndReplace("yahoo".toCharArray(),"".toCharArray() , "l".toCharArray()));
	}
	
	public static String findAndReplace(char[] orgStr, char[] find, char[] replace){
		StringBuilder stringBuilder = new StringBuilder();
		int j=0;
		for(int i=0;i<orgStr.length;){
			j=0;
			while(i<orgStr.length && j<find.length && orgStr[i] == find[j]){
				j++;
				i++;
			}
			
			if(j == find.length){
				for(int k=0;k<j;k++){
					stringBuilder.append(replace[k]);
				}
			} else {
				stringBuilder.append(orgStr[i++]);
			}
		}
		
		return stringBuilder.toString();
	}
}

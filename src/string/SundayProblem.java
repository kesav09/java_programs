package string;

/*
string: sunday 

s
su
sun 
sund
sunda
sunday
sunda
sund
sun
su
s
 */
 
class SundayProblem{
	public static void main(String[] args){
		String string = "sunday";
		printSubString(1, string.toCharArray());
		printReverseSubString(string.length() - 1, string.toCharArray());
	}
	
	public static void printReverseSubString(int end,char[] actualString){
		if(end<0 || end > actualString.length){
			return;
		}
		for(int i=0;i<end;i++){
			System.out.print(actualString[i]);
		}
		System.out.println();
		printReverseSubString(--end,actualString);
	}
	
	public static void printSubString(int end,char[] actualString){
		if(end<0 || end > actualString.length){
			return;
		}
		for(int i=0;i<end;i++){
			System.out.print(actualString[i]);
		}
		System.out.println();
		printSubString(++end,actualString);
	}
}
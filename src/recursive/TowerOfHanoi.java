package recursive;

public class TowerOfHanoi {
	static int count;
	public static void main(String[] args){
		int total = 3;
		String from = "left";
		String to = "right";
		String inter = "temp";
		moveTower(total,from,to,inter);
	}
	
	static void moveTower(int total,String from, String to, String inter){
		if (total == 0){
			return;
		}
		
		moveTower(total - 1, from, inter, to);
		System.out.println("Move ring "+ total + " from "+from+" to "+to);
		moveTower(total - 1, inter, to , from);
	}
	
}

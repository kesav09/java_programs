package matrix;


/**
 * public interface InfluencerFinder { 

/** 
* Given a matrix of following between N LinkedIn users (with ids from 0 to N-1): 
* followingMatrix[i][j] == true iff user i is following user j 
* thus followingMatrix[i][j] doesn't imply followingMatrix[j][i]. 
* Let's also agree that followingMatrix[i][i] == false 
* 
* Influencer is a user who is: 
* - followed by everyone else and 
* - not following anyone himself 
* 
* This method should find an Influencer by a given matrix of following, 
* or return -1 if there is no Influencer in this group. 
*
	int getInfluencer(boolean[][] followingMatrix)
 *
 */
public class InfluencerProblem {
	
	
	/**
	 * O(n) - by contradiction,
	 * 
	 * @param M
	 * @return
	 */
	static int getInfluencer(int[][] M) {
		int cand=0;
		for(int i=1; i<M.length; i++)
		{
			if(M[cand][i] == 1 && M[i][cand]==0) //if(M[cand][i] == 1 || M[i][cand]==0)
			{
				cand = i;
			}
		}
		// now verify cand is indeed an influencer
		for(int j=0; j<M.length; j++)
		{
			if(j==cand) continue;
			if(M[cand][j]==1 || M[j][cand]==0) return -1;
		}
		return cand;
	}
	
	public static void main(String[] args){
		boolean[][] followingMatrix = {{true,true,false},{false,false,false},{true,true,false}}; 
		System.out.println(getInfluencer(followingMatrix));
		
		int[][] followingMatrix2 = {{1,1,0},{0,0,0},{1,1,0}};//1
		//int[][] followingMatrix2 = {{0,0,0},{1,0,1},{1,0,0}};//0
		//int[][] followingMatrix2 = {{0,1,1},{1,0,1},{0,0,0}};//2
		System.out.println(getInfluencer(followingMatrix2));
	}

	
	//O(n2)
	public static int getInfluencer(boolean[][] followingMatrix){
		//check if a member doesn't follow anyone
		//check if everyone is following that member
		
		boolean isPotentialInfluencer = true;
		for(int i=0;i<followingMatrix.length;i++){
			isPotentialInfluencer = true;
			for(int j=0;j<followingMatrix.length;j++){
				if(i==j){
					continue;
				}
				if(followingMatrix[i][j] || !followingMatrix[j][i]){
					isPotentialInfluencer = false;
					break;
				}
			}
			if(isPotentialInfluencer){
				return i;
			} 
		}
		return -1;
	}
}

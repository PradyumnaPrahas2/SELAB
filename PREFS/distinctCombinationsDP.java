import java.util.*;
public class distinctCombinationsDP
{
    public static int distinctNumberDial(int n){
        int MOD=1000000007;
        Map<Integer,int[]> graph=new HashMap<>();
        graph.put(1,new int[]{6,8});
        graph.put(2,new int[]{7,9});
        graph.put(3,new int[]{4,8});
        graph.put(4,new int[]{0,3,9});
        graph.put(5,new int[]{});
        graph.put(6,new int[]{0,1,7});
        graph.put(7,new int[]{2,6});
        graph.put(8,new int[]{1,3});
        graph.put(9,new int[]{2,4});
        graph.put(0,new int[]{4,6});
        
        int[][] dp=new int[n+1][10];
        
        Arrays.fill(dp[1],1);
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int c:graph.get(j)){
                    dp[i][j]+=dp[i-1][c];
                    dp[i][j]%=MOD;
                }
            }
        }
        
        int ans=0;
        
        for(int i=0;i<10;i++){
            ans+=dp[n][i];
            ans%=MOD;
        }
        
        return ans%MOD;
        
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    
	    int n=5;
	    
	    System.out.print(distinctNumberDial(n));
	}
}
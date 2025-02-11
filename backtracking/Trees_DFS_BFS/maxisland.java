package backtracking.Trees_DFS_BFS;
import java.util.*;
public class maxisland{
    public static int ans=0;
    
    public static int[][] dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
    
    public static void explore(int[][] grid,int i,int j,int p1,int p2,int m,int n,int[][] dp){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return ;
        }
        dp[p1][p2]++;
        grid[i][j]=0;
        for(int [] d:dir){
            explore(grid,i+d[0],j+d[1],p1,p2,m,n,dp);
        }
    }
    
    public static int GetMaxarea(int[][] grid,int m,int n,int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    explore(grid,i,j,i,j,m,n,dp);
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        Scanner x=new Scanner(System.in);
        int m=x.nextInt();
        int n=x.nextInt();
        int[][] grid=new int[m][n];
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=x.nextInt();
                
            }
        }
        
        System.out.print(GetMaxarea(grid,m,n,dp));
    }
}
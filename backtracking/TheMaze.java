
/* 
You are given an N×N grid that represents a maze. 
In this maze: Each cell contains either a 0 or 1.
 --1 indicates an open path where you can walk.
 --0 indicates a dead-end where you cannot pass.

You start at the top-left corner of the maze, i.e., position (0, 0).
Your target is to reach the bottom-right corner of the maze, i.e., position (N-1, N-1).
In the maze, you can move only right or down from each cell.

Objective: Determine if there exists a path from the start (0, 0) to the end (N-1, N-1) that passes only through cells marked 1. 
If such a path exists, return true; otherwise, return false.

Input Format:
-------------
Line-1: The first line contains an integer N, the size of the square grid.
Line 2 to N: The next N lines each contain N space-separated integers (either 0 or 1), representing the maze.

Output Format:
--------------
Line-1: Print true if a path exists from (0, 0) to (N-1, N-1), otherwise print false.

Constraints:
------------
* 1 ≤ N ≤ 100
* Each cell in the grid is either 0 or 1.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true

Explanation: There exists a path from (0, 0) to (3, 3).

Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false

Explanation: There is no valid path from (0, 0) to (3, 3).

*/
import java.util.*;

public class TheMaze{
    
    public static boolean UseDP(int[][] grid,int n){
        
        boolean[][] dp=new boolean[n][n];
        
        if(grid[0][0]==0){
            return false;
        }
        dp[0][0]=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=0 || j!=0){
                    if(grid[i][j]==1){
                        boolean res=false;
                        if(i-1>=0 ){
                            res= res|| dp[i-1][j];
                        }
                        if(j-1>=0){
                            res=res|| dp[i][j-1];
                        }
                        dp[i][j]=res;
                    }
                }
            }
        }
        
        return dp[n-1][n-1];
    }
    public static boolean ans=false;
    public static void dfs(int[][] grid,int n,int i,int j){
        if(i<0 || j<0 || i>=n || j>=n || grid[i][j]==0){
            return;
        }
        if(ans==true){
            return;
        }
        if(i==n-1 && j==n-1 ){
            ans=true;
            return;
        }
        grid[i][j]=0;
        dfs(grid,n,i+1,j);
        dfs(grid,n,i,j+1);
       
    }
    
    public static boolean DFS(int[][] grid,int n){
        dfs(grid,n,0,0);
        return ans;
    }
    
    public static void main(String[] args){
         
         Scanner x=new Scanner(System.in);
         
         int n=x.nextInt();
         
         int[][] grid=new int[n][n];
         
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 grid[i][j]=x.nextInt();
             }
         }
         
        //  System.out.print(UseDP(grid,n));
        System.out.print(DFS(grid,n));
    }
}
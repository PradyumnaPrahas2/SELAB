/*
CONCEPT-> COMBINATIONS OF DFS+BFS
 * The Pandavas and Kauravas each rule different kingdoms separated by a river. 
If the two kingdoms are connected, the land will form a square-shaped area. 
The kingdoms are represented by cells marked with 1, and the river is 
represented by cells marked with 0.

The Pandavas and Kauravas have decided to build a bridge over the river to 
improve connectivity between their kingdoms. To minimize the cost of construction, 
they aim to reduce the length of the bridge. The bridge can only be built on 
river cells that are connected in the four cardinal directions (up, down, left, 
and right).

Your task is to help the rulers minimize the number of river cells used for 
building the bridge, and return the count of river cells occupied.

Input Format:
-------------
Line-1: An integer N, size of the land.
Next N lines: N space separated integers, either 0 or 1. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
1 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
1 1 0 0 0   -1 -1 0   0  0
1 1 0 0 0   -1 -1 0   0  0
0 0 0 0 1    0  0 0   0 -2
0 0 0 1 1    0  0 0  -2 -2
0 0 1 1 1    0  0-2 -2 -2

Sample Output-2:
----------------
3

 */

package PREFS;

import java.util.*;

public class day34p3 {
    public static void dfs(int[][] arr,int i,int j,int n,int r){
        if(i<0 || j<0 || i>=n || j>=n || arr[i][j]!=1){
            return;
        }
        arr[i][j]=r;
        dfs(arr,i+1,j,n,r);
        dfs(arr,i,j+1,n,r);
        dfs(arr,i-1,j,n,r);
        dfs(arr,i,j-1,n,r);
    }
    
    public static int getMincost(int[][] arr,int n){
        
        int[] region={-1,-2};
        int ptr=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    dfs(arr,i,j,n,region[ptr]);
                    ptr++;
                }
            }
        }
        
        Queue<int[]> q=new LinkedList<>();
        
        boolean[][] visited=new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-1){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] top=q.poll();
            int i=top[0];
            int j=top[1];
            int moves=top[2];
            if(arr[i][j]==-2){
                return moves-1;
            }
            
            for(int[] d:dir){
                int ni=i+d[0];
                int nj=j+d[1];
                
                if(ni>=0 && ni<n && nj>=0 && nj<n && visited[ni][nj]==false){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj,moves+1});
                }
            }
        }
        
        return -1;
    }
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int[][] arr=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        System.out.print(getMincost(arr,n));
    }
}

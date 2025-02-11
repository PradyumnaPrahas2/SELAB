package backtracking.Trees_DFS_BFS;
import java.util.*;
public class maxislandBFS{
    
    public static HashSet<String> set=new HashSet<>();
    
    public static String sb;
    
    public static void bfs(int[][] grid,int i,int j,int p1,int p2,int m,int n){
        if(i<0 || j<0 || i>=m ||j>=n || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        sb+="i="+p1+",j="+p2;
        bfs(grid,i+1,j,p1+1,p2,m,n);
        bfs(grid,i,j+1,p1,p2+1,m,n);
        bfs(grid,i-1,j,p1-1,p2,m,n);
        bfs(grid,i,j-1,p1,p2-1,m,n);
    }
    
    public static int BFS(int[][] grid,int m,int n){
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    sb="";
                    bfs(grid,i,j,0,0,m,n);
                    set.add(sb);
                }
            }
        }
        
        return set.size();
        
    }
    
    public static void main(String[] args){
        Scanner x=new Scanner(System.in);
        int m=x.nextInt();
        int n=x.nextInt();
        
        int[][] grid=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=x.nextInt();
            }
        }
        
        System.out.println(BFS(grid,m,n));
    }
} 
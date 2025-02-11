package Greedy;
import java.util.*;
public class Dijkstra{
    
    public static HashMap<Integer,ArrayList<Integer>> GenerateGraph(int[][] adj,int n){
        
        HashMap<Integer,ArrayList<Integer>> Graph=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int node=i;
            ArrayList<Integer> child=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(adj[i][j]!=0){
                    child.add(j);
                }
            }
            Graph.put(node,child);
        }
        
        return Graph;
    }
    
    public static void GetShortestPath(int[][] adj,int n,int node1){
        
        HashMap<Integer,ArrayList<Integer>> Graph=GenerateGraph(adj,n);
        
        boolean[] visited=new boolean[n];
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Integer> q=new LinkedList<>();
        dist[node1]=0;
        visited[node1]= true;
        q.add(node1);
        
        while(!q.isEmpty()){
            
            int node=q.poll();
            int cur_dist=dist[node];
            
            for(int child:Graph.getOrDefault(node,new ArrayList<>())){
                int tot_dist= cur_dist+adj[node][child];
                if(dist[child]>=tot_dist){
                    dist[child]=tot_dist;
                }
                if(visited[child]==false){
                    q.add(child);
                    visited[child]=true;
                }
            }
        }
        System.out.println("Vertex           Distance from Source");
        for(int i=0;i<n;i++){
            System.out.println(i+"                "+dist[i]);
        }
        
    }
    public static void main(String[] args){
        
        Scanner x=new Scanner(System.in);
        int vertices=x.nextInt();
        
        int[][] adj=new int[vertices][vertices];
        
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                adj[i][j]=x.nextInt();
            }
        }
        int node=x.nextInt();
        GetShortestPath(adj,vertices,node);
    }
}
package Greedy;
import java.util.*;
public class FlipKartQuestion {
    public static int[] GetShortestPath(HashMap<Integer,ArrayList<Integer>> graph,int source,int[][] weights,int nodes){
        int[] dist=new int[nodes];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[][] visited=new boolean[nodes][nodes];
        dist[source]=0;

        Queue<Integer> q = new LinkedList<>();

        for(int child:graph.getOrDefault(source,new ArrayList<>())){
            q.add(child);
            int d=dist[source]+weights[source][child];
            if(dist[child]>=d){
                dist[child]=d;
            }
            visited[source][child]=true;
            visited[child][source]=true;
        }
        while(!q.isEmpty()){
            int top=q.poll();
            // System.out.println(top);
            for(int child:graph.getOrDefault(top,new ArrayList<>())){
                if(visited[top][child]==false && visited[child][top]==false){
                    q.add(child);
                    visited[top][child]=true;
                    visited[child][top]=true;
                    int d=dist[top]+weights[top][child];
                    if(dist[child]>=d){
                        dist[child]=d;
                    }
                }
            }
        }
        return dist;
    }

    public static void find(HashMap<Integer,Integer> parent,int s,int n ,ArrayList<ArrayList<Integer>> lca){

        int par=parent.getOrDefault(n,-1);
        if(par==-1){
            return;
        }
        
        lca.add(new ArrayList<>(Arrays.asList(s,par)));

        System.out.println(lca);
        return;
        // find(parent,s,par,lca);
    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int nodes=sc.nextInt();

        int[] warehouse_from=new int[nodes];
        int[] warehouse_to=new int[nodes];
        int[] warehouse_weight=new int[nodes];
        int[] warehouse_val=new int[nodes+1];

        HashMap<Integer,Integer> parent=new HashMap<>();

        for(int i=0;i<nodes-1;i++){
            warehouse_from[i]=sc.nextInt()-1;
        }
        for(int i=0;i<nodes-1;i++){
            warehouse_to[i]=sc.nextInt()-1;
        }
        for(int i=0;i<nodes-1;i++){
            warehouse_weight[i]=sc.nextInt();
        }
        for(int i=0;i<nodes;i++){
            warehouse_val[i]=sc.nextInt();
        }
        int[][] weights=new int[nodes+1][nodes+1];
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
        for(int i=0;i<nodes;i++){
            ArrayList<Integer> a=graph.getOrDefault(warehouse_from[i],new ArrayList<>());
            a.add(warehouse_to[i]);
            graph.put(warehouse_from[i],a);

            parent.put(warehouse_to[i],warehouse_from[i]);
            ArrayList<Integer> a2=graph.getOrDefault(warehouse_to[i],new ArrayList<>());
            a2.add(warehouse_from[i]);
            graph.put(warehouse_to[i],a2);

            weights[warehouse_from[i]][warehouse_to[i]]=warehouse_weight[i];
            weights[warehouse_to[i]][warehouse_from[i]]=warehouse_weight[i];
        }

        ArrayList<ArrayList<Integer>> lca=new ArrayList<>();

        System.out.println(lca);

        for(int i=0;i<nodes;i++){
            
            find(parent,i,i,lca);

        }
            System.out.println(graph);
        int[][] shortest_path=new int[nodes][nodes];

        for(int i=0;i<nodes;i++){
            shortest_path[i]=GetShortestPath(graph,i,weights,nodes);
            System.out.println(Arrays.toString(shortest_path[i]));
        }
        ArrayList<ArrayList<Integer>> pairs=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(i!=j && i<j && shortest_path[i][j]<=warehouse_val[j] ){
                    pairs.add(new ArrayList<>(Arrays.asList(i+1,j+1)));
                }
            }
        }
        System.out.println(pairs+"\n");
        System.out.println("Valid pairs are:- "+pairs.size());
    }
}

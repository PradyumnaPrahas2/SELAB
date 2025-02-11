package backtracking;
import java.util.*;
// Time complexity of this Algorithm is O(N!) 
public class HamiltonianCycle {

    public static List<ArrayDeque<Integer>> finalAnswer = new ArrayList<>();

    public static void findHCycle(int[][] graph,int N,int vertex,int source,ArrayDeque<Integer> dq,HashSet<Integer> visited){
        if(dq.size()==N+1 && vertex==source){
            finalAnswer.add(dq);
            return ;
        }

        // dq.add(vertex);
        for(int i=0;i<N;i++){
            if(graph[vertex][i]==1){
                if(!dq.contains(i) || i==source){
                    dq.addLast(i);
                    findHCycle(graph, N, i, source, new ArrayDeque<>(dq), visited);
                    dq.removeLast();
                }
            }
        }
        return ;
    }
    

    public static List<ArrayDeque<Integer>> hamiltonianCycle(int[][] graph,int N){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        findHCycle(graph,N,0,0,dq,new HashSet<>());

        return finalAnswer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = 5;

        // int[][] graph = new int[N][N];

        // for(int i=0;i<N;i++){
        //     for(int j=0;j<N;j++){
        //         graph[i][j] = sc.nextInt();
        //     }
        // }
        // int[][] graph={{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,1},{0,1,1,1,0}};

        int[][] graph ={{0, 1, 0, 1, 0},{1, 0, 1, 1, 1},{0, 1, 0, 0, 1},{1, 1, 0, 0, 0},{0, 1, 1, 0, 0}};

        System.out.println(hamiltonianCycle(graph,N));

        sc.close();
    }
}

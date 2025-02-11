import java.util.*;
public class TSPDP {

    public static int TSP_DP(int[][] cost,int n){

        Map<String,Integer> dp=new HashMap<>();

        List<Integer> visited=new ArrayList<>();

        visited.add(0);

        return helper(cost,0,visited,dp,n);
    }
    public static int helper(int[][] cost,int pos,List<Integer> visited,Map<String,Integer> dp,int n){

        if(visited.size()==n){
            return cost[pos][0];
        }

        String key=pos+":"+visited;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int ans=Integer.MAX_VALUE;

        for(int city=0;city<n;city++){
            if(!visited.contains(city)){
                visited.add(city);
                int cur_cost=cost[pos][city]+helper(cost,city,visited,dp,n);
                ans=Math.min(ans,cur_cost);
                visited.remove(visited.size()-1);
            }
        }

        dp.put(key,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[][] cost = {
            {0, 12, 10, 19, 8, 17}, 
            {12, 0, 3, 7, 2, 15}, 
            {10, 3, 0, 6, 20, 11}, 
            {19, 7, 6, 0, 4, 13}, 
            {8, 2, 20, 4, 0, 5}, 
            {17, 15, 11, 13, 5, 0}
        };
        
        int n = cost.length;

        int result = TSP_DP(cost, n);
        System.out.println("Minimum Cost: " + result);
    }
}

import java.util.*;


public class ClimbingStairs{
    
    public static Map<Integer,Integer> map=new HashMap<>();
    
    public static int fib(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=fib(n-1)+fib(n-2);
        map.put(n,a);
        return a;
    }
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        System.out.print(fib(n));
        
        // int[] dp=new int[n+1];
        // if(n==0){
        //     System.out.print(0);
        //     return;
        // }
        // if(n==1){
        //     System.out.print(1);
        //     return;
        // }
        // dp[0]=0;
        // dp[1]=1;
        // dp[2]=2;
        
        // for(int i=3;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        
        // System.out.print(dp[n]);
    }
}
import java.util.*;
public class OBST{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nodes=new int[n];
        int[] cost=new int[n];

        for(int i=0;i<n;i++){
            nodes[i]=sc.nextInt();
        }
        for(int j=0;j<n;j++){
            cost[j]=sc.nextInt();
        }

    System.out.print(minOBST(cost,n));
    }

    public static int minOBST(int[] arr,int n){
        int[][] dp=new int[n][n];
        return helper(arr,0,n-1,dp);
    }
    public static int helper(int[] arr,int start,int end,int[][] dp){
        if(start>end){
            return 0;
        }
        if(start==end){
            return arr[start];
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        int fsum=sum(arr,start,end);

        int next=Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            int left=helper(arr,start,i-1,dp);
            int right=helper(arr,i+1,end,dp);
            next=Math.min(next,left+right);
        }
        dp[start][end]=next+fsum;
        return next+fsum;
    }
    public static int sum(int[] arr,int i,int j){
        int s=0;
        for(int k=i;k<=j;k++) s+=arr[k];
        return s;
    }
}
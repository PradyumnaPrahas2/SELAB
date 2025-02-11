import java.util.*;

public class MatrixChainMultiplication{
    
    
    public static int splitMatrix(int[] mat,int start,int end){
        
        if(end-start==1){
            return 0;
        }
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=start+1;i<end;i++){
            int left=splitMatrix(mat,start,i);
            int right=splitMatrix(mat,i,end);
            
            int cur=mat[start]*mat[i]*mat[end];
            
            ans=Math.min(ans,left+right+cur);
        }
        return ans;
    }
    
    public static void main (String[] args) {
        
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int[] mat=new int[n];
        
        for(int i=0;i<n;i++){
            mat[i]=sc.nextInt();
        }
        
        System.out.print(splitMatrix(mat,0,n-1));
    }
}
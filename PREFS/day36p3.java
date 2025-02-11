/*
CONCEPT-> BACKTRACKING OR DP
 * You are given a set of N integers, and a value to find F. Initially a variable, 
'total' is set to 0. You can perform either addition(+) or subtraction(-)
of every integer from the set to the 'total'. The resultant total should be
equal to the value F.

Your task is to find out the number of ways, you can make the 'total' equal to
the value F.

Input Format:
-------------
Line-1: Two integers N and F.
Line-2: N space separated integers 

Output Format:
--------------
Print an integer, number of ways.


Sample Input:
---------------
5 3
1 1 1 1 1

Sample Output:
----------------
5

Explanation:
------------
total = -1+1+1+1+1 = 3 -> total=value-F
total = +1-1+1+1+1 = 3 -> total=value-F
total = +1+1-1+1+1 = 3 -> total=value-F
total = +1+1+1-1+1 = 3 -> total=value-F
total = +1+1+1+1-1 = 3 -> total=value-F

NOTE: + means addition, - means subtraction

 */
import java.util.*;
public class day36p3{
    public static int ans=0;
    
    public static void backtrack(int n,int idx,int sum,int[] arr){
        if(sum==n && idx==arr.length){
            ans++;
        }
        if(idx>=arr.length) return;
        backtrack(n,idx+1,sum+arr[idx],arr);
        backtrack(n,idx+1,sum-arr[idx],arr);
    }
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int f=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        backtrack(f,0,0,arr);
        
        System.out.print(ans);
    }
}
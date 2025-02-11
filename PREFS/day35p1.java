/*
CONCEPT-> BACKTRACKING
 * Ms Manasa is working on numbers; she is fascinated by number factors.
She is given a number N, she wants to find out all possible ways of 
obtaining N as multiple of its factors.
For example given N =12
can be written as multiple of 2,3 and 4.
and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

Your task is to help Ms Manasa to find the all possible ways of obtaining N 
from its factors and return all the possible ways as shown in the samples.

Input Format:
-------------
An integer N, value of N.

Output Format:
--------------
Print the list of possiblilties.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 2, 3], [2, 6], [3, 4]]


Sample Input-2:
---------------
16

Sample Output-2:
----------------
[[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]

 */
import java.util.*;
public class day35p1{
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        System.out.print(generateCombinations(n));
    }
    
    public static ArrayList<ArrayList<Integer>> generateCombinations(int n){
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        makeCombinations(n,arr,ans,1,n);
        
        return ans;
    }
    
    public static void makeCombinations(int n,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ans,int cur_product,int total){
        
        if(cur_product==total){
            if(arr.size()>1){
                ans.add(new ArrayList<>(arr));
            }
            return;
        }
        
        for(int i=2;i<=n;i++){
            
            if(n%i==0 && (arr.size()==0 || arr.get(arr.size()-1)<=i)){
                int l=arr.size();
                arr.add(i);
                makeCombinations(n/i,arr,ans,cur_product*i,total);
                arr.remove(l);
            }
        }
    }
}
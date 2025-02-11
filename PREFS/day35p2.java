/*
CONCEPT-> DP
 * Given a nokia phone,with the following dialpad.
		1 2 3
		4 5 6
		7 8 9
		* 0 #
And You are given an L band to dial the number,  
Using the L band you can dial the number as follows, 
You can start with any digit,
	if you are at digit 1, next digit you can choose {6,8}
	if you are at digit 2, next digit you can choose {7,9}
	if you are at digit 3, next digit you can choose {4,8}
	and so on..

Now your task is to find how many distinct numbers of length N you can dial.

Note: Numbers should contain only digits, no {* , #}.
Answer is modulo 1 0 0 0 0 0 0 0 0 7.

Input Format:
-----------------
An integer N, length of numbers
 
Output Format:
------------------
Print an integer, number of distinct numbers you can dial.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
10

Explanation:
-------------
To dial a number of length 1, you can dial all digits.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
20

Explanation:
------------
To dial a number of length 2, the possible numbers are
{04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

Sample Input-3:
---------------
5

Sample Output-3:
----------------
240

 */
import java.util.*;
public class day35p2{
    
    public static int distinctCombinations(int n,Map<Integer,int[]> graph){
        int MOD=1000000007;
        int[][] dp=new int[10][n+1];
        
        for(int i=0;i<10;i++){
            dp[i][1]=1;
        }
        
        for(int i=2;i<n+1;i++){
            for(int j=0;j<10;j++){
                int[] child=graph.get(j);
                for(int c:child){
                    dp[j][i]+=dp[c][i-1];
                    dp[j][i]%=MOD;
                }
            }
        }
        
        int sum=0;
        
        for(int i=0;i<10;i++){
            sum+=dp[i][n];
            sum%=MOD;
        }
        return sum%MOD;
    }
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();

        Map<Integer,int[]> graph=new HashMap<>();
        
        graph.put(0,new int[]{4,6});
        graph.put(1,new int[]{6,8});
        graph.put(2,new int[]{7,9});
        graph.put(3,new int[]{4,8});
        graph.put(5,new int[]{});
        graph.put(4,new int[]{0,3,9});
        graph.put(6,new int[]{0,1,7});
        graph.put(7,new int[]{2,6});
        graph.put(8,new int[]{1,3});
        graph.put(9,new int[]{2,4});
        
        System.out.print(distinctCombinations(n,graph));
        
    }
}
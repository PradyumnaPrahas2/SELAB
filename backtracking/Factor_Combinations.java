/*
 * You are given an integer n. 
Your task is to find all possible unique combinations of integers greater than 1 that multiply together to form n.

Each combination should be represented as a list of integers, 
and the combinations should be sorted lexicographically based on the factors. 
The output should not include duplicate combinations.

Input Format:
-------------
Line-1: An integer n where n > 1.

Output Format:
---------------
Line-1: A list of lists, where each sublist contains integers that represent one valid factor combination of n.

Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 6], [2, 2, 3], [3, 4]]


Sample Input-2:
---------------
15

Sample Output-2:
----------------
[[3, 5]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2], [4, 8]]

 */

import java.util.*;
public class Factor_Combinations {
    
    public static ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    
    public static Set<String> s=new HashSet<>();
    
    public static void getCombinations(int N,ArrayList<Integer> arr){

        if(N==1){
            ArrayList<Integer> pq=new ArrayList<>(arr);
            if(pq.size()<=1){
                return;
            }
            Collections.sort(pq);
            
            String str=pq.toString();
            if(s.contains(str)){
                return;
            }
            ans.add(pq);
            s.add(str);
            return;
        }
        // System.out.println(arr);
        for(int i=2;i<=N;i++){
            
            ArrayList<Integer> arr2=new ArrayList<>(arr);
            
            if(N%i==0){
                
                arr2.add(i);
                
                getCombinations(N/i,arr2);
            }
        }
    }
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        
        Comparator<ArrayList<Integer>> comp=new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
                int m1=a1.get(0);
                int n1=a2.get(0);
                if(m1!=n1){
                    return m1-n1;
                }
                m1=a1.get(a1.size()-1);
                n1=a2.get(a2.size()-1);
                return n1-m1;
            }
        };
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        getCombinations(N,arr);
        
        
        Collections.sort(ans,comp);
        if(ans.size()==0){
            ans.add(new ArrayList<>());
        }
        System.out.print(ans);
    }
}
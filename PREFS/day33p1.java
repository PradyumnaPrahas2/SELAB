/*
CONCEPT-> BACKTRACKING
 * Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
           abc	   def
		 
	4		5		6
    ghi    jkl     mno
  
	7		8		9
    pqrs    tuv     wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]

 */

package PREFS;

import java.util.*;

public class day33p1 {
    public static ArrayList<String> Merge(ArrayList<String> arr1,ArrayList<String> arr2){
        ArrayList<String> arr3=new ArrayList<>();
        
        for(int i=0;i<arr1.size();i++){
            for(int j=0;j<arr2.size();j++){
                arr3.add(arr1.get(i)+arr2.get(j));
            }
        }
        
        return arr3;
    }
    
    public static ArrayList<String> getCombinations(String n,Map<Integer,ArrayList<String>> map){
        
        int first=n.charAt(0)-'0';
        
        ArrayList<String> ref=map.get(first);
        
        for(int i=1;i<n.length();i++){
            
            ref=Merge(ref,map.get(n.charAt(i)-'0'));
            
        }
        
        return ref;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String N=sc.nextLine();
        
        Map<Integer,ArrayList<String>> map=new HashMap<>();
        map.put(2,new ArrayList<>(Arrays.asList("a","b","c")));
        map.put(3,new ArrayList<>(Arrays.asList("d","e","f")));
        map.put(4,new ArrayList<>(Arrays.asList("g","h","i")));
        map.put(5,new ArrayList<>(Arrays.asList("j","k","l")));
        map.put(6,new ArrayList<>(Arrays.asList("m","n","o")));
        map.put(7,new ArrayList<>(Arrays.asList("p","q","r","s")));
        map.put(8,new ArrayList<>(Arrays.asList("t","u","v")));
        map.put(9,new ArrayList<>(Arrays.asList("w","x","y","z")));
        
        System.out.print(getCombinations(N,map));
    }
}

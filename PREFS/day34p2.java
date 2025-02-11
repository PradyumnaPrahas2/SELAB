/*
CONCEPT-> BACKTRACKING
 * Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.

 */

package PREFS;
import java.util.*;
public class day34p2 {
    public static int maxNumber=0;
    
    public static void getCombinations(String word,ArrayList<String> set){
        
        if(word.length()==0){
            int i=set.size();
            maxNumber=Math.max(maxNumber,i);
            
            return;
        }
        
        for(int i=0;i<word.length();i++){
            String cur=word.substring(0,i+1);
            int l=set.size();
            boolean con=set.contains(cur);
            if(con==false){
            
                set.add(cur);
            
                String right="";
                
                if(i+1<word.length()) right=word.substring(i+1);
                
                getCombinations(right,set);
                
    
                set.remove(l);
            }
        }
    }
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        String word=sc.nextLine();
        
        getCombinations(word,new ArrayList<>());
        
        System.out.print(maxNumber);
    }
}

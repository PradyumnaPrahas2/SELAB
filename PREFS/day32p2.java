/* CONCEPT-> BACKTRACKING
 * There are some cubes, and each cube has an alphabet (from A to Z) 
printed on it. You can construct different, non-empty words using these 
cubes and each of the word length should be 0 < length <= number of cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89

 */

package PREFS;
import java.util.*;
public class day32p2 {
    public static Set<String> set = new HashSet<>();
    
    public static void FindPossibilities(String str,boolean[] visited,String cur){
        if(!set.contains(cur) && cur.length()!=0){
            set.add(cur);
            
        }
        
        for(int i=0;i<str.length();i++){
            if(visited[i]==false){
                visited[i]=true;
                FindPossibilities(str,visited,cur+str.charAt(i));
                visited[i]=false;
            }
        }
    }
    
    public static void helper(String s){
        if(set.contains(s) || s.length()==0){
            return;
        }
        if(s.length()!=0){
            set.add(s);
        }
        for(int i=0;i<s.length();i++){
            String cur=""+s.charAt(i);
            String left="",right="";
            if(i>=0) left=s.substring(0,i);
            if(i+1<s.length()) right=s.substring(i+1);
            
            String merged =left+right+cur;
            if(left.length()!=0){
                set.add(left);
            }
            if(right.length()!=0){
                set.add(right);
            }
            if(cur.length()!=0){
                set.add(cur);
            }
            helper(merged);

            // helper(left);
    
            // helper(right);
    
            // helper(cur);
        }
    }
    
    public static void main(String[] args){
        
        Scanner x = new Scanner(System.in);
        
        String s=x.nextLine();
        
        // helper(s);
        
        ArrayList<Character> str=new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            str.add(s.charAt(i));
        }
        boolean[] visited = new boolean[s.length()];
        FindPossibilities(s,visited,"");
        // System.out.println(set);
        System.out.println(set.size());
    }
}

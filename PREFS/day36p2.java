/*
CONCEPT-> GRAPH+BACKTRACKING + DFS
 * Mr Ajay Sharma is working woth words.
He found that few words in the langugage have same meaning.
Such words are given as a list of pairs as mappedpairs[],
where mappedpairs[i] = [word1, word2] indicates that word1 and word2 are 
the words with same meaning.

He is given phrase, and he wants to apply all the mappedpairs[] on the phrase.

Your task is to help Mr.Ajay Sharma to find and return all possible 
Mapped Phrases generated after applying all the mapped words,
and print them in lexicographical order.


Input Format:
-------------
Line-1: An integer N, number of mapped pairs.
Next N lines: Two space separated words, mappedpair[].
Last Line: A line of words, the phrase.

Output Format:
--------------
Print the list of mapped phrases in sorted order.


Sample Input-1:
---------------
3
hi hello
sweet sugar
candy chocolate
hi sam! ram has a sugar candy

Sample Output-1:
----------------
[hello sam! he has sugar candy, hello sam! he has sugar chocolate, 
hello sam! he has sweet candy, hello sam! he has sweet chocolate, 
hi sam! he has sugar candy, hi sam! he has sugar chocolate, 
hi sam! he has sweet candy, hi sam! he has sweet chocolate]



Sample Input-2:
---------------
2
hi hey
hey hello
hi how are you

Sample Output-2:
----------------
[hello how are you, hey how are you, hi how are you]
 */

 import java.util.*;
public class day36p2 {
    public static Map<Integer,ArrayList<String>> visited=new HashMap<>();
    
    public static void dfs(Map<String,ArrayList<String>> map,String word,ArrayList<String> all_words){
        if(all_words.contains(word)){
            return;
        }
        all_words.add(word);
        for(String v:map.getOrDefault(word,new ArrayList<>())){
            dfs(map,v,all_words);
        }
    }
    
    public static List<ArrayList<String>> all_comb=new ArrayList<>();
    
    public static void backtrack(Map<String,ArrayList<String>> map,String[] sen,ArrayList<String> arr,int idx){
        if(idx==sen.length){
            // System.out.println(arr);
            all_comb.add(new ArrayList<>(arr));
            return;
        }
        String word=sen[idx];
        
        ArrayList<String> all_words=new ArrayList<>();
        
        dfs(map,word,all_words);
        
        for(int i=0;i<all_words.size();i++){
    
            arr.add(all_words.get(i));
            
            backtrack(map,sen,arr,idx+1);
            
            arr.remove(arr.size()-1);
        }
    }
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Map<String,ArrayList<String>> map=new HashMap<>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String[] s=sc.nextLine().split(" ");
            ArrayList<String> arr=map.getOrDefault(s[0],new ArrayList<>());
            arr.add(s[1]);
            map.put(s[0],arr);
            
            ArrayList<String> arr2=map.getOrDefault(s[1],new ArrayList<>());
            arr2.add(s[0]);
            map.put(s[1],arr2);
        }
        
        // System.out.print(map);
        
        String[] sen=sc.nextLine().split(" ");
        
        backtrack(map,sen,new ArrayList<>(),0);
        ArrayList<StringBuilder> fa=new ArrayList<>();
        for(ArrayList<String> a:all_comb){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<a.size();i++){
                if(a.size()-1==i){
                    sb.append(a.get(i));
                }
                else{
                    sb.append(a.get(i)+" ");
                }
            }
            fa.add(sb);
        }
        Collections.sort(fa);
        System.out.print(fa);
    }
}

package DynamicProgramming;
import java.util.*;
public class passwordDetection {
    public static int ans=Integer.MAX_VALUE;
    public static void backtrack(String s,int idx,int count,int v,int c){
        if(v==c && v+c==s.length()){
            ans=Math.min(count,ans);
            return;
        }
        if(idx>=s.length()) return;

        char curr=s.charAt(idx);
        // process current character
        if(curr=='a' || curr=='e' || curr=='i' || curr=='o' || curr=='u'){
            backtrack(s, idx+1, count, v+1, c);
        }
        else{
            backtrack(s, idx+1, count, v+1, c);
        }
        // replace current character
        if(curr!='a'){
            char prev=(char)((curr-'a')-1);
            if(prev=='a' || prev=='i' || prev=='o' || prev=='u'){
                backtrack(s,idx+1,count+1,)
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        
        backtrack(s,0,0,0,0);
    }
}

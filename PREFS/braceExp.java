package PREFS;
import java.util.*;
public class braceExp {
    public static List<String> ans=new ArrayList<>();
    public static void helper(List<String[]> l,int idx,String s){
        if(idx==l.size()){
            ans.add(s);
            return;
        }
        for(int i=0;i<l.get(idx).length;i++){
            String s2=s+l.get(idx)[i];
            helper(l,idx+1,s2);
        }
    }
    public static List<String> getCombinations(List<String[]> l){
        helper(l,0,"");
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Character> st=new Stack<>();
        List<String[]> l=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                st.add('[');
                //steps
                StringBuilder s2b=new StringBuilder();
                while(!st.isEmpty()){
                    if(st.peek()!='['){
                        s2b.append(st.peek());
                    }
                    st.pop();
                }
                s2b.reverse();
                l.add(new String[]{s2b.toString()});
            }
            else if(s.charAt(i)==']'){
                //steps
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty() && st.peek()!='['){
                    sb.append(st.peek());
                    st.pop();
                }
                String[] str=sb.reverse().toString().split(",");
                l.add(str);
            }
            else{
                st.add(s.charAt(i));
            }
        }
        System.out.println(getCombinations(l));
    }
}

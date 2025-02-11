import java.util.*;
public class GenerateAbbreviation{
    
    public static  List<String> ans=new ArrayList<>();
    
    public static void getCombinations(String s,int idx,String sb,int count){
        if(idx==s.length()){
            // System.out.println(sb);
            if(count>0){
                sb+=count;
            }
            sb.trim();
            if(sb.length()>0 && !ans.contains(sb))
            ans.add(sb);
            
            return;
        }
        
        getCombinations(s,idx+1,sb,count+1);
        
        if(count==0){
            getCombinations(s,idx+1,sb+s.charAt(idx),count);
        }
        else{
            getCombinations(s,idx+1,sb+count+s.charAt(idx),0);
        }
        
    }
    
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        String s=sc.nextLine();
        
        String sb="";

        getCombinations(s,0,sb,0);
        
        Collections.sort(ans);
        
        // System.out.println(ans);
        
        System.out.println(ans.size());

    }
}
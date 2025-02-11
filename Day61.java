import java.util.*;
public class Day61{
    
    public static boolean Compare(String word,String ref,int cur_idx,int ref_idx,int operation){
        if(ref_idx==ref.length()){
            return true;
        }
        System.out.print(cur_idx+" "+ref_idx);
        if(ref.charAt(ref_idx)>='a' && ref.charAt(ref_idx)<='z'){
            if(ref.charAt(ref_idx)!=word.charAt(cur_idx)){
                return false;
            }
            System.out.println(" Operation 1");
            ref_idx++;
            cur_idx++;
            return Compare(word,ref,cur_idx,ref_idx,1);
        }
        if(operation==2){
            return false;
        }
        System.out.println(" Operation 2");
        String nums="";
        while(ref.charAt(ref_idx+1)>='0' && ref.charAt(ref_idx+1)<='9'){
            nums+=ref.charAt(ref_idx);
            ref_idx++;
        }
        nums+=ref.charAt(ref_idx);
        ref_idx++;
        System.out.println(nums);
        while(cur_idx+Integer.parseInt(nums)>word.length()){
            nums=nums.substring(0,nums.length()-1);
            ref_idx--;
            System.out.println(nums);
        }
        if(nums.equals("0")){
            return false;
        }
        if(cur_idx+Integer.parseInt(nums)>word.length()){
            return false;
        }
        cur_idx+=Integer.parseInt(nums);
        return Compare(word,ref,cur_idx,ref_idx,2);
    }
    private static final int x;
    static{
        x=0;
    }
    public static void main(String... args){
        Scanner x=new Scanner(System.in);
        String[] words=x.nextLine().split(" ");
        String word=words[0];
        String ref=words[1];
        int cur_idx=0;
        int ref_idx=0;
        System.out.print(Compare(word,ref,cur_idx,ref_idx,-1));
    }
}

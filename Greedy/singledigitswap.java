package Greedy;
import java.util.*;
public class singledigitswap{
    
    public static int compute(int MAX,String s){
        
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                String leftmost=s.substring(0,i);
                String middle=s.substring(i+1,j);
                String rightmost=s.substring(j+1,s.length());
                char cur=s.charAt(i);
                char next=s.charAt(j);
                String ref=leftmost+next+middle+cur+rightmost;                        
                MAX=Math.max(MAX,Integer.parseInt(ref));
            }
        }
        return MAX;
    }
    
    public static void main(String[] args){
        // Scanner x=new Scanner(System.in);
        // String n=x.next();
        String demo="";
        demo+=2;
        demo+='c';
        demo+=false;
        if(demo=="2cfalse") System.out.println("==");
        if(demo.equals("2cfalse")) System.out.println("equals");
        System.out.print(demo);
        // int MAX=Integer.parseInt(n);
        // System.out.print(compute(MAX,n));
    }
}
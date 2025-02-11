package backtracking;

import java.util.*;

public class BraceExpression{
    
    public static List<String> Combinations=new ArrayList<>();
    
    public static void FindPossibilities(List<String[]> arr,int idx,String s){
        if(idx==arr.size()){
            Combinations.add(s);
            return;
        }
        
        for(int i=0;i<arr.get(idx).length;i++){
            String s2=s;
            s+=arr.get(idx)[i];
            System.out.println(s);
            FindPossibilities(arr,idx+1,s);
            s=s2;
        }
    }
    
    public static void addChar(Character c,Map<Integer,List<Character>> arr,int idx){
        List<Character> chr=arr.getOrDefault(idx,new ArrayList<>());
        chr.add(c);
        arr.put(idx,chr);
    }
    
    public static void main(String[] args){
        Scanner x=new Scanner(System.in);
        
        String s=x.nextLine();
        
        Map<Integer,List<Character>> arr=new HashMap<>();
        
        int idx=0;
        boolean inRange=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                inRange=true;
            }
            else if(s.charAt(i)==']'){
                idx++;
                inRange=false;
            }
            else if(inRange==false && s.charAt(i)!='[' ){
                addChar(s.charAt(i),arr,idx);
                idx++;
            }
            else if(inRange==true && s.charAt(i)!='[' ){
                addChar(s.charAt(i),arr,idx);
            }
        }
        
        System.out.println(arr);
        List<List<String>> array=new ArrayList<>();
        
        for(int k:arr.keySet()){
            String S="";
            List<Character> l=arr.get(k);
            List<String> L=new ArrayList<>();
            for(int i=0;i<l.size();i++){
                String chr=""+l.get(i);
                if(chr.length()==0){
                    L.add(S);
                    S="";
                }
                else{
                    S+=chr;
                }
            }
            L.add(S);
            array.add(L);
        }
        System.out.println(array);
        List<String[]> array1=new ArrayList<>();
        for(int i=0;i<array.size();i++){
            String s2=array.get(i).get(0);
            array1.add(s2.split(","));
        }
        FindPossibilities(array1,0,"");
        
        System.out.println(Combinations);
        
    }
}
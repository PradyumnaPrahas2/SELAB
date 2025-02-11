import java.util.*;
public class coding{

    public static String decrypt(String s){
        Stack<Integer> st1=new Stack<>();

        Stack<String> st2=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                st2.add("[");
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                String str="";
                while(s.charAt(i)>='0' && s.charAt(i)<='9'){
                    str+=s.charAt(i);
                    i++;
                }
                st1.add(Integer.parseInt(str));
                i--;
            }
            else if(s.charAt(i)==']'){
                String str="";
                while(st2.peek()!="["){
                    str=st2.peek()+str;
                    st2.pop();
                }
                st2.pop();
                // System.out.println(str);
                String str2="";
                for(int c=0;c<st1.peek();c++){
                    str2+=str;
                }
                st1.pop();
                st2.add(str2);
            }
            else{
                st2.add(""+s.charAt(i));
            }
        }
        if(st2.isEmpty()){
            return "";
        }
        return st2.peek();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();

        System.out.print(decrypt(s));
    }
}
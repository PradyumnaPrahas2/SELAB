import java.util.*;
public class specialStrings {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();

        int ans=0;
        for(int i=0;i<s.length();i++){
            String ref=""+s.charAt(i);
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                ref+=s.charAt(i+1);
                i++;
            }
            int n=ref.length();
            ans+=(n)*(n+1)/2;
        }
        System.out.print(ans);
    }
}

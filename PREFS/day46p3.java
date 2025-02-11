import java.util.*;
public class day46p3{
    public static boolean checkValidity(String s){
        if(s.length()<8){
            return false;
        }
        int c=0;
        int a=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                c++;
            }
            else{
                a++;
            }
        }
        // System.out.println(a+" "+c);
        if(a>0 && c>0){
            return true;
        }
        return false;
    }
    public static void main (String[] args) {
        // Scanner sc=new Scanner(System.in);
        
        // int m=sc.nextInt();
        int m=1;
        // int n=sc.nextInt();
        int n=1;
        // sc.nextLine();
        ArrayList<String> tokens=new ArrayList<>();
        for(int i=0;i<m;i++){
            // String s=sc.nextLine();
            tokens.add("acg71288bybi");
            tokens.add("rkifz4hkzy3k");
            tokens.add("1ezzh1gyfswh");
            tokens.add("hrmkv5b1f7qr");
            tokens.add("mvf1pk83na47");
        }
        ArrayList<String> urls=new ArrayList<>();
        for(int i=0;i<n;i++){
            urls.add("GET,https://example.com?token=mvf1pk83na47&id=0x6&name=xmit");
            urls.add("POST,https://example.com?token=rkifz4hkzy3k&id=int&name=7ad6");
            urls.add("POST,https://example.com?token=1ezzh1gyfswh&id=u82&name=tu7d&csrf=kx0ccyvu");
        }
        
        for(int i=0;i<urls.size();i++){
            String[] doc=urls.get(i).split(",");
            if(doc[0].equals("GET")){
                String[] inner=doc[1].split(".com");
                String[] params=inner[1].split("&");
                // System.out.println(Arrays.toString(inner));
                Map<String,String> map=new HashMap<>();
                boolean possible=false;

                for(int j=0;j<params.length;j++){
                    String str=params[j];
                    String key=str.split("=")[0];
                    String val=str.split("=")[1];
                    // System.out.println(key+" "+val);
                    if(key.equals("token") || key.equals("?token")){
                        if(tokens.contains(val)){
                            possible=true;
                            // break;
                        }
                    }
                    else{
                        map.put(key,val);
                    }
                }
                if(possible==true){
                    StringBuilder sb=new StringBuilder();
                    sb.append("VALID, ");
                    sb.append("name="+map.get("name")+", ");
                    sb.append("id="+map.get("id"));
                    System.out.println(sb);
                }
                else{
                    System.out.println("INVALID");
                }
            }
            else{
                String[] inner=doc[1].split(".com");
                String[] params=inner[1].split("&");
                Map<String,String> map=new HashMap<>();
                boolean possible=false;
                boolean csrf=false;
                for(int j=0;j<params.length;j++){
                    String str=params[j];
                    String key=str.split("=")[0];
                    String val=str.split("=")[1];
                    // System.out.println(key+" "+val);
                    if(key.equals("token") || key.equals("?token")){
                        if(tokens.contains(val)){
                            possible=true;
                        }
                    }
                    else if(key.equals("csrf")){
                        // System.out.println(key+" "+val);
                        csrf=true;
                        if(checkValidity(val)==false){
                            possible=false;
                            // System.out.println("FALSE");
                            break;
                        }
                    }
                    else{
                        map.put(key,val);
                    }
                }
                if(possible==true && csrf==true){
                    StringBuilder sb=new StringBuilder();
                    sb.append("VALID, ");
                    sb.append("name"+"="+map.get("name")+", ");
                    sb.append("id="+map.get("id"));
                    System.out.println(sb);
                }
                else{
                    System.out.println("INVALID");
                }
            }
        }
    }
}

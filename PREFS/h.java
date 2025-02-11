package PREFS;

import java.util.*;

class h {
    static String construct(HashMap<String, String> m) {
        List<String> ans = new ArrayList<>();
        ans.add("VALID");
        for (Map.Entry<String, String> s : m.entrySet()) {
            if(s.getKey().equals("csrf")) continue;
            String x = s.getKey() + "=" + s.getValue();
            ans.add(x);
        }
        return String.join(", ", ans);
    }

    static String extract(String s, String[] t) {
        String token = "";
        HashMap<String, String> m = new HashMap<>();
        String dec[] = s.split("&");
        for (int i = 0; i < dec.length; i++) {
            if (i == 0) {
                String x[] = dec[i].split("\\?");
                String p[] = x[1].split("=");
                token = p[1];
            } else {
                String x[] = dec[i].split("=");
                if (x.length == 2) {
                    m.put(x[0], x[1]);
                }
            }
        }

        if (Arrays.asList(t).contains(token)) {
            if (s.startsWith("POST")) {
                if (m.containsKey("csrf") && m.get("csrf").length() <= 8) {
                    return construct(m);
                } else {
                    return "INVALID";
                }
            } else {
                return construct(m);
            }
        } else {
            return "INVALID";
        }
    }

    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int m=sc.nextInt();
        String tokens[] = new String[5];
        tokens[0]="acg71288bybi";
        tokens[1]="rkifz4hkzy3k";
        tokens[2]="1ezzh1gyfswh";
        tokens[3]="hrmkv5b1f7qr";
        tokens[4]="mvf1pk83na47";
        String url[] =new String[3];
        url[0]="GET,https://example.com?token=mvf1pk83na47&id=0x6&name=xmit";
        url[1]="POST,https://example.com?token=rkifz4hkzy3k&id=int&name=7ad6";
        url[2]="POST,https://example.com?token=1ezzh1gyfswh&id=u82&name=tu7d&csrf=kx0ccyvu";
        // for(int i=0;i<n;i++) tokens[i]=sc.next();
        // for(int i=0;i<m;i++) url[i]=sc.next();

        for (int i = 0; i < url.length; i++) {
            System.out.println(extract(url[i], tokens));
        }
    }
}

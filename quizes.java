import java.util.*;
public class quizes {
    public static  int ans=0;
    public static ArrayList<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private static ArrayList<String> helper(int n, int length) {
        if (n == 0) return new ArrayList<>( Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        ans++;
        ArrayList<String> prev = helper(n - 2, length);
        ArrayList<String> result = new ArrayList<>();
        for (String s : prev) {
            if (n != length) result.add("0" + s + "0");
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
            result.add("8" + s + "8");
        }
        return result;
    }
    public static void main(String... $args){
        findStrobogrammatic(4);
        System.out.println(ans);
    }
}

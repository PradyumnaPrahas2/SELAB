import java.util.*;

public class AdditiveNumber {

    public static boolean isAdditiveNumber = false;

    // Helper function for backtracking
    public static void backtrack(int first, int second, String s, int idx) {
        // If we've reached the end of the string, it means it's a valid sequence
        if (idx == s.length()) {
            isAdditiveNumber = true;
            return;
        }

        // Form the next number by summing the first two
        String sumStr = String.valueOf(first + second);
        
        // If the remaining string doesn't start with the sum, return early
        if (!s.startsWith(sumStr, idx)) {
            return;
        }

        // Recursively check for the next part of the string
        backtrack(second, first + second, s, idx + sumStr.length());
    }

    // Main function to check the string
    public static void helper(String s) {
        if (s.length() < 3) {
            return;
        }

        // Try all possible splits for the first two numbers
        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);

                // Skip invalid parts with leading zeros
                if ((s1.length() > 1 && s1.charAt(0) == '0') || (s2.length() > 1 && s2.charAt(0) == '0')) {
                    continue;
                }

                // Convert to integers and start backtracking
                backtrack(Integer.parseInt(s1), Integer.parseInt(s2), s, j);

                // If we've found a solution, exit the loops
                if (isAdditiveNumber) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        
        helper(x);
        
        System.out.println(isAdditiveNumber);  // Output true if it's an additive number, false otherwise
    }
}

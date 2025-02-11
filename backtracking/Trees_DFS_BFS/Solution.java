package backtracking.Trees_DFS_BFS;
import java.util.*;

public class Solution {
    public static HashSet<String> set = new HashSet<>();
    public static int ans = Integer.MAX_VALUE;
    public static HashMap<Integer, ArrayList<Integer>> Connections = new HashMap<>();
    
    static {
        for (int i = 1; i < 9; i++) {
            Connections.put(i, new ArrayList<>(Arrays.asList(i + 1, i - 1)));
        }
        Connections.put(9, new ArrayList<>(Arrays.asList(0, 8)));
        Connections.put(0, new ArrayList<>(Arrays.asList(1, 9)));
    }

    public static int bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> movesMap = new HashMap<>();
        
        queue.add(start);
        visited.add(start);
        movesMap.put(start, 0);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            int moves = movesMap.get(str);
            
            // If the target is reached, return the number of moves
            if (str.equals(target)) {
                return moves;
            }

            // Explore all digits
            for (int i = 0; i < 4; i++) {
                String left = "";
                if (i > 0) left = str.substring(0, i);
                String right = "";
                if (i + 1 < 4) right = str.substring(i + 1);
                int curr = str.charAt(i) - '0';

                // Explore all possible child digits based on the connection map
                for (int child : Connections.get(curr)) {
                    String newStr = left + child + right;
                    if (!visited.contains(newStr) && !set.contains(newStr)) {
                        visited.add(newStr);
                        queue.add(newStr);
                        movesMap.put(newStr, moves + 1);
                    }
                }
            }
        }
        
        return -1; // Target not reachable
    }

    public static void main(String... args) {
        try {
            Scanner x = new Scanner(System.in);
            String[] trap = x.nextLine().split(" ");
            for (String s : trap) {
                set.add(s);
            }
            String strtofind = x.nextLine();
            String start = "0000";

            int result = bfs(start, strtofind);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(0);
        }
    }
}

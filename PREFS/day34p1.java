/*
CONCEPT-> BACKTRACKING
 * Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
	- All the letters of the word W, should be adjacent to each other 
	in the array Letters(either horizontal or vertical).
	- You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false

 */

package PREFS;

import java.util.*;

public class day34p1 {
    public static boolean explore_nodes(char[][] board,int i,int j,int idx,String word){
        if(idx>=word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx)){
            return false;
        }
        board[i][j]='?';
        
        boolean res= explore_nodes(board,i+1,j,idx+1,word)||explore_nodes(board,i,j+1,idx+1,word)||explore_nodes(board,i-1,j,idx+1,word)||explore_nodes(board,i,j-1,idx+1,word);
        
        board[i][j]=word.charAt(idx);
        return res;
    }
    
    public static boolean canuFind(char[][] board,String word){
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(explore_nodes(board,i,j,0,word)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        char[][] board=new char[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=sc.next().charAt(0);
            }
        }
        sc.nextLine();
        
        String word=sc.nextLine();
        
        System.out.print(canuFind(board,word));
    }
}

import java.util.*;
class TreeNode{
    public int val;
    public TreeNode(int val){
        this.val=val;
        left=null;
        right=null;
    }
    public TreeNode left;
    public TreeNode right;
}
public class lonelynodes{
    
    public static void findLonely(TreeNode root,PriorityQueue<Integer> min){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right!=null){
            min.add(root.right.val);
        }
        if(root.left!=null && root.right==null){
            min.add(root.left.val);
        }
        findLonely(root.left,min);
        findLonely(root.right,min);
    }
    
    public static PriorityQueue<Integer> lonelyNodes(TreeNode root){
        PriorityQueue<Integer> min=new PriorityQueue<>();
        
        findLonely(root,min);
        
        return min;
    }
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String str[]=sc.nextLine().split(" ");
        
        if(str.length==0){
            return;
        }
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        
        Queue<TreeNode> q=new LinkedList<>();
        int i=0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode top=q.poll();
            
            if(i+1<str.length){
                int v=Integer.parseInt(str[i+1]);
                if(v!=-1){
                    top.left=new TreeNode(v);
                    q.add(top.left);
                }
            }
            i++;
            if(i+1<str.length){
                int v=Integer.parseInt(str[i+1]);
                if(v!=-1){
                    top.right=new TreeNode(v);
                    q.add(top.right);
                }
            }
            i++;
        }
        System.out.print(lonelyNodes(root));
        
    }
}

         11
    99        88
   77     -1   -1    66 
  55 -1 -1 -1 -1 -1 -1 44
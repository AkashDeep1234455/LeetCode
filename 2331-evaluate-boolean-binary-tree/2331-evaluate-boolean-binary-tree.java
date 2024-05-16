/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public static void evaluateTreeHelper(TreeNode root,int ans){
        if(root.left==null&&root.right==null) return;
        evaluateTreeHelper(root.left,ans);
        evaluateTreeHelper(root.right,ans);
        if(root.val==2){
            root.val= root.left.val|root.right.val;
        }else{
            root.val = root.left.val&root.right.val;
        }
    }
    public boolean evaluateTree(TreeNode root) {
          evaluateTreeHelper(root,0);
          if(root.val==1) return true;
          return false;
    }
}
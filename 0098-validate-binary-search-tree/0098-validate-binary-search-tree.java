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
    public static boolean helper(TreeNode root,Integer max,Integer min){
        if(root==null) return true;
        
        int rootValue = root.val;

        if(min!=null&&min>=rootValue) return false;
        if(max!=null&&max<=rootValue) return false;
        return helper(root.left,rootValue,min)&&helper(root.right,max,rootValue); 
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
}
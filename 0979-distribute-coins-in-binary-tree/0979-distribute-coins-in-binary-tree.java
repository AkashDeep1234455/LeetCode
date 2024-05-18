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
    private int totalMoves = 0;
     public int distributeCoinsHelper(TreeNode root){
         if(root==null) return 0;
        int leftBalance = distributeCoinsHelper(root.left);
        int rightBalance = distributeCoinsHelper(root.right);
        
        totalMoves += Math.abs(leftBalance)+Math.abs(rightBalance);
        return root.val+leftBalance+rightBalance-1;
    }
    public int distributeCoins(TreeNode root) {
         distributeCoinsHelper(root);
         return totalMoves;
    }
}
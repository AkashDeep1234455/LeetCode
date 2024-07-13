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
    public void helper(TreeNode root,int targetSum,int sum[]){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            sum[0]+=root.val;
            if(sum[0]==targetSum){
                sum[1] = 1;
            }
            sum[0]-=root.val;
            return;
        }
        sum[0]+=root.val;
        helper(root.left,targetSum,sum);
        helper(root.right,targetSum,sum);
        sum[0]-=root.val;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int[] output = new int [2];
        helper(root,targetSum,output);
        if(output[1]==1) return true;
        return false;
    }
}
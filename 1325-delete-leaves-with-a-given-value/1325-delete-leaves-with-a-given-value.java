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
     public static TreeNode removeTargetedLeafNodeHelper(TreeNode root,int target){
        if(root==null) return null;
        root.left = removeTargetedLeafNodeHelper(root.left,target);
        root.right = removeTargetedLeafNodeHelper(root.right,target);
        if(root!=null&&root.left==null&&root.right==null&&root.val==target){
            return null;
        }
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeTargetedLeafNodeHelper(root,target);
    }
}
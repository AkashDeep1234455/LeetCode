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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        int count = 1;
        while(!pendingNodes.isEmpty()){
            TreeNode curr = pendingNodes.poll();
            if(curr.left!=null) {
                pendingNodes.add(curr.left);
                count++;
            }
            if(curr.right!=null) {
                pendingNodes.add(curr.right);
                count++;
            }
        }
        return count;
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        List<List<Integer>> output = new LinkedList<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            int size = pendingNodes.size();
            List<Integer> input = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = pendingNodes.poll();
                input.add(curr.val);
                if(curr.left!=null) pendingNodes.add(curr.left);
                if(curr.right!=null) pendingNodes.add(curr.right);
            }
            output.add(input);
        }
        return output;
    }
}
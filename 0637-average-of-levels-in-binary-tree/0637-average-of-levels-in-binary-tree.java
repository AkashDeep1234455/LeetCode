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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new LinkedList<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            double size = pendingNodes.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = pendingNodes.poll();
                if(curr.left!=null) pendingNodes.add(curr.left);
                if(curr.right!=null) pendingNodes.add(curr.right);
                sum+=curr.val;
            }
            double average = sum/size;
            output.add(average);
        }
        return output;
    }
}
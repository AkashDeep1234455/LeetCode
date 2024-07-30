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
    public static void nodeFinder(TreeNode root,List<Integer> nodes){
        if(root==null) return;
        nodes.add(root.val);
        nodeFinder(root.left,nodes);
        nodeFinder(root.right,nodes);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        nodeFinder(root,nodes);
        Collections.sort(nodes);
        int min = Integer.MAX_VALUE;
        for(int i=0,j=1;j<nodes.size();i++,j++){
            min = Math.min(min,Math.abs(nodes.get(i)-nodes.get(j)));
        }
        return min;
    }
}
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new LinkedList<>();
        nodeFinder(root,nodes);
        Collections.sort(nodes);
        return nodes.get(k-1);
    }
}
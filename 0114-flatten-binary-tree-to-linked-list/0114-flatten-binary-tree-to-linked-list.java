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
    public void iterator(TreeNode root,ArrayList<TreeNode> list){
        if(root==null) return;
        list.add(root);
        iterator(root.left,list);
        iterator(root.right,list);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> list = new ArrayList<>();
        iterator(root,list);
        TreeNode current = root;
        for(int i=1;i<list.size();i++){
            current.left = null;
            current.right = list.get(i);
            current = list.get(i);
        }
    }
}
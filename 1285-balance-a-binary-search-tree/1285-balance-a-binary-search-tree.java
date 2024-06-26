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
     public static void nodeFinder(TreeNode root,ArrayList<Integer>nodes){
        if(root==null) return;
        nodeFinder(root.right,nodes);
        nodes.add(root.val);
        nodeFinder(root.left,nodes);
    }
    public static TreeNode TreeBalancer(ArrayList<Integer>nodes,int start,int end){
        if(start>end) return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.right = TreeBalancer(nodes,start,mid-1);
        root.left = TreeBalancer(nodes,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        nodeFinder(root,nodes);
       return TreeBalancer(nodes,0,nodes.size()-1);
    }
}
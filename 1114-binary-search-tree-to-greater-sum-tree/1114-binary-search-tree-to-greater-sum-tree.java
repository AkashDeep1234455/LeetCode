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
       public static void treeTransversal(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        treeTransversal(root.right,list);
        list.add(root.val);
        treeTransversal(root.left,list);
    }
    public static int sum(ArrayList<Integer> list,int data){
        int sum = 0;
        for(int i=0;i<list.size();i++){
           if(list.get(i)<data){
               break;
           }
           sum+=list.get(i);
        }
        return sum;
    }
    public static void replace(ArrayList<Integer> list,TreeNode root){
        if(root==null) return;
        replace(list,root.right);
        int sum = sum(list,root.val);
        root.val = sum;
        replace(list,root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
        treeTransversal(root,list);
        replace(list,root);
        return root;
    }
}
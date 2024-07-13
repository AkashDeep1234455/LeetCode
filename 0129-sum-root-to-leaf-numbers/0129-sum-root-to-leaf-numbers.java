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
    public void helper(TreeNode root,int[] output,StringBuilder input){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            input.append(root.val);
            String n = input.toString();
            int num  = Integer.parseInt(n);
            output[0]+=num;
            input.deleteCharAt(input.length() - 1);
            return;
        }
        input.append(root.val);
        helper(root.left,output,input);
        helper(root.right,output,input);
        input.deleteCharAt(input.length() - 1);

    }
    public int sumNumbers(TreeNode root) {
        int output[] = new int[1];
        helper(root,output,new StringBuilder());
        return output[0];
    }
}
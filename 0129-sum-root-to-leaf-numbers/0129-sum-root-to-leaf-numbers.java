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
    public static void helper(TreeNode root,ArrayList<String> collection,String curr){
        if(root==null) return ;

        curr+=root.val;
        if(root.left==null&&root.right==null){
            collection.add(curr);
            return;
        }
        helper(root.left,collection,curr);
        helper(root.right,collection,curr);
    }
    public int sumNumbers(TreeNode root) {
         ArrayList<String> collection = new ArrayList<>();
        helper(root,collection,"");
        int sum = 0;
        for(int i=0;i<collection.size();i++){
            int value = Integer.parseInt(collection.get(i));
            sum+=value;
        }
        return sum;
    }
}
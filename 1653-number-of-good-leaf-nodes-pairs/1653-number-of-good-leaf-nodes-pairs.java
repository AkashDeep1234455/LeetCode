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
    public static int[] countPairsHelper(TreeNode root,int distance,int[]output){
          if(root==null) return new int[distance+1];
        if(root.left==null&&root.right==null) {
            int leaves[] = new int[distance+1];
            leaves[1] = 1;
            return leaves;
        }
        int[] leftDistance = countPairsHelper(root.left,distance,output);
        int[] rightDistance = countPairsHelper(root.right,distance,output);
        for(int i=1;i<distance;i++){
            for(int j=1;j<distance;j++){
                if(i+j<=distance){
                    output[0] += leftDistance[i]*rightDistance[j];
                }
            }
        }
        int leaves[] = new int[distance+1];
        for(int i=1;i<distance;i++){
            leaves[i+1] = rightDistance[i]+leftDistance[i];
        }
        return leaves;
    }
    public int countPairs(TreeNode root, int distance){
        if(root==null||(root.left==null&&root.right==null)) return 0;
        int output[] = new int[1];
        countPairsHelper(root,distance,output);
        return output[0];
    }
}
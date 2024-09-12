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
    public void helper(int []nums,int start,int end,TreeNode prev,TreeNode head){
        if(start>end) {
            return;
        }
        int mid = (start+end)/2;
        if(prev==null){
            head.val = nums[mid];
            prev = head;
        }
        else if(nums[mid]>prev.val){
            TreeNode right = new TreeNode(nums[mid]);
            prev.right = right;
            prev = right;
        }else{
            TreeNode left = new TreeNode(nums[mid]);
            prev.left = left;
            prev = left;
        }
        helper(nums,start,mid-1,prev,head);
        helper(nums,mid+1,end,prev,head);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode();
        helper(nums,0,nums.length-1,null,head);
        return head;
    }
}
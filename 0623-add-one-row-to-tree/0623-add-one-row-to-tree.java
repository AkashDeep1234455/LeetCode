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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return null;
        Queue<TreeNode> pendingnode= new LinkedList<>();
        Queue<TreeNode> prevNodes = new LinkedList<>();
        pendingnode.add(root);
        int currDepth = 1;
        while(!pendingnode.isEmpty()&&currDepth!=depth){
            int size = pendingnode.size();
            prevNodes = new LinkedList<>();
            while(size!=0){
                TreeNode currNode = pendingnode.poll();
                prevNodes.add(currNode);
                if(currNode.left!=null){
                pendingnode.add(currNode.left);
                }
                if(currNode.right!=null){
                pendingnode.add(currNode.right);
                }
                size--;
            }
            currDepth++;
        }
        while(!prevNodes.isEmpty()){
            TreeNode curr = prevNodes.poll();
            boolean leftCheck = false;
            if(curr.left!=null) leftCheck = true;
            boolean rightCheck = false;
            if(curr.right!=null) rightCheck = true;
            curr.left = new TreeNode(val);
            curr.right = new TreeNode(val);
            if(leftCheck){
                curr.left.left = pendingnode.poll();
            }
            if(rightCheck){
                curr.right.right = pendingnode.poll();
            }
        }
        if(prevNodes.isEmpty()&&depth==1){
            TreeNode exchange = new TreeNode(val);
            exchange.left = pendingnode.poll();
            return exchange;
        }

       return root;
    }
}
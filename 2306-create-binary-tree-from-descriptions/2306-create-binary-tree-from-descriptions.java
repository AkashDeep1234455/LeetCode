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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap();
        HashMap<TreeNode,Boolean> parentExist = new HashMap();
        for(int i=0;i<descriptions.length;i++){
            TreeNode parentNode;
            TreeNode childNode;
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int rightOrLeftChild = descriptions[i][2];
            if(map.containsKey(parent)){
                parentNode = map.get(parent);
            }else{
                parentNode = new TreeNode(parent);
                map.put(parent,parentNode);
            }
            if(map.containsKey(child)){
                childNode = map.get(child);
            }else{
                childNode = new TreeNode(child);
                map.put(child,childNode);
            }
            if(rightOrLeftChild==1) parentNode.left = childNode;
            else parentNode.right = childNode;
            parentExist.put(childNode,true);
            if(!parentExist.containsKey(parentNode)) parentExist.put(parentNode,false);
        }
        for(TreeNode key:parentExist.keySet()){
            if(parentExist.get(key)==false) return key;
        }
        return null;
    }
}
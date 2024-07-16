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
     public static boolean dirnFinder(TreeNode root,int dest,ArrayList<TreeNode>path){
        if(root==null) return false;
        path.add(root);

        if(root.val==dest) return true;

        if(dirnFinder(root.left,dest,path)) return true;
        if(dirnFinder(root.right,dest,path)) return true;
        path.remove(path.size()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> rootToStart = new ArrayList();
        dirnFinder(root,startValue,rootToStart);
        ArrayList<TreeNode> rootToDest = new ArrayList();
        dirnFinder(root,destValue,rootToDest);

        ///finding root
        int rootIndex=0;
        for(int i=0;i<rootToStart.size()&&i<rootToDest.size();i++){
            if(rootToStart.get(i)==rootToDest.get(i)) rootIndex = i;
        }
        StringBuilder output = new StringBuilder();
        TreeNode outputRoot = rootToStart.get(rootIndex);
        for(int i=rootIndex+1;i<rootToStart.size();i++){
            output.append('U');
        }
        for(int i=rootIndex+1;i<rootToDest.size();i++){
            TreeNode curr = rootToDest.get(i);
            if(outputRoot.left==curr) output.append('L');
            else output.append('R');
            outputRoot = curr;
        }
        return output.toString();
    }
}
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
      public static void helperDel(TreeNode root,List<TreeNode>list,HashMap<Integer,Integer> map){
        if(root==null) return;
        helperDel(root.left,list,map);
        helperDel(root.right,list,map);
        if(map.containsKey(root.val)) {
            if(root.left!=null&&!map.containsKey(root.left.val)) list.add(root.left);
            if(root.right!=null&&!map.containsKey(root.right.val)) list.add(root.right);
        }
        if(root.left!=null&&map.containsKey(root.left.val)){
            root.left = null;
        }
        if(root.right!=null&&map.containsKey(root.right.val)){
            root.right = null;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<to_delete.length;i++){
            map.put(to_delete[i],1);
        }
        List<TreeNode> list = new ArrayList<>();
        if(!map.containsKey(root.val)) list.add(root);
        helperDel(root,list,map);
        return list;
    }
}
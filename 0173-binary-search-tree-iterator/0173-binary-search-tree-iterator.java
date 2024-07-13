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
class BSTIterator {
    private TreeNode root;
    private Stack<TreeNode> rightRoots;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.rightRoots = new Stack<>();
        smallestFinder(root);
    }
    private void smallestFinder(TreeNode root){
        if(root==null) return;
        smallestFinder(root.right);
        rightRoots.push(root);
        smallestFinder(root.left);
    }


    public int next() {
        if(!rightRoots.isEmpty()) return rightRoots.pop().val;
        return -1;
    }
    
    public boolean hasNext() {
        if(!rightRoots.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
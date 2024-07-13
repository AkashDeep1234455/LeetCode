/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            int size = pendingNodes.size();
            for(int i=0;i<size;i++){
                Node curr = pendingNodes.poll();
                if (i == size - 1) {
                    curr.next = null;
                } else {
                    curr.next = pendingNodes.peek();
                }
                if(curr.left!=null) pendingNodes.add(curr.left);
                if(curr.right!=null) pendingNodes.add(curr.right);
            }
        }
        return root;
    }
}
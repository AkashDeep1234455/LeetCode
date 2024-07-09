/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         HashMap<Integer,Node> map = new HashMap<>();
        Node copyHead = head;
        int i = 0;
        while (copyHead!=null){
            map.put(i,copyHead);
            i++;
            copyHead = copyHead.next;
        }
        copyHead = head;
        HashMap<Integer,Node> output = new HashMap<>();
        for(int key:map.keySet()){
            Node input = new Node(map.get(key).val);
            if(key==0) {
                output.put(key,input);
                continue;
            }
            output.get(key-1).next = input;
            if(key==i){
                input.next = null;
            }
            output.put(key,input);

        }
        for(int key:map.keySet()){
            Node curr = map.get(key);
            Node random = curr.random;
            int index = 0;
            copyHead = head;
            while (copyHead!=random){
                copyHead = copyHead.next;
                index++;
            }
            Node outputCurr = output.get(key);
            outputCurr.random = output.get(index);
        }

        return output.get(0);
    }
}
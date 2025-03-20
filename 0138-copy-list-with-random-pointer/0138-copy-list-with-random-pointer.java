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
        Node temp = head;
        int i=0;
        while(temp!=null){
            map.put(i,temp);
            temp=temp.next;
            i++;
        }
        temp = head;
        HashMap<Integer,Node> map2 = new HashMap<>();
        for(int key:map.keySet()){
            Node input = new Node(map.get(key).val);
            if(key==0){
                map2.put(key,input);
                continue;
            }
            map2.get(key-1).next = input;
            if(key==i){
                input.next = null;
            }
            map2.put(key,input);
        }
        for(int key:map.keySet()){
            Node curr = map.get(key);
            Node random = curr.random;
            int index = 0;
            temp=head;
            while(temp!=random){
                temp=temp.next;
                index++;
            }
            Node currOutput = map2.get(key);
            currOutput.random = map2.get(index);
        }
        return map2.get(0);
    }
}
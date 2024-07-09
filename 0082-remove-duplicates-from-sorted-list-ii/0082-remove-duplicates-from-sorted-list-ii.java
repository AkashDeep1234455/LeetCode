/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        Deque<ListNode> uniqueList = new LinkedList();
        HashMap<Integer,Boolean> map = new HashMap<>();
        while (head!=null){
            int currVal = head.val;
             if(map.containsKey(currVal)){
                if(!map.get(currVal)){
                map.put(currVal,true);
                uniqueList.pollLast();
                }
            }else{
                map.put(currVal,false);
                ListNode newNode = new ListNode();
                newNode.val = head.val;
                newNode.next = null;
                uniqueList.addLast(newNode);
            }
            head = head.next;
        }
        ListNode next = new ListNode();
        while (!uniqueList.isEmpty()){
            ListNode curr = uniqueList.pollFirst();
            if(head==null) {
                head = curr;
                next = head;
                continue;
            }
            next.next = curr;
            next = curr;
        }
        return head;
    }
}
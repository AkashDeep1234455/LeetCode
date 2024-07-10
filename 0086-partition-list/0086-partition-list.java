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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        Queue<ListNode> small = new LinkedList<>();
        Queue<ListNode> big = new LinkedList<>();
        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x) small.add(temp);
            else big.add(temp);
            temp = temp.next;
        }
        head = null;
        ListNode prev = null;
        ListNode curr = head;
        while(!small.isEmpty()){
            ListNode newNode = small.poll();
            if(head==null) {
                head = newNode;
                curr = head;
                continue;
            }
            curr.next = newNode;
            prev = curr;
            curr = newNode;
        }
        while(!big.isEmpty()){
            ListNode newNode = big.poll();
            if(head==null){
                head = newNode;
                curr = head;
            }else{
                curr.next = newNode;
                curr = newNode; 
            }
        }
        curr.next = null;
        return head;
    }
}
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null) return head;
        ListNode curr = head;
        ListNode prevOfLeft = null;
        ListNode next = head.next;
        int count = 1;
        while(count<=right){
            if(count<left){
                prevOfLeft = curr;
                curr = next;
                next = curr.next;
            }else if(count==right){
                if(prevOfLeft==null){
                    head.next = next;
                    head = curr;
                }else{
                prevOfLeft.next.next = next;
                prevOfLeft.next = curr;
                }
            }
            else{
                ListNode nextOfNext = next.next;
                next.next = curr;
                curr = next;
                next = nextOfNext;
            }
            count++;
        }
        return head;
    }
}
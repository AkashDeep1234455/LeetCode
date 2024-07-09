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
        if(head==null || head.next==null) return head;
        ListNode next = head.next;
        if(next.val==head.val){
            while (next != null && next.val == head.val){
                next = next.next;
            }
            return deleteDuplicates(next);
        }else{
            head.next = deleteDuplicates(next);
            return head;
        }
    }
}
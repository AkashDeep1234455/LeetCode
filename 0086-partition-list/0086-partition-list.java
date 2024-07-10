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
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftHand = left;
        ListNode rightHand = right;
        while(head!=null){
            if(head.val<x){
                leftHand.next = head;
                leftHand = leftHand.next;
            }else{
                rightHand.next = head;
                rightHand = rightHand.next;
            }
            head = head.next;
        }
        leftHand.next = right.next;
        rightHand.next = null;
        return left.next;
    }
}
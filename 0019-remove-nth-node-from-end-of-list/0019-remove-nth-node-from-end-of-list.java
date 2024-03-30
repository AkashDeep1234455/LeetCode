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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int index = 0;
        int size = 0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp = head;
        n = size-n;
        if(n==0) return head.next;
        while(temp!=null){
            if(index == n-1){
                temp.next  =temp.next.next;
                break;
            }
            temp = temp.next;
            index++;
        }
        return head;
    }
}
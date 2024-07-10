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
    public int size(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        int size = size(head);
        if(size==k) return head;
        if(size<k){
            k = k%size;
        }
        while(k!=0){
            ListNode temp = head;
            ListNode prev = null;
            while(temp.next!=null){
                prev=temp;
                temp = temp.next;
            }
            prev.next = null;
            temp.next = head;
            head = temp;
            k--;
        }
        return head;
    }
}
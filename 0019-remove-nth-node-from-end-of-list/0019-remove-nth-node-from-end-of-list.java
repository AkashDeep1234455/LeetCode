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
        if(head==null) return 0;
        return 1+ size(head.next);
    }
    public void delete(ListNode temp,int index,ListNode prev,int toDelete){
        if(index==toDelete){
            prev.next = temp.next;
            return;
        }
        prev = temp;
        index++;
        delete(temp.next,index,prev,toDelete);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
         ListNode prev = null;
        int length = size(temp);
        int indexToDelete = length-n;
        if(indexToDelete==0) return head.next;
        delete(temp,0,prev,indexToDelete);
        return head;
    }
}
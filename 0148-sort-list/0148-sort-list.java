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
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public ListNode sortList(ListNode head) {
        int size = size(head);
        if(size==0||size==1) return head;
        int arr[] = new int[size];
        ListNode temp = head;
        int index = 0;
        while(temp!=null){
            arr[index] = temp.val;
            index++;
            temp = temp.next;
        }
        Arrays.sort(arr);
        head = new ListNode(arr[0]);
        temp = head;
        for(int i=1;i<size;i++){
            ListNode curr = new ListNode(arr[i]);
            temp.next = curr;
            temp = curr;
        }
        return head;
    }
}
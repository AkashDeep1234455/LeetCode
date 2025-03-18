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
    public int length(ListNode head){
        if(head==null) return 0;
        return 1+length(head.next);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = length(head);
        int arr[] = new int[size];
        int index=0;
        while(head!=null){
            arr[index++] = head.val;
            head=head.next;
        }
        int totalIteration = (size%k)+(size/k);
        int start = 0;
        for(int i=0;i<totalIteration;i++){
            int end = start+k-1;
            int endCopy = end;
            System.out.print(start+" ");
            System.out.println(end);
            if(start+k>size) break;
            while(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            start=endCopy+1;
        }
        ListNode out = new ListNode(arr[0]);
        ListNode temp = out;
        for(int i=1;i<size;i++){
            ListNode curr = new ListNode(arr[i]);
            temp.next = curr;
            temp = curr;
        }
        return out;
    }
}
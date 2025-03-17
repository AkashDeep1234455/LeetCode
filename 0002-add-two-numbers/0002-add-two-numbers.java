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
    public void sum(ListNode l1,ListNode l2,ListNode out,int carry){
        if(l1==null&&l2==null&&carry==1){
            ListNode currNode = new ListNode(carry);
            out.next = currNode;
            out = out.next;
            return;
        }
        if(l1==null&&l2==null) return;
        if(l1==null){
            int sum = l2.val+carry;
            if(sum>9){
                int diff = sum -10;
                ListNode currNode = new ListNode(diff);
                out.next = currNode;
                out = out.next;
                carry =1;
            }else{
                ListNode currNode = new ListNode(sum);
                out.next = currNode;
                out = out.next;
                carry = 0;
            }
            sum(l1,l2.next,out,carry);
        }
        else if(l2==null){
            int sum = l1.val+carry;
            if(sum>9){
                int diff = sum -10;
                ListNode currNode = new ListNode(diff);
                out.next = currNode;
                out = out.next;
                carry =1;
            }else{
                ListNode currNode = new ListNode(sum);
                out.next = currNode;
                out = out.next;
                carry = 0;
            }
            sum(l1.next,l2,out,carry);
        }else{
            int sum = l1.val+l2.val+carry;
            if(sum>9) {
                carry =1;
                int diff = sum - 10;
                ListNode currNode = new ListNode(diff);
                out.next = currNode;
                out = out.next;
            }
            else {
                ListNode currNode = new ListNode(sum);
                out.next = currNode;
                out = out.next;
                carry = 0;
            }
            sum(l1.next,l2.next,out,carry);

        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        int carry = 0;
        ListNode out = output;
        sum(l1,l2,out,carry);
        return output.next;
    }
}
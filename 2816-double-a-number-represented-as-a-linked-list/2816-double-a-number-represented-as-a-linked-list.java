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
    public ListNode doubleIt(ListNode head) {
         ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        while (temp!=null){
            stack.push(temp.val);
            length++;
            temp = temp.next;
        }
        Stack<Integer> newStack = new Stack<>();
        int carry = 0;
        while (!stack.isEmpty()){
            int curr = stack.pop();
            curr = curr*2;
            curr+=carry;
            carry = 0;
            if(curr>9){
                carry = curr/10;
                curr = curr%10;
            }
            newStack.push(curr);
        }
        if(carry!=0) newStack.push(carry);
        temp = head;

        int index = 0;
        while (!newStack.isEmpty()){
            int curr = newStack.pop();
            if(index>=length){
                ListNode newNode = new ListNode(curr);
                temp.next = newNode;
                temp = newNode;
            }else{
                temp.val = curr;
                if(index!=length-1) temp = temp.next;
            }
            index++;
        }
        return head;
    }
}
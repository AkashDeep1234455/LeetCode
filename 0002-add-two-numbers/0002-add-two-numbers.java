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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> output = new ArrayList();
        int carry = 0;
        while(l1!=null||l2!=null){
            int value1 = 0;
            int value2 = 0;
            if(l1!=null) value1 = l1.val;
            if(l2!=null) value2 = l2.val;
            int sum = value1+value2+carry;
            carry = 0;
            if(sum>9){
                carry = sum/10;
                sum = sum%10;
            }
            ListNode input = new ListNode(sum);
            output.add(input);
            if(l1!=null){
            l1 = l1.next;
            }
            if(l2!=null){
            l2 = l2.next;
            }
        }
        if(carry!=0){
            while(carry!=0){
                int sum = carry%10;
                ListNode input = new ListNode(sum);
                output.add(input);
                carry = carry/10;
            }
        }
        ListNode ansList = output.get(0);
        for(int i=1;i<output.size();i++){
            ListNode nextEle = output.get(i);
            output.get(i-1).next =nextEle;
        }
        return ansList;
    }
}
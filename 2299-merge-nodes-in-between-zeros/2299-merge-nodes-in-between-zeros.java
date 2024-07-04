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
    public ListNode mergeNodes(ListNode head) {
          int sum = 0;
        ListNode output = new ListNode();
        ListNode copy = output;
        while (head!=null){
            if(head.val!=0) sum+=head.val;
            else if (sum!=0){
                if(output.val==0){
                    output = new ListNode(sum);
                    copy = output;
                    sum = 0;
                }else{
                    ListNode nextNode = new ListNode(sum);
                    copy.next = nextNode;
                    copy = nextNode;
                    sum = 0;
                }
            }
            head = head.next;
        }
       
        return output;
    }
}
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
    public ListNode removeNodes(ListNode head) {
          if(head==null) return null;
        Stack<Integer> store = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            store.add(temp.val);
            temp = temp.next;
        }

        Stack<Integer> monotonic = new Stack<>();
        int index = store.size()-1;
        HashSet indexValue = new HashSet<>();
        while (!store.isEmpty()){
            int val = store.pop();
            if(monotonic.isEmpty()) monotonic.push(val);
            else{
                if(monotonic.peek()>val) indexValue.add(index);
                else monotonic.push(val);
            }
            index--;
        }

        index = 0;
        ListNode headCopy = head;
        ListNode prev = null;
        while (headCopy!=null){
            if(indexValue.contains(index)){
                if(headCopy==head){
                    head = head.next;
                    headCopy = head;
                }else{
                    prev.next = headCopy.next;
                    headCopy = headCopy.next;
                }
            }else{
                prev = headCopy;
                headCopy = headCopy.next;
            }

            index++;
        }
        return head;
    }
}
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int output[] = new int[]{-1,-1};

        ///prev
        ListNode prev = null;
        ListNode next = head.next;
        int count = 0;
        //distance Maintainer
        List<Integer> critNode = new ArrayList<>();
        while(next!=null){
            if(prev!=null&&next!=null){
                if(prev.val<head.val&&next.val<head.val){
                    critNode.add(count);
                }else if(prev.val>head.val&&next.val>head.val){
                    critNode.add(count);
                }
            }
            prev = head;
            head = head.next;
            next = head.next;
            count++;
        }
        ///Max Calculation
        if(critNode.size()<2) return output;
        output[1] = critNode.get(critNode.size()-1) - critNode.get(0);
        ///Min Calculation
        for(int first = 0,second=1;second<critNode.size();second++,first++){
            if(output[0]==-1) output[0] = critNode.get(second) - critNode.get(first);
            else output[0] = Math.min(output[0],critNode.get(second) - critNode.get(first));
        }
        return output;
    }
}
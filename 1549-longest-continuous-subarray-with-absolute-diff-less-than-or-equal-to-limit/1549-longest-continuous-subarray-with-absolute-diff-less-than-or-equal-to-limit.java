class Solution {
    public int longestSubarray(int[] nums, int limit) {
         int output = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        for(int right=0,left =0;right<nums.length;right++){
            while (!maxQueue.isEmpty()&&nums[maxQueue.peekLast()]<=nums[right]) maxQueue.pollLast();
            maxQueue.addLast(right);

            while (!minQueue.isEmpty()&&nums[minQueue.peekLast()]>=nums[right]) minQueue.pollLast();
            minQueue.addLast(right);

            while (!minQueue.isEmpty()&&!maxQueue.isEmpty()&&nums[maxQueue.peekFirst()]-nums[minQueue.peekFirst()]>limit){
                left++;
                if(left>minQueue.peekFirst()){
                    minQueue.pollFirst();
                }
                if(left>maxQueue.peekFirst()){
                    maxQueue.pollFirst();
                }
            }
             output = Math.max(output,right-left+1);
        }
        return output;
    }
}
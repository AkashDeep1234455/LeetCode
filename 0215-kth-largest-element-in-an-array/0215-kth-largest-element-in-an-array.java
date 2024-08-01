class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
            max.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            if(i==k-1){
                return max.poll();
            }
            max.poll();
        }
        return 0;
    }
}
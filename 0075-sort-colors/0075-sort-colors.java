class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = pq.poll();
        }
    }
}
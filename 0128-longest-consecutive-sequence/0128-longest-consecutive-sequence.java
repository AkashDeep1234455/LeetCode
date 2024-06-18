class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
         PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int longest = 1;
        int currLongest = 1;
        int firstNum = queue.poll();
        int nextNum = firstNum+1;
        while (!queue.isEmpty()){
            int newNum = queue.poll();
            if(newNum==nextNum){
                currLongest++;
                firstNum = newNum;
                nextNum = firstNum+1;
                longest = Math.max(longest,currLongest);
            } else if (newNum==firstNum) {
                continue;
            } else{
                longest = Math.max(longest,currLongest);
                currLongest = 1;
                firstNum = newNum;
                nextNum = firstNum+1;
            }
        }
        return longest;
    }
}
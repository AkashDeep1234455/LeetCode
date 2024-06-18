class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currLength = 1;
                int currNum = num;
                while (set.contains(currNum+1)){
                    currNum++;
                    currLength++;
                }
                longest = Math.max(longest,currLength);
            }
        }
        return longest;
    }
}
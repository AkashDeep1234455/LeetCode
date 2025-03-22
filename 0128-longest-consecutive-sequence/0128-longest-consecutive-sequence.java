class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int count = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int y = num+1;
                while(set.contains(y)){
                    y++;
                }
                count = Math.max(count,y-num);
            }
        }
        return count;
    }
}
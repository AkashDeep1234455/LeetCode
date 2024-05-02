class Solution {
    public int findMaxK(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(num<0) set.add(num);
        }
        int max = -1;
        for(int num:nums){
            if(num<0) continue;
            else{
                if(set.contains(-num)){
                    if(num>max) max = num;
                }
            }
        }
        return max;
    }
}
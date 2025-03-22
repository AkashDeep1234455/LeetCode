class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOne = 0;
        int output = 0;
        for(int num:nums){
            if(num==1) {
                countOne++;
                output = Math.max(output,countOne);
            }else countOne = 0;
        }
        return output;
    }
}
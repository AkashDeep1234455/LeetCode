class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int ans = 0;
        for(int num:nums){
            for(int num2:nums){
                int xor = num^num2;
                if(xor>ans&&Math.abs(num-num2)<=Math.min(num,num2)){
                    ans = xor;
                }
            }
        }
        return ans;
    }
}
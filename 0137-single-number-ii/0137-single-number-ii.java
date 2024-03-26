class Solution {
    public int singleNumber(int[] nums) {
        int [] bits = new int[32];
        for(int i=0;i<nums.length;i++){
            int number = nums[i];    
            for(int j=0;j<32;j++){
                if(((number>>j)&1)==1){
                    bits[j]++;
                }
            }
        }
        int res = 0;
        for(int i=0;i<32;i++){
            if(bits[i]%3!=0){
                res |= (1<<i);
            }
        }
        return res;
    }
}
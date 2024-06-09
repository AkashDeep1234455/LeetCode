class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0,output = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder = sum%k;
            if(remainder==0) output++;
            if(remainder<0) remainder+=k;
            if(map.containsKey(remainder)){
                output+=map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return output;
    }
}
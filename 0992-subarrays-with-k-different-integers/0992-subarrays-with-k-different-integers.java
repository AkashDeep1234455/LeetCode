class Solution {
     public static int subarraysWithKDistinctHelper(int[]nums,int k){
        int count = 0;
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int right=0,left = 0;right<nums.length;right++){
            set.put(nums[right],set.getOrDefault(nums[right],0)+1);
            while (set.size()>k&&left<=right){
                set.put(nums[left],set.get(nums[left])-1);
                if(set.get(nums[left])==0) set.remove(nums[left]);
                left++;
            } 
            count += right - left +1;  
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Math.abs(subarraysWithKDistinctHelper(nums,k) -subarraysWithKDistinctHelper(nums,k-1));
    }
}
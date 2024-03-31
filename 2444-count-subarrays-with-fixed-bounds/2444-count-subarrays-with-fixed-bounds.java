class Solution {
     public static long helper(int[]nums,int leftRange,int rightRange,int minK,int maxK){
        long size = rightRange-leftRange;
        long min = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        long max = Integer.MIN_VALUE;
        long count = 0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int right=leftRange,left=leftRange;right<rightRange;right++){
            int currValue = nums[right];
            map.put(currValue,map.getOrDefault(currValue,0)+1);
            if (currValue>max){
                max = currValue;
                maxIndex = right;
            }
            if(currValue<min){
                min = currValue;
                minIndex = right;
            }
            if(map.containsKey(minK)&&map.containsKey(maxK)&&min ==minK&&max==maxK){
                while (map.containsKey(minK)&&map.containsKey(maxK)){
                    map.put(nums[left],map.get(nums[left])-1);
                    if(map.get(nums[left])==0) map.remove(nums[left]);
                    left++;
                }
                if(left>minIndex&&left<size){
                    min = nums[left];
                    minIndex = left;
                }
                if(right>maxIndex&&left<size){
                    max = nums[left];
                    maxIndex = left;
                }
            }
            count +=right-left+1;
        }
        long totalSubArray = (size*(size+1))/2;

        return totalSubArray- count;
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans  = 0;
        long size = nums.length;
        long totalSubArray = (size*(size+1))/2;
        int count = 0;
        for(int i=0;i<size;i++){
            if(nums[i]>maxK) nums[i] = -1;
            if(nums[i]<minK) nums[i] = -1;
        }
        int leftCopy = 0;
        for(int right=0,left = 0;right<size;right++) {
            if (nums[right] == -1) {
                ans += helper(nums, left, right, minK, maxK);
                left = right + 1;
            }
            if (right == size-1 && left <= right) {
                ans += helper(nums, left, right+1, minK, maxK);
            }
        }
       return ans;
    }
}
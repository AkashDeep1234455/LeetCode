class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(target==Integer.MAX_VALUE||target==Integer.MIN_VALUE) return new LinkedList<>();
        List<List<Integer>> output = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                int left = j+1;
                int right=nums.length-1;
                long sum = 0;
                while(left<right){
                    sum =(long) nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else if(sum==target){
                        List<Integer> input = new LinkedList<>();
                        input.add(nums[i]);
                        input.add(nums[j]);
                        input.add(nums[left]);
                        input.add(nums[right]);
                        output.add(input);
                        left++;
                        right--;
                        while(left<nums.length&&nums[left-1]==nums[left]) left++;
                        while(right>0&&nums[right+1]==nums[right]) right--;
                    }
                }
            }
        }
        return output;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right = nums.length-1;
            int sum = 0;
            while(left<right&&left<nums.length&&right>=0){
                sum = nums[i]+nums[left]+nums[right];
                if(i==left||left==right||right==i) break;
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else if(sum==0){
                    List<Integer> input = new LinkedList<>();
                    input.add(nums[i]);
                    input.add(nums[left]);
                    input.add(nums[right]);
                    output.add(input);
                    left++;
                    right--;
                    while(left<nums.length&&nums[left-1]==nums[left]){
                        left++;
                    }
                    while(right>0&&nums[right+1]==nums[right]){
                        right--;
                    }
                }

            }
        }
        return output;
    }
}
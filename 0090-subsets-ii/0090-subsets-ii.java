class Solution {
    private void subsetFinder(List<List<Integer>> subset,int index,int []nums,List<Integer>input){
        subset.add(new ArrayList<>(input));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            input.add(nums[i]);
            subsetFinder(subset,i+1,nums,input);
            input.remove(input.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        Arrays.sort(nums);
        subsetFinder(subset,0,nums,new ArrayList<>());
        return subset;

    }
}
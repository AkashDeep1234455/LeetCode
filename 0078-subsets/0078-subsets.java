class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         int length = nums.length;
        int result = 0;
        int index = 0;
       List<List<Integer>> subset = new ArrayList<>();
       subset.add(new ArrayList<>());
       for(int i=0;i<length;i++){
           int size = subset.size();
           for(int j=0;j<size;j++){
               ArrayList<Integer> res = new ArrayList<>(subset.get(j));
               res.add(nums[i]);
               subset.add(res);
           }
       }
       return subset;
    }
}
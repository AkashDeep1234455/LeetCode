class Solution {
    public int subsetXORSum(int[] nums) {
          int length = nums.length;
        int result = 0;
        int index = 0;
       ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
       subset.add(new ArrayList<>());
       for(int i=0;i<length;i++){
           int size = subset.size();
           for(int j=0;j<size;j++){
               ArrayList<Integer> res = new ArrayList<>(subset.get(j));
               res.add(nums[i]);
               subset.add(res);
           }
       }



           for(int j=0;j<subset.size();j++){
               ArrayList<Integer> sub = subset.get(j);
               int xor = 0;
               for(int k=0;k<sub.size();k++){
                   xor = xor^sub.get(k);
               }
               result+=xor;
           }


return result;
    }
}
class Solution {
    public int subsetXORSum(int[] nums) {
               int length = nums.length;
        int result = 0;
        int index = 0;
       ArrayList<ArrayList<Integer>> subset[] = new ArrayList[length];

       for(int i=length-1;i>=0;i--){
           ArrayList<ArrayList<Integer>> currSubset = new ArrayList<>();
           if(i==length-1){
               ArrayList<Integer> input = new ArrayList<>();
               input.add(nums[i]);
               currSubset.add(input);
           }else {
               for (int j = i; j < length; j++) {
                   if (j == i) {
                       ArrayList<Integer> input = new ArrayList<>();
                       input.add(nums[i]);
                       currSubset.add(input);
                   }else {
                       ArrayList<ArrayList<Integer>> obtained = subset[j];
                       for (int k = 0; k < obtained.size(); k++) {
                           ArrayList<Integer> present = new ArrayList<>(obtained.get(k));
                           present.add(nums[i]);
                           currSubset.add(present);
                       }
                   }
               }
           }
           subset[i] = currSubset;
       }

       for(int i=0;i<subset.length;i++){
           ArrayList<ArrayList<Integer>> curr = subset[i];
           for(int j=0;j<curr.size();j++){
               ArrayList<Integer> sub = curr.get(j);
               int xor = 0;
               for(int k=0;k<sub.size();k++){
                   xor = xor^sub.get(k);
               }
               result+=xor;
           }
       }

return result;
    }
}
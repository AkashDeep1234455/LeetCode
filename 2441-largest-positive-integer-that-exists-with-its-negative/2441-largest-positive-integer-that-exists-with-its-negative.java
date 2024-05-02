class Solution {
    public int findMaxK(int[] nums) {
         ArrayList<Integer> list =new ArrayList<>();
        for(int num:nums){
            if(num<0) list.add(num);
        }
        int max = -1;
        for(int num:nums){
            if(num<0) continue;
            else{
                if(list.contains(-num)){
                    if(num>max) max = num;
                }
            }
        }
        return max;
    }
}
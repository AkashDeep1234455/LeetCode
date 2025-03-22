class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(!set.contains(curr)){
                set.add(curr);
                map.put(i,curr);
            }
        }
        int k = 0;
        for(int key:map.keySet()){
            nums[k] = map.get(key);
            k++;
        }
        return k;
    }
}
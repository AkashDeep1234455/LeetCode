class Solution {
    public int beautifulSubsets(int[] nums, int k) {
         List<List<Integer>> subset = new ArrayList<>();
        subsetHelper(nums, subset, 0, new ArrayList<>(), k);
        return subset.size();
    }
    public static void subsetHelper(int[] nums, List<List<Integer>> subset, int start, List<Integer> temp, int k) {
        if (!temp.isEmpty()) {
            subset.add(new ArrayList<>(temp));  // Add non-empty subset
        }
        
        for (int i = start; i < nums.length; i++) {
            boolean canAdd = true;
            for (int num : temp) {
                if (Math.abs(nums[i] - num) == k) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                temp.add(nums[i]);
                subsetHelper(nums, subset, i + 1, temp, k);
                temp.remove(temp.size() - 1);  // Backtrack
            }
        }
    }
}
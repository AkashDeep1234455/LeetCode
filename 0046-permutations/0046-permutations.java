import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void helper(List<List<Integer>> num, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            num.add(new ArrayList<>(temp)); // Add a copy of temp
        } else {
            for (int i = 0; i < nums.length; i++) { // Iterate over nums.length
                if (temp.contains(nums[i])) continue; // Skip if already included
                temp.add(nums[i]); // Add the number to the current permutation
                helper(num, temp, nums); // Recurse
                temp.remove(temp.size() - 1); // Backtrack
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>(); // Use ArrayList instead of LinkedList
        helper(output, new ArrayList<>(), nums);
        return output;
    }
}

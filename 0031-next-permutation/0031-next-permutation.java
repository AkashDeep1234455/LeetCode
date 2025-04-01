import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int first = -1;
        
        // Step 1: Find the first decreasing element from the right
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                first = i;
                break;
            }
        }

        // If no such element is found, reverse the array (smallest permutation)
        if (first == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find the next larger element to swap
        int second = -1;
        for (int i = nums.length - 1; i > first; i--) {
            if (nums[i] > nums[first]) {
                second = i;
                break;
            }
        }

        // Step 3: Swap first and second
        swap(nums, first, second);

        // Step 4: Reverse the elements after 'first' to get the next lexicographical order
        reverse(nums, first + 1, nums.length - 1);
    }

    // Helper function to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse elements in a given range
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

class Solution {
    public int minSwaps(int[] nums) {
        int noOfOne = 0;
        for (int num : nums) {
            if (num == 1) noOfOne++;
        }
        
        // Edge case: If there are no 1s, no swaps are needed
        if (noOfOne == 0) return 0;
        
        int n = nums.length;
        int minSwaps = Integer.MAX_VALUE;
        int currentZeros = 0;
        
        // Count zeros in the first window of size `noOfOne`
        for (int i = 0; i < noOfOne; i++) {
            if (nums[i] == 0) currentZeros++;
        }
        minSwaps = currentZeros;
        
        // Slide the window over the array in a circular manner
        for (int i = 1; i < n; i++) {
            // Remove the influence of the element that goes out of the window
            if (nums[(i - 1) % n] == 0) currentZeros--;
            // Add the influence of the new element that comes into the window
            if (nums[(i + noOfOne - 1) % n] == 0) currentZeros++;
            
            minSwaps = Math.min(minSwaps, currentZeros);
        }
        
        return minSwaps;
    }
}

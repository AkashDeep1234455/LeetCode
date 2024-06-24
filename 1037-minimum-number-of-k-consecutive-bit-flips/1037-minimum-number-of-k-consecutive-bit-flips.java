class Solution {
    public int minKBitFlips(int[] nums, int k) {
            int n = nums.length;
        int flips = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove the elements from the deque that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Determine if we need to flip at the current position
            if (deque.size() % 2 == nums[i]) {
                // If we need to flip but cannot, return -1
                if (i + k > n) {
                    return -1;
                }

                // Record the flip by adding the current index to the deque
                deque.addLast(i);
                flips++;
            }
        }

        return flips;
    }
}
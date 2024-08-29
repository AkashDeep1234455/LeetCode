class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        int pivotPoint = start;
        start = 0; 
        end = nums.length - 1;
        
       
        if (target >= nums[pivotPoint] && target <= nums[end]) {
            start = pivotPoint;
        } else {
            end = pivotPoint - 1;
        }
        
      
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        
        return -1;
    }
}

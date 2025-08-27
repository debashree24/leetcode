class Solution {
    public int findMin(int[] nums) {
        // O(log n)means do binary search
        // if it is rotated n times or no times the first element will be the smallest
        int left = 0; int right = nums.length -1;
        if(nums[left] <= nums[right]) //means it got rotated n no of times or 0 times
            return nums[left];
        while (left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) // means the roatated smaller values must be to the right of mid
                left = mid + 1;
            else
                right = mid;

        }
        return nums[left];
    }
}
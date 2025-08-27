class Solution {
    public int search(int[] nums, int target) {
        //binary search
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                return mid;//target reached
            }

            if(nums[left] <= nums[mid]){//left side is sorted
                if(nums[left] <= target && target < nums[mid]){//target is in left side
                    right = mid - 1;//narrowing window
                }else{
                    left = mid + 1;//shrinking window
                }
            }else{//right side is sorted
                if(nums[mid]  < target && target <= nums[right]){//target is in right side
                    left = mid + 1;//shrinking window
                }else{
                    right = mid - 1;//narrowing window
                }
            }
        }
        return -1;//target not found
    }
}
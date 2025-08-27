class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //min subarray > sliding window > left & right pointer same side
        int left = 0;
        int sum = 0;
        int minlength = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                int length = right - left + 1;
                minlength = Math.min(minlength,length);
                sum -= nums[left]; //shrinking window
                left++;
            }
        }
        return minlength==Integer.MAX_VALUE ? 0 : minlength;
    }
}
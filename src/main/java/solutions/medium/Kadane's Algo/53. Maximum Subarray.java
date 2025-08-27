class Solution {
    public int maxSubArray(int[] nums) {
        //DP
        //follows the process of memoization
        int currentmax = nums[0];
        int max = nums[0];
        for(int i=1; i < nums.length; i++){
            currentmax = Math.max(nums[i], nums[i]+currentmax);//memoization//keeping track rather than redoing
            max = Math.max(currentmax,max);
        }
        return max;
    }
}
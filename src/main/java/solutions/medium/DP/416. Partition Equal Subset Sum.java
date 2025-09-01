//tabulation
class Solution {
    public boolean canPartition(int[] nums) {
        //
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total % 2 != 0){
            return false;
        }

        boolean[] dp = new boolean[total+1];
        dp[0] = true; //base case

        for(int num : nums){
            for(int j = total/2; j >= num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[total/2];
    }
}
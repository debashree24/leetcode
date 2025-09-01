//recursive solution
//causing TLE
class Solution {
    public int rob(int[] nums) {
        //solving by recursion
        int n = nums.length-1;
        return recursion(n,nums);
    }

    public int recursion(int index, int[] nums){
        //edge case
        if(index==0) return nums[0];
        if(index==-1) return 0;
        int pick = nums[index] + recursion(index-2,nums);
        int nopick = 0 + recursion(index-1,nums);
        return Math.max(pick,nopick);
    }
}

//memoization solution
// Top Down DP (Recursion + Memoization)
class Solution {
    public int rob(int[] nums) {
        //pick no pick startegy
        //memoization
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return recursion(n-1,nums,dp);
    }

    private int recursion(int n, int[] nums, int[] dp){
        //base cases adjustments
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){//meaning this state has already been computed
            return dp[n];
        }

        int pick = nums[n] + recursion(n-2,nums,dp);
        int nopick = 0 + recursion(n-1,nums,dp); ;
        dp[n] = Math.max(pick,nopick);
        return dp[n];
    }
}
//bottom up dp (tabulation)
class Solution {
    public int rob(int[] nums) {
        //pick no pick startegy
        //tabulation
        int n = nums.length;
        //edge cases
        if(n == 0){
            return 0;
        }if(n == 1){
            return nums[0];//single house to rob
        }
        int[] dp = new int[n];
        //base cases
        dp[0] = nums[0]; //one house
        dp[1] = Math.max(nums[0],nums[1]); //two houses
        for(int state = 2; state < n; state++){//rest of the houses
            int pick = nums[state] + dp[state-2];
            int nopick = 0 + dp[state-1] ;
            dp[state] = Math.max(pick,nopick);
        }
        return dp[n-1];
    }
}

//space optimization
class Solution {
    public int rob(int[] nums) {
        //pick no pick startegy
        //tabulation + optimization
        int n = nums.length;
        //edge cases
        if(n == 0){
            return 0;
        }if(n == 1){
            return nums[0];//single house to rob
        }
        //base cases
        int prev2 = 0; // maz prfit 2 houses ago
        int prev1 = nums[0]; //max profit 1 house ago
        int ans = 0;
        for(int state = 1; state < n; state++){//rest of the houses
            int pick = nums[state] + prev2;
            int nopick = 0 + prev1 ;
            ans= Math.max(pick,nopick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}


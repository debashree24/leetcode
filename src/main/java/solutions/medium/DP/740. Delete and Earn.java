//recursion
//causing TLE
class Solution {
    public int deleteAndEarn(int[] nums) {
        //pick no pick strategy
        int n = nums.length-1;
        int maxVal = 0;
        for(int num : nums) {
            maxVal = Math.max(maxVal, num);//finding the maximum value in the array to create the dp array
        }
        int[] values = new int[maxVal + 1];
        for(int n2 : nums) {
            values[n2] += n2;//the new array
        }
        return recursion(maxVal,values);
    }

    public int recursion(int n, int[] values){
        if(n < 0) return 0;
        int pick = values[n] + recursion(n-2,values);
        int nopick = 0 + recursion(n-1,values);
        return Math.max(pick,nopick);//need to maximize earning with the choice
    }
}

//memoization solution
// Top Down DP (Recursion + Memoization)
class Solution {
    public int deleteAndEarn(int[] nums) {
        //pick no pick strategy
        int n = nums.length-1;
        int maxVal = 0;
        for(int num : nums) {
            maxVal = Math.max(maxVal, num);//finding the maximum value in the array to create the dp array
        }
        int[] values = new int[maxVal + 1];
        for(int n2 : nums) {
            values[n2] += n2;//the new array
        }

        int[] dp = new int[maxVal+1];
        Arrays.fill(dp,-1);
        return recursion(maxVal,values,dp);
    }

    public int recursion(int n, int[] values, int[] dp){
        if(n < 0) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick = values[n] + recursion(n-2,values,dp);
        int nopick = 0 + recursion(n-1,values,dp);
        dp[n] = Math.max(pick,nopick);//need to maximize earning with the choice
        return dp[n];
    }
}

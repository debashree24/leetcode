//recursion solution
//causing TLE

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //recursion
        int n = cost.length;
        return recursion(n,cost);

    }

    public int recursion(int n, int[] cost){
        if(n == 0 || n==1) return 0; //no cost needed

        int oneStep = cost[n-1] + recursion(n-1,cost);
        int twoStep = cost[n-2] + recursion(n-2,cost);
        return Math.min(twoStep,oneStep);
    }
}

//memoization solution
// Top Down DP (Recursion + Memoization)
//also TLE
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //recursion
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return recursion(n,cost,dp);

    }

    public int recursion(int n, int[] cost, int[] dp){
        if(n == 0 || n==1) {
            dp[n] = 0;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int oneStep = cost[n-1] + recursion(n-1,cost,dp);
        int twoStep = cost[n-2] + recursion(n-2,cost,dp);
        dp[n] = Math.min(twoStep,oneStep)
        return dp[n] ;
    }
}
//bottom up dp (tabulation)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //tabulation
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int state = 2; state <= n ; state++){
            int oneStep = cost[state-1] + dp[state-1];
            int twoStep = cost[state-2] + dp[state-2];
            dp[state] = Math.min(twoStep,oneStep);
        }
        return dp[n];

    }
}

//space optimization
//bottom up dp (tabulation)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //tabulation
        int n = cost.length;
        int prev2 = 0;
        int prev1 = 0;
        int ans = 0;
        for(int state = 2; state <= n ; state++){
            int oneStep = cost[state-1] + prev1;
            int twoStep = cost[state-2] + prev2;
            ans = Math.min(twoStep,oneStep);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;

    }
}
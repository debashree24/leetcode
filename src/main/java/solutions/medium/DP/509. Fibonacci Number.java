class Solution {
    public int fib(int n) {
        //first handle base case
        if(n <= 1) return n;
        //we will use recursion to solve this DP problem
        return fib(n-1) + fib(n-2);
    }
}

//solve by memoiztion (where we store ans of previous state--------------------------------------------
// Top Down DP (Recursion + Memoization)
class Solution {
    public int fib(int n) {
        //we will use memoization to solve this DP problem
        //memoization basically means save the older states so that we don't have to recalculate
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return recursion(n,dp);
    }

    private int recursion(int n, int dp[]){
        if(n <= 1){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
// Bottom Up DP (Tabulation)--------------------------------------------

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        //we will use tabulation to solve this DP problem
        int dp[] = new int[n+1];
        //smaller sub probelms
        dp[0] = 0;
        dp[1] = 1;
        for(int state = 2; state <= n; state++){
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }
}
//bottom up dp (tabulation) with space optimization--------------------------------------------

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        //we will use tabulation with optimization to solve this DP problem
        //smaller sub probelms
        int prev1 = 1;
        int prev2 = 0;
        int ans = 0;
        for(int state = 2; state <= n; state++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}

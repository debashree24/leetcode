//recursive solution
// causing TLE
class Solution {
    public int climbStairs(int n) {
        //base case or smallest case
        if(n <=2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

//memoization solution
// Top Down DP (Recursion + Memoization)
//also TLE

class Solution {
    public int climbStairs(int n) {
        //base case or smallest case
        if(n <=2) return n;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return recursion(n,dp);
    }

    public int recursion(int n, int dp[]){
        if(n <=2) {
            dp[n] = n;
            return dp[n];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
}

//bottom up dp (tabulation)
class Solution {
    public int climbStairs(int n) {
        //base case or smallest case
        if(n <=2) return n;
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int state = 3; state <= n ; state++){
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }


}

//bottom up dp (tabulation) with space optimization
class Solution {
    public int climbStairs(int n) {
        //base case or smallest case
        if(n <=2) return n;
        int prev2 = 1;
        int prev1 = 2;
        int ans = 0;
        for(int state = 3; state <= n ; state++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }


}
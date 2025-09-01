class Solution {
    public int change(int amount, int[] coins) {
        int max = 0;
        for(int coin : coins){
            max = Math.max(max,coin);
        }
        int[] dp = new int[amount+1];
        dp[0] = 1; //there is exactly 1 way to make the value 0
        for(int coin : coins){
            for(int i = 1; i <= amount; i++){
                if(coin <= i){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];

    }
}
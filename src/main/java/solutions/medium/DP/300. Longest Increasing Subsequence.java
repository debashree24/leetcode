//O(n^2) approach // not recco
class Solution {
    public int lengthOfLIS(int[] nums) {
        //lets create a dp array to store
        int[] dp = new int[nums.length];

        Arrays.fill(dp,1);

        for(int i=1; i < nums.length ; i++){
            for(int j=0; j < i; j++){
                if(nums[i] > nums[j]){{
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                }
            }
        }
        int max = 0;
        for(int i : dp){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
//O(logn) approach // reccomended

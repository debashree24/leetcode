//tabulation
class Solution {
    public int numDecodings(String s) {
        //tabulation
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1; //ie string is empty so there is only one way to decode
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        //if the first digit is 0 then it can't be decoded as there is no alphabet as 0,
        // and if it is any other digit it can be decoded in 1 way only

        for(int i = 2; i <= n ; i++){
            //extracting one digits and 2 digits
            int oneword = Integer.valueOf(s.substring(i-1,i));
            int twoword = Integer.valueOf(s.substring(i-2,i));

            //checking its validity
            if(oneword >=1){
                dp[i] += dp[i-1];
            }
            if(twoword >= 10 && twoword <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
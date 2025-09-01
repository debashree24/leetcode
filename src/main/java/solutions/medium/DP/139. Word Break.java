//memoization solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //copy all the words in list to set for o(1) lookup
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        //next lets find the length of the longest word so that every time we can lookup that much when we start segmenting
        int maxlength = 0;
        for(String word : wordDict){
            maxlength = Math.max(maxlength,word.length());
        }

        //next lets take a boolean dp array to store for every point in the string whether we can segment it
        boolean[] dp = new boolean[n+1];

        //even if s is empty it will be considered segmentable i.e. the base case
        dp[0] = true;

        //now the actual segment search
        for(int i = 1; i<=n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
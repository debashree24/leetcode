class Solution {
    public String longestPalindrome(String s) {
        //better to do with 2 pointer than DP
        //because time complexity in both is O(n^2) but space complexity in 2 pointer is o(1) which is better
        if(s == null || s.length()==0) return "";

        int start = 0; int end = 0;
        for(int i = 0; i < s.length(); i++){
            int length1 = expandaroundcentre(s, i, i); //for an odd length string
            int length2 = expandaroundcentre(s, i, i+1); //for an even length string
            int length = Math.max(length1,length2);
            if(length > end - start){
                start = i - (length - 1)/2;
                end = i + length/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandaroundcentre(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
class Solution {
    public int countSubstrings(String s) {
        //basic checks
        if(s == null || s.length() == 0) return 0;

        int start = 0; int end = 0; int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += expandfromcentre(s,i,i);
            count += expandfromcentre(s,i,i+1);
        }
        return count;
    }

    private int expandfromcentre(String s,int left,int right){
        int count =0;
        while(left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
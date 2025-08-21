class Solution {
    public void reverseString(char[] s) {
        //in place > no extra array > O(1) SC
        int left = 0;
        int right  = s.length - 1;
        while(left < right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] c = s.toCharArray();

        //split the string into chunks of 2k
        for(int i =0; i < n; i += 2*k){
            int left = i;

            // this condition takes care of the need to determine if at the end <k elements ra eleft or not
            int right = Math.min(i+k-1,n-1);

            //this will end up on reversing k characters
            while(left < right){
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }
}
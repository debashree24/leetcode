class Solution {
    public int compress(char[] chars) {
        //2 pointer problem
        //also we need to write to chars itself without using a string, why?
        //constraint : You must write an algorithm that uses only constant extra space. > so no extra data structures

        //left and right are the 2 pointers
        //and another pointer to write to char
        int left = 0;
        int write = 0;
        for(int right = 0; right < chars.length; right++){
            //so you have reached end of string or end of a strech of repeats
            if(right == chars.length -1 || chars[right] != chars[right+1]){
                chars[write++] = chars[left]; //left contains the character to write
                int count = right -left + 1;
                if (count > 1){
                    String s = Integer.toString(count);
                    for(char c : s.toCharArray()){
                        chars[write++] = c;
                    }
                }
                left = right + 1;
            }
        }
        return write;
    }
}
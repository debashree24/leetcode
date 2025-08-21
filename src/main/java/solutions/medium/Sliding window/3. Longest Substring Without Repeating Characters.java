class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Longest Substring Without Repeating Characters > give us an idea of a window that needs to keep moving
        //to find the longest substring
        //we can have 2 pointers left and right
        //keep the right moving forward, an when we hit a repeat make the left move by +1 to pick up the new window and remove the
        //leftmost character from the set
        int left = 0;
        int longestsubstring = 0;
        Set<Character> set = new HashSet();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(set.contains(c)){// need to use while instead of if because you need to keep removing utill c is no more in the set
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            longestsubstring = Math.max(longestsubstring,right - left + 1);
        }
        return longestsubstring;
    }
}
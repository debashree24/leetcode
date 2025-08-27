class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        int maxlength = 0;
        Map<Character,Integer> map = new HashMap();
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.size() > k){
                char c1 = s.charAt(left);
                map.put(c1,map.get(c1)-1);
                if(map.get(c1) == 0){ //if the character is no more present in the window we can remove it from map
                    map.remove(c1);
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}
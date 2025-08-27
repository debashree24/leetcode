class Solution {
    public String minWindow(String s, String t) {
        //Could you find an algorithm that runs in O(m + n) time?
        //meaning we can't nest looop

        //first things first lets first create a map of the characters in t
        Map<Character,Integer> freq = new HashMap();
        for(char c : t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        //necessary initializations
        int uniquecharacters = freq.size(); //this will help in the expansion and shrinking of sliding window
        int windowStart = 0;//left pointer
        int windowEnd = 0;//right pointer
        int startIndex = -1; //did not understand
        int minLength = Integer.MAX_VALUE;
        int n = s.length();

        //now looping through s
        while(windowEnd < n){
            //expansion phase
            char c = s.charAt(windowEnd);
            if(freq.containsKey(c)){
                //here for every character in t found in phase we are removing its freq from map to keep track of the expanded window
                freq.put(c,freq.get(c)-1);
                if(freq.get(c) == 0){
                    uniquecharacters--; //meaning all occurances of one character has been found
                }
            }

            //shrinking phase
            while(uniquecharacters==0){ //meaning all characters (including duplicates) of t has been found for the first time in s
                //length of the window
                int length = windowEnd - windowStart + 1;
                if(length < minLength){
                    minLength = length;
                    startIndex = windowStart; //now it is slided to left pointer marking start of the substring
                }
                c = s.charAt(windowStart);//start shrinking fom start
                if(freq.containsKey(c)){
                    //here for every duplicate character in t found in the window of s
                    freq.put(c,freq.get(c)+1);
                    if(freq.get(c) > 0){
                        uniquecharacters++; //meaning one extra duplicate found so window invalid come out
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        if(startIndex == -1) return "";
        return s.substring(startIndex, startIndex+minLength);

    }
}
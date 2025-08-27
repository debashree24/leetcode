class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //declare
        List<Integer> result = new ArrayList();
        int onewordlength = words[0].length();
        int substringlength = onewordlength * words.length;
        int j = 0;
        //edge cases
        if(s == null || words == null || words.length==0) return result;
        if(s.length() < substringlength) return result;
        //here the challenge is  > susbtring calculation for every iteration
        //adding the freq of all the words in a map
        Map<String,Integer> map = new HashMap();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for(int i = 0; i <= s.length() - substringlength; i++){
            Map<String,Integer> seen = new HashMap<>();
            for(j =0; j < words.length; j++){
                int wordindex = i + j * onewordlength;
                String sub = s.substring(wordindex,wordindex + onewordlength);
                if(!map.containsKey(sub)){
                    break; //the newly formed substring is not even there in words so no use
                }
                seen.put(sub,seen.getOrDefault(sub,0)+1);
                if(seen.get(sub) > map.get(sub)){
                    break; //more than 1 times a word from words appear in s, so again no use
                }
            }
            if(j==words.length) result.add(i);
        }
        return result;
    }
}
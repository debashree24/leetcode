class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int lengthofaoword = words[0].length();
        int concatsubstringlength = lengthofaoword * words.length;
        List<Integer> result = new ArrayList();

        //edge case 1
        if(s.length() < concatsubstringlength) return Collections.emptyList();
        //edge case 2
        if(s == null || words == null || words.length==0) return Collections.emptyList();

        //populate hashmap with words freq
        Map<String,Integer> need = new HashMap();
        for(String word : words){
            need.put(word,need.getOrDefault(word,0)+1);
        }

        //any valid substring must be of length concatsubstringlength and must be composed of lengthofaoword chunks

        for(int offset = 0; offset < lengthofaoword; offset++){ //
            int left = offset;
            int count = 0; //count words currently in the window
            Map<String,Integer> have = new HashMap();

            //expand the window one word at a time
            for(int right = offset; right <= s.length() - lengthofaoword; right += lengthofaoword){
                //break a chunk
                String sub = s.substring(right, right + lengthofaoword);

                //reset the cuurent window as it is of no use
                if(!need.containsKey(sub)){
                    have.clear();
                    count = 0;
                    left = right + lengthofaoword;
                    continue;
                }

                //take the chunked word and add it up
                have.put(sub,have.getOrDefault(sub,0)+1);
                count++;

                //if the word is overused shrink from left until valid
                while(have.get(sub) > need.get(sub)){
                    String leftmostword = s.substring(left,left+lengthofaoword);
                    have.put(leftmostword,have.get(leftmostword)-1);
                    left  = left + lengthofaoword;
                    count--;
                }

                //if we have exactly words.length  words record and slide a word
                if(count == words.length){
                    result.add(left);
                    String leftmostword = s.substring(left,left+lengthofaoword);
                    have.put(leftmostword,have.get(leftmostword)-1);
                    left  = left + lengthofaoword;
                    count--;
                }
            }

        }
        return result;
    }
}
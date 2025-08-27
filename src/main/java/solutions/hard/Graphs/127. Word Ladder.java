class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //this is almost like Open the Lock
        //with the exception that in open the lock we needed to avoid the deadends in the list
        //here transformed words from a -> b must be in the list
        //challenge with this problem ? neighbor genration

        //1) dump the wordlist into a Set so that we can look up words in O(n)
        //also this can be repurposed as visited array by eliminating words from the set after looking them up
        Set<String> set = new HashSet<>(wordList);

        //2) handle edge case
        if(!set.contains(endWord)) return 0; //we will never reach the end

        //3) BFS needs a queue
        Queue<String> q = new LinkedList();

        //4) add the beginword to the queue
        q.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        //5) begin BFS
        int levels = 1;
        //this is needs to get the level count of changes the word went through and
        //we start at 1 becuase we have processed beginWord

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                String current = q.poll();
                //quick break if target achieved
                if(current.equals(endWord)){
                    return levels;
                }

                for(String combination : getCombinations(current,set)){
                    q.offer(combination);
                    set.remove(combination);
                }
            }
            levels++;
        }
        return 0;
    }

    //6) creating adjacency list
    private List<String> getCombinations(String current, Set<String> set){
        List<String> combinations = new ArrayList();
        char[] currentArray = current.toCharArray();
        for(int i = 0; i < current.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c==current.charAt(i)) continue;

                char original = currentArray[i];//backup
                currentArray[i] = c;
                String s = new String(currentArray);
                if(set.contains(s)){
                    combinations.add(s);
                }
                currentArray[i] = original;//restore
            }
        }
        return combinations;
    }
}
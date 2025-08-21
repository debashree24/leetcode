class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        //problem similar to Open the Lock and Word Ladder
        //challenge? gene neighbours / stages / adj list

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        Queue<String> q = new LinkedList();
        q.offer(startGene);

        int levels = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size; i++){
                String current = q.poll();
                if(current.equals(endGene)) return levels;

                for(String combination : getCombinations(current,set)){
                    q.offer(combination);
                    set.remove(combination);
                }
            }
            levels++;
        }
        return -1;
    }

    private List<String> getCombinations(String current,Set<String> set){
        List<String> combinations = new ArrayList();
        char[] currentArray = current.toCharArray();
        char[] newchars = new char[]{'A','C','G','T'};
        for(int i = 0; i < current.length(); i++){
            char old = currentArray[i];
            for(char c : newchars){
                currentArray[i]= c;
                String s = new String(currentArray);
                if(set.contains(s)){
                    combinations.add(s);
                }
                currentArray[i]=old;
            }
        }
        return combinations;
    }
}
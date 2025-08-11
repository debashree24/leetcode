class Solution {
    public int openLock(String[] deadends, String target) {
        //lets add our list of deadends to a set for O(1) checking that we have reached a deadend
        Set<String> deadend = new HashSet(Arrays.asList(deadends));
        //now lets check for edge case
        if(deadend.contains("0000")){
            return -1;//meaning we can never unlock
        }
        //initialize a queue to hold the stages from start to target
        Queue<String[]> q = new LinkedList();
        q.offer(new String[]{"0000","0"});//we are storing state and moves in the queue
        //Initialize another set called visited to note that we have already reached that combination before
        Set<String> visited = new HashSet();
        visited.add("0000");//mark the start as visited
        int stages = 0;
        while(!q.isEmpty()){
            String[] current = q.poll();
            String currentStage = current[0];
            stages = Integer.parseInt(current[1]);
            if(currentStage.equals(target)) return stages;//target reached
            for(String combination : getCombinations(currentStage)){
                if(!deadend.contains(combination) && !visited.contains(combination)){
                    q.offer(new String[]{combination,String.valueOf(stages+1)});
                    visited.add(combination);
                }
            }
        }
        return -1;
    }

    private List<String> getCombinations(String current){
        List<String> combinations = new ArrayList();
        char[] digits = current.toCharArray();
        for(int i = 0; i<4; i++){
            char c = digits[i];
            //+1 turn
            digits[i] = (c == '9') ? '0' : (char) (c + 1);
            combinations.add(new String(digits));
            //-1 turn
            digits[i] = (c == '0') ? '9' : (char) (c - 1);
            combinations.add(new String(digits));
            digits[i] = c;//restore to original
        }
        return combinations;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //there can only be 1 starting point
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0; i < gas.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }

        if(totalgas < totalcost){
            return -1; //round trip can't be completed
        }

        int startingidx = 0;
        int gasbalance = 0;
        for(int i = 0; i < gas.length; i++){
            gasbalance += gas[i] - cost[i];
            if(gasbalance < 0){
                startingidx =  i + 1;
                gasbalance = 0; //resetting everytime we start new
            }
        }
        return startingidx;
    }
}
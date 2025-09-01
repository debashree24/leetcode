class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int coverage = 0; //tracks the maximum index that can be reached from the current index
        int lastidx = 0; //tracks the end of the current jump window
        int maxjumps = 0; //tracks the maximum number of jumps needed to reach the end
        for(int i =0; i< nums.length -1; i++){
            coverage = Math.max(coverage, i+nums[i]);
            if(i==lastidx){ //when the end of the current jump window is reached
                lastidx = coverage; //update the end of the jump window
                maxjumps++;//increment the jump count
            }
        }
        return maxjumps;
    }
}



class Solution {
    public boolean canJump(int[] nums) {
        //greedy algo
        int finalidx = nums.length -1;
        for(int idx = nums.length -2; idx >=0 ; idx--){
            if(idx+nums[idx]>=finalidx){
                finalidx = idx;
            }
        }
        return finalidx==0;
    }
}

------------------------------------------------
class Solution {
    public boolean canJump(int[] nums) {
        //KAdane's algo
        int maxjump = 0; //tracks the maximum i can jump from a point
        for(int i = 0; i < nums.length; i++){
            if( i > maxjump ) return false; // when you reach zero kinda situations in the array
            maxjump = Math.max(maxjump,i+nums[i]);
        }

        return true;
    }
}
class Solution {
    public int rob(int[] nums) {
        // house robber I with a circular complexity
        //we need to break it into 2 parts and do house robber I
        //first run a loop from 0 to n-1 and the second from 1 to n
        int n = nums.length;
        if(n == 1){
            return nums[0];//single house to rob
        }
        int[] num1 = new int[n-1];
        int[] num2 = new int[n-1];
        int j = 0, k = 0;
        for(int i =0 ; i < n ; i++){
            if(i!=0){
                num1[j++] = nums[i];//exclude house first
            }if(i!=n-1){
                num2[k++] = nums[i];//exclude house last
            }
        }
        return Math.max(linearrob(num1),linearrob(num2));

    }

    public int linearrob(int[] nums) {
        //pick no pick startegy
        //tabulation + optimization
        int n = nums.length;
        //edge cases
        if(n == 0){
            return 0;
        }if(n == 1){
            return nums[0];//single house to rob
        }
        //base cases
        int prev2 = 0; // maz prfit 2 houses ago
        int prev1 = nums[0]; //max profit 1 house ago
        int ans = 0;
        for(int state = 1; state < n; state++){//rest of the houses
            int pick = nums[state] + prev2;
            int nopick = 0 + prev1 ;
            ans= Math.max(pick,nopick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
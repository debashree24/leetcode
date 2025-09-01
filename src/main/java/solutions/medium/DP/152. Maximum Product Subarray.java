//Kadane's
class Solution {
    public int maxProduct(int[] nums) {
        //kadane's algo type 2 pointer
        if(nums.length == 1 ) return nums[0];
        int n = nums.length;
        int leftproduct = 1;
        int rightproduct = 1;
        int ans = 0;
        for(int i = 0; i < n; i++){
            leftproduct = leftproduct==0 ? 1 : leftproduct;
            rightproduct = rightproduct==0 ? 1 : rightproduct;

            leftproduct *= nums[i];
            rightproduct *= nums[n - 1 - i];
            ans = Math.max(ans,Math.max(leftproduct,rightproduct));
        }
        return ans;

    }
}
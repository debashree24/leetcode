class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftmax =0;
        int rightmax =0;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left<right){
            if(height[left]>leftmax){
                leftmax = Math.max(height[left],leftmax);
            }
            if(height[right]>rightmax){
                rightmax = Math.max(height[right],rightmax);
            }
            if(leftmax < rightmax){
                ans += leftmax - height[left];
                left++;
            }else{
                ans += rightmax - height[right];
                right--;
            }
        }
        return ans;
    }
}
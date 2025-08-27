class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length -1;
        int maxArea = 0;
        int waterheight = 0, waterwidth = 0;
        while( i < j){
            waterheight = Math.min(height[i], height[j]);
            waterwidth = j - i;
            maxArea = Math.max(maxArea, waterheight*waterwidth);
            if( height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
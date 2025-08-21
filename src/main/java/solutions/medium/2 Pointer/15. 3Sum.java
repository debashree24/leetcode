class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //the result should not contain duplicates > use Set
        //this is a 2 pointer problem, fix an i and use left and right to move front and back
        Set<List<Integer>> result = new HashSet();
        //Sort the input that works best in 2 pointer, efficient narrowing
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                }else if( sum < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return new ArrayList(result);
    }
}
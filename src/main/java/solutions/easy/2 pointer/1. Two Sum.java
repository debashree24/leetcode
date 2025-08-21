class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i< nums.length; i++){
            int deficit = target - nums[i];
            if(map.containsKey(deficit)){
                return new int[]{map.get(deficit),i};
            }else{
                map.put(nums[i],i);// map logic : add the no and its location to the map
            }
        }

        throw new IllegalArgumentException(" Not 2sum");
    }
}
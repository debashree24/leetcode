class Solution {
    public long findScore(int[] nums) {

        //create a min heap
        //sort by value and if values match sort by lower index
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> (a[0] != b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]) //if values match sort by lower index
        );

        //a boolean array to mark
        boolean[] mark = new boolean[nums.length];

        //populate the min heap
        for(int i = 0; i < nums.length; i++){
            heap.offer(new int[]{nums[i],i});
        }

        long sum = 0L;
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int value = current[0];
            int index = current[1];
            if(mark[index]) continue;

            sum += value;
            mark[index] = true;
            if(index - 1 >=0){
                mark[index-1] = true;
            }if(index + 1 < nums.length){
                mark[index+1] = true;
            }
        }

        return sum;
    }
}
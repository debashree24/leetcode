class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
                (a,b) -> (a.getValue() - b.getValue()) //remeber comparator logic
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){//remeber map syntax
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!heap.isEmpty()){
            result[i++] = heap.poll().getKey();
        }
        return result;
    }
}
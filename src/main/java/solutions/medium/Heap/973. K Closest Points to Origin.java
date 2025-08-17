class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //the only challenge in this problem is the creation of proper comparator for the priority queue
        // Max-heap by distance: farthest on top so we can drop it when size > k
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> Long.compare(dist(b),dist(a))//remeber to reverse
        );

        for(int[] point : points){
            heap.offer(point);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[][] ans = new int[k][2];//why 2? because each row contains a point which is x and y i.e. 2
        for(int i=0; i < k; i++){
            int[] current = heap.poll();
            ans[i][0] = current[0];
            ans[i][1] = current[1];
        }
        return ans;

    }

    private long dist(int[] point){
        int x = point[0];
        int y = point[1];
        return x*x*1L + y*y*1L;
    }
}
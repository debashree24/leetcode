class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //djikstras algo

        //1) create and populate adjacency list > remember nodes here are 1 to n
        List<List<int[]>> adj = new ArrayList();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v,w});
        }

        //2) next call djikstras to get an array of the min times
        int[] mintimes = djikstras(k,n,adj);

        //3) this is the result that finally gets sent
        int mintime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(mintimes[i]==Integer.MAX_VALUE) return -1;
            mintime = Math.max(mintime,mintimes[i]); // we need to return the max time to reach all nodes
        }
        return mintime;
    }

    private int[] djikstras(int sourcenode, int n, List<List<int[]>> adj){

        //4) create Priority Queue > min heap > comparing the time
        //the array contains node and the time to it
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> a[1] - b[1] //min heap // for max heap b[1] - a[1]
        );

        //5) next create a time array that gets returned
        int[] time = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[sourcenode] = 0; //the time to sourcenode is 0
        heap.offer(new int[]{sourcenode,0}); // the sourcenode and time to it

        //6) actual djikstras start here
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int u = current[0];
            int d = current[1];
            if( d > time[u]) continue; //if the newly obtained time is greater than what is there in time array no need to update
            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];
                if(time[u] + w < time[v]){
                    time[v] = time[u] + w;
                    heap.offer(new int[]{v,time[v]});
                }
            }
        }
        return time;


    }
}
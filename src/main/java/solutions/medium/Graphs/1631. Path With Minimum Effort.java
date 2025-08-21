class Solution {
    public int minimumEffortPath(int[][] heights) {
        //classic djikstra
        //challenge 1 : creating adjacency list
        //challenge 2 : updating effort or effort relaxation

        //1) adj list
        int rows = heights.length;
        int columns = heights[0].length;
        List<List<int[]>> adj = new ArrayList();
        for(int i=0 ; i < rows*columns; i++){
            adj.add(new ArrayList());
        }

        //2) we are back to grid so direction circus begins
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        //3) populating the adj list
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                int node = r*columns+c; //row*column+column // this is how we convert grid to node
                for(int[] direction : directions){
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    if(nr >= 0 && nr < rows && nc >=0 && nc < columns){
                        int neighbornode = nr*columns+nc;
                        int height = Math.abs(heights[r][c] - heights[nr][nc]);
                        adj.get(node).add(new int[]{neighbornode,height});
                    }
                }
            }
        }

        int[] efforts = djikstras(adj,rows,columns);
        return efforts[rows*columns-1];
    }

    private int[] djikstras(List<List<int[]>> adj, int rows, int columns){

        //4) Priority queue > min heap
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> (a[1]-b[1])
        );

        //5) effort array
        int[] efforts = new int[rows*columns];
        Arrays.fill(efforts,Integer.MAX_VALUE);
        efforts[0] = 0;

        heap.offer(new int[]{0,0});//starting node and effort to reach starting node

        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int u = current[0];
            int d = current[1];
            if(d > efforts[u]) continue;
            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];
                int maxeffort = Math.max(efforts[u],w);
                if(maxeffort < efforts[v]){
                    efforts[v] = maxeffort;
                    heap.offer(new int[]{v,efforts[v]});
                }
            }
        }
        return efforts;
    }
}
class Solution {
    public int maximumDetonation(int[][] bombs) {
        //giving rotten orange vibe so far
        //bombs can be considered nodes
        //the radius can be considered directed edges
        //so we can start from 1 bomb and DFS/BFS through it to find how many bombs it can detonate
        //hint : Run a Depth First Search (DFS) from every node, and all the nodes it reaches are the bombs that will be detonated.

        //1) count the no of bombs
        int n = bombs.length;

        //2) create the adjacency list
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList());
        }

        //3) populate the adjacency list
        for(int i= 0;  i < n; i++){
            for(int j=0 ; j < n; j++){
                if(i == j) continue;

                //bomb details
                long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                long x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                // r2 will be irrelevant now as the bomb currently diffusing is x1,y1 and we are justconcerned about its radius

                //Euclidean distance formula > distance=(x1−x2)2+(y1−y2)2
                long distancebetween2bombs = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);

                if(distancebetween2bombs <= r1*r1){
                    adj.get(i).add(j); //meaning bomb2 is assesible to detonate
                }

            }
        }

        //4) counter for max no of bombs that can be detonated by 1 bomb
        int maxbombsdetonated = 0;

        //5) start DFS from each bomb/node as we are not aware which will cause most detonations
        for(int i = 0; i< n; i++){
            //visited boolean for marking
            boolean[] visited = new boolean[n];
            int detonated = dfs(i,adj,visited);
            maxbombsdetonated = Math.max(maxbombsdetonated,detonated);
        }
        return maxbombsdetonated;
    }

    //6) DFS
    private int dfs(int i, List<List<Integer>> adj, boolean[] visited){
        visited[i] = true;
        int count = 1;
        for(int bomb : adj.get(i)){
            if(!visited[bomb]){
                count += dfs(bomb,adj,visited);
            }
        }
        return count;
    }
}
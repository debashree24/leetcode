class Solution {
    public int countComponents(int n, int[][] edges) {
        //create an adjacency list and then do BFS
        List<List<Integer>> adj = new ArrayList();

        //create the adj list
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList());
        }

        //populate the adj list > we know that it is and undirected graph
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(b).add(a);
            adj.get(a).add(b);
        }

        //now keep a boolean array to mark visited nodes
        boolean[] visited = new boolean[n];

        //a counter to count the no of nodes
        int count = 0;

        //now BFS
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(int start, List<List<Integer>> adjlist, boolean[] visited){
        //BFS thumb rule a queue is necessary
        //why? to insert the first node to start the traversal
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            for(int neighbor : adjlist.get(current)){
                if(!visited[neighbor]==true){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}
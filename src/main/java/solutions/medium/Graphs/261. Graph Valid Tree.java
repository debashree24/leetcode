class Solution {
    public boolean validTree(int n, int[][] edges) {
        //a tree is a undirected graph in which 2 vertices are connected by exactly one path
        //any connected graph without simple cycles is a tree

        //that means there are 2 checks > 1) all nodes are connected 2) it is not cyclic at any point
        //can't be DAG

        //for a graaph to be a tree the edges should be n-1 where n is the no of vertices

        //in short if we determine edges are n-1 and it is connected, we can by default say it is not cyclic

        //check for n-1
        if(edges.length != n-1) return false;

        //create an adjacency list
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        //create a visited array to mark visited nodes
        boolean[] visited = new boolean[n];

        //now we need a queue as we want to do a simple BFS to determine all nodes are conencted
        Queue<Integer> q = new LinkedList();
        q.offer(0); // we know that nodes are labelled from 0 to n-1

        visited[0] = true; //marking node 0 as visited

        //create a counter to count no of nodes visited
        int c = 1;

        while(!q.isEmpty()){
            int current = q.poll();
            for(int neighbor : adj.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    c++;
                    q.offer(neighbor);
                }
            }
        }

        return c == n;
    }
}
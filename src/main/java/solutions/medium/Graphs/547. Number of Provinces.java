class Solution {
    public int findCircleNum(int[][] isConnected) {
        // we will solve it in DFS
        //maintain a boolean array of false for all the cities which will be flipped to true after visiting them
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; // so when we initialize without anything it is initialized to false
        int count = 0; //to count no of provinces
        //since the NxN matrix denotes the N no of cities in play
        for(int city =0; city < n; city++){
            if(!visited[city]){
                dfs(isConnected, visited, city);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;
        for(int othercity = 0; othercity < isConnected.length; othercity++){
            if(isConnected[city][othercity] == 1 && !visited[othercity]){
                dfs(isConnected, visited, othercity);
            }
        }
    }
}
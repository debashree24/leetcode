class Solution {
    public int numIslands(char[][] grid) {
        //DFS > recursion
        //first edge cases
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        //next write the method to call the recursive method
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;//one complete DFS means 1 island found
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        //now write logic to determine that island has been found
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length || grid[i][j] == '0'){
            return;
        }

        //we need to mark the traversed cell as visited
        grid[i][j] ='0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
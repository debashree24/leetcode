class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;
        int maxareaofisland = 0;
        for(int i = 0; i <  rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxareaofisland = Math.max(maxareaofisland,area);
                }
            }
        }
        return maxareaofisland;
    }

    private int dfs(int[][] grid, int i, int j){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i+1, j);
        area += dfs(grid, i-1, j);
        area += dfs(grid, i, j+1);
        area += dfs(grid, i, j-1);
        return area;
    }
}
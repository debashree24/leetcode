class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows;
    int columns;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //DFS with multiple sources > Pacific & Atlantic
        this.heights = heights;
        this.rows = heights.length;
        this.columns = heights[0].length;
        //all the cubes are marked false and will be marked true only if water can flow from it to respective ocean
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];

        //using reverse logic i.e. starting from edge to centre
        //because edge cubes will always flow to ocean
        //now we will reverse it to check if adjcent cubes are higher for water to flow to them

        //DFS from pacific borders i.e. top row & leftest column
        for(int i = 0; i < columns; i++){
            dfs(0, i, pacific);
        }
        for(int i = 0; i < rows; i++){
            dfs(i, 0, pacific);
        }
        //DFS from atlantic borders i.e. rightmost column and last row
        for(int i = 0; i < columns; i++){
            dfs(rows-1, i, atlantic);
        }
        for(int i = 0; i < rows; i++){
            dfs(i, columns-1, atlantic);
        }

        //finding the union of true cubes
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i< rows; i++){
            for(int j = 0; j < columns; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited){

        if(visited[r][c]) return;
        visited[r][c] = true;//mark current cell visited
        for(int[] direction : directions){
            int nr = r + direction[0];
            int nc = c + direction[1];

            if(nr >=0 && nr < rows && nc >=0 && nc < columns && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, visited);
            }
        }
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        //always handle edge cases first
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        //BFS approach
        //so we will add all the rotten oranges to the queue first
        //and count the fresh oranges then
        //then we will keep popping the rotten oranges and incrementing minutes and adding rotten oranges to the queue
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> q = new LinkedList();
        //directions to traverse during bfs
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int freshoranges = 0;
        for(int i = 0; i < rows; i++){
            for(int j=0; j < columns; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0}); //adding the position of the rotten orange and the minute it rot
                }else if(grid[i][j] == 1){
                   freshoranges++;
                }
            }
        }

        if(freshoranges == 0) return 0; //the box is rotten so no use going further
        int minutes = 0;
        //now lets bfs
        while(!q.isEmpty()){
            int[] current = q.poll();//got a rotten orange
            int r = current[0] , c = current[1], minute = current[2];
            minutes = Math.max(minutes,minute);
            for(int[] direction : directions){
                int nr = r + direction[0];
                int nc = c + direction[1];
                //check bounds
                if(nr >= 0 && nr < rows && nc >= 0 && nc < columns && grid[nr][nc] == 1){
                    freshoranges--;
                    grid[nr][nc] = 2;//marking the orange as rotten now
                    q.offer(new int[]{nr,nc,minute+1});
            }
        }
    }
    return freshoranges > 0 ? -1 : minutes;
    }

}
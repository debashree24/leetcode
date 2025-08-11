class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //handling edge cases
        if(grid == null || grid.length == 0) return 0;
        //we will use BFS for this as that will ensure the shortest path
        //with an exception that we can not only move horizontally and vertically but diagonnaly too
        //so 8 directions from any point
        int rows = grid.length;
        //another edge case that prevents no shortest path
        if(grid[0][0] != 0 || grid[rows-1][rows-1] != 0) return -1;
        //now declaring the directions it will move
        int[][] directions = {{-1,0},{1,0},{-1,-1},{1,1},{0,-1},{0,1},{1,-1},{-1,1}};
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1; //marked as visited

        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0], c = current[1], path = current[2];
            if(r == rows-1 && c == rows-1) return path;// immediately return the path when we reach the destination
            for(int[] direction :  directions){
                int nr = r + direction[0];
                int nc = c + direction[1];
                if(nr >=0 && nr < rows && nc >=0 && nc < rows && grid[nr][nc] == 0){
                    q.offer(new int[]{nr,nc,path+1});
                    grid[nr][nc] = 1;//mark as visited
                }
            }
        }
        return -1;
    }
}
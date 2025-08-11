class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //now lets try the BFS way
        //BFS means queue
        Queue<int[]> queue = new LinkedList();
        int maxareaofisland = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i< rows; i++){
            for(int j =0; j< columns; j++){
                if(grid[i][j] == 1){
                    int area = 0;//resetting area everytime we find new land
                    grid[i][j] = 2;//mark a visited cube
                    queue.offer(new int[]{i,j});
                    int size = queue.size();
                    maxareaofisland = Math.max(maxareaofisland,size);
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        area++;//when we poll a quque we know it is land and then add to area
                        for(int[] direction : directions){
                            int row = current[0] + direction[0];
                            int column = current[1] + direction[1];
                            if(row >= 0 && row < rows && column >= 0 && column < columns && grid[row][column] == 1){
                                //add position array to queue when boundary checks are in limits and it is land
                                queue.offer(new int[]{row,column});
                                grid[row][column] = 2;//mark a visited cube
                            }
                        }
                    }
                    maxareaofisland = Math.max(maxareaofisland,area);
                }
            }
        }
        return maxareaofisland;
    }
}
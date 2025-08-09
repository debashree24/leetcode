class Solution {
    public int numIslands(char[][] grid) {
        //now the bfs approach
        //means queue, of integer arrays to store the positions of the '1's
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i =0; i < rows; i++){
            for(int j =0; j < columns; j++){
                if(grid[i][j] == '1'){
                    count++;

                    queue.offer(new int[]{i,j}); //selecting a cube
                    grid[i][j] = '2'; //marking it as visited

                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        for(int[] direction : directions){
                            int row = current[0] + direction[0];
                            int column = current[1] + direction[1];
                            if( row >=0 && row < grid.length && column >= 0 && column < grid[0].length &&  grid[row][column] == '1'){
                                queue.offer(new int[]{row,column});
                                grid[row][column] = '2';
                            }

                        }
                    }
                }
            }
        }
        return count;
    }
}
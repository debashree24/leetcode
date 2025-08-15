class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows;
    int columns;
    public void wallsAndGates(int[][] rooms) {
        //hint : similar to no of islands and rotting oranges (more apt)
        //so you can consider gates as rotting oranges

        //obviously we would first need to queue the gates
        this.rows = rooms.length;
        this.columns = rooms[0].length;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(rooms[i][j] == 0){
                    q.offer(new int[]{i,j,});
                }
            }
        }
        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0], column = current[1];
            for(int[] direction : directions){
                int newrow = row + direction[0];
                int newcolumn = column + direction[1];
                if(newrow >=0 && newrow < rows && newcolumn >=0 && newcolumn < columns && rooms[newrow][newcolumn] == Integer.MAX_VALUE){
                    rooms[newrow][newcolumn] = rooms[row][column]+1;
                    q.offer(new int[]{newrow,newcolumn});
                }
            }
        }
    }
}
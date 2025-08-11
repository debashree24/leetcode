class Solution {
    public void solve(char[][] board) {
        //DFS and boundary marking
        int rows = board.length;
        int columns = board[0].length;

        //lets first mark the first and last column where there is '0' with say 'S' for Safe
        //as this can't be considered as surrounded region
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][columns -1] == 'O') dfs(board, i, columns -1);
        }
        //next mark the first and last row where there is '0' with say 'S' for Safe
        //as this can't be considered as surrounded region
        for(int j = 0; j < columns; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[rows -1][j] == 'O') dfs(board, rows - 1, j);
        }

        //flip the entire grid 'O' to 'X' and 'S' back to 'X'
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }

    }
    // the dfs method for S marking
    private void dfs(char[][] board, int i, int j){
        //check if i and j is out of bounds or the cube is 'X'
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'S';
        dfs(board, i+1,j);
        dfs(board, i-1,j);
        dfs(board, i,j+1);
        dfs(board, i,j-1);
    }
}
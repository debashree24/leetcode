class Solution {
    public int snakesAndLadders(int[][] board) {
        //always 6 neighbours > 6 sides of the dice 1,2,3,4,5,6 > adj list
        //challenge? the board starts 1 at bottom left and alternates direction of counting on every incremental row
        //so getting co-ordinate of the cube at the position is a challenge

        //1) basic assumptions
        int boardlength = board.length;
        int target = boardlength*boardlength;
        boolean[] visited = new boolean[target+1];

        //2) Queue for BFS and populating it with the first element
        Queue<Integer> q = new LinkedList();
        q.offer(1);
        visited[1] = true;

        //3) min steps to reach target
        int minsteps = 0; //since we haven't taken any step

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i < size; i++){

                int current = q.poll();

                for(int dice = 1 ; dice <= 6 ; dice++){// 6 sides of a dice
                    int next = dice + current;
                    if(next > target) continue; // out of board so skip
                    int[] coordinate = getCoordinates(next,boardlength);
                    int row  = coordinate[0];
                    int column = coordinate[1];
                    //if snakeless or ladderless cube i.e. -1 then add the dice value to current position and move there
                    //else go to the destination that snake or ladder lead to
                    int destination = board[row][column] == -1 ? next : board[row][column];
                    if(destination == target)
                        return minsteps+1; // we add +1 here because we were in a step while returning this and need to factor in that
                    if (!visited[destination]) {
                        visited[destination] = true;
                        q.offer(destination);
                    }
                }
            }
            minsteps++;
        }
        return -1;
    }

    //v v challenging
    private int[] getCoordinates(int nextvalue, int boardlength){
        //nextvalue is basically the cube you are travelling to next and we want to find coordinate for it
        int rowfrombottom = (nextvalue - 1)/boardlength;
        int actualrow = boardlength - 1 - rowfrombottom;
        int columnbeforeflip = (nextvalue - 1)%boardlength;
        //flip column direction for odd rows
        //always flip baes on row that we get from bottom not actual row
        int actualcolumn = (rowfrombottom%2 == 0) ? columnbeforeflip : boardlength - 1 - columnbeforeflip;
        return new int[]{actualrow,actualcolumn};
    }
}
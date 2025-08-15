class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //this will also use Kahn's Algo using BFS
        //difference from Couse Schedule I is this time we are returning the topo sorted list
        //If there are many valid answers, return any of them. > why there are many valid ans?
        //because say at any point there are multiple courses with zero precourse, then i can process any of the courses

        //1) adj list
        List<List<Integer>> adj  = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList());
        }

        //2) indegree array
        int[] indegrees = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int precourse = prerequisite[1];
            adj.get(precourse).add(course);
            indegrees[course]++;
        }

        //3) add zero precourse course to queue
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                q.offer(i);
            }
        }

        //4) start BFS
        int[] result = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            result[i++] = current;
            for(int neighbour : adj.get(current)){
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }

        return i == numCourses ? result : new int[0];
    }
}
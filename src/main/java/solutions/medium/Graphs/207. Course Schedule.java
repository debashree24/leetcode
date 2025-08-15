class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we will use Kahn's Algorithm / Topological Sort by BFS

        //lets first create an adjacency list for every course
        //the list will have the prerequisite course to a course or in graph terms u -> v
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList());
        }

        //next we will create the indegree array i.e precourse -> course
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int precourse = prerequisite[1];
            adj.get(precourse).add(course);
            indegree[course]++;
        }

        //now since it is BFS need a queue
        Queue<Integer> q = new LinkedList();

        //add all the courses that have zero precourse or 0 indegrees
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);//add the vertex or course with no precourse
            }
        }
        //next initialize an integer to count the courses as we process
        //why we need this? for cycle detection. If it is not a DAG we would not have done succesful topo sort of all the
        //vertices, so in short we would not have traversed all the vertices
        int processedcourses = 0;

        //next as we do in BFS run till queue is empty
        while(!q.isEmpty()){
            int current = q.poll();
            processedcourses++;
            for(int neighbour : adj.get(current)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }

        return processedcourses == numCourses;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //this map will store the node and cloned node mapping after visiting the node
    Map<Node,Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        //lets first solve by DFS or recursion

        //edge case check
        if(node == null) return null;

        //if a node is already cloned return it
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        //Create a clone of the node
        Node clone = new Node(node.val);

        //store it in the map before cloning neighbours
        visited.put(node,clone);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add((cloneGraph(neighbor)));
        }

        return clone;

    }
}
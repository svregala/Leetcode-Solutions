/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 
Test case format:
For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */

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
    // global variable map so that we skip passing it in every time
    // HashMap key: old node and value: new node (clone) --> 1:1, 2:2, etc.
    // We have to create new copies of each node so this will be recursive
    // Each time we make a new node, we're gonna look at its neighbors and check if we've already made a clone of it
   Map<Node, Node> map = new HashMap<>();

   public Node cloneGraph(Node node) {
      // base case, if empty graph, return null
      if(node==null){
         return null;
      }

      // if empty neighbor's list, we know that there are no other nodes
      if(node.neighbors.isEmpty()){
         return new Node(1);
      }

      return dfs(node);
      // TC: O(n) with n=edges+vertices
      // SC: O(m) with m=num of nodes
    }

    // pass in node we are visiting
    // this function takes in the node, 
    // and creates a CLONE of that node AND we're cloning all of it's neighbors recursively
    // the neighbors we're creating, we're adding them to the list of neighbors of this clone
   private Node dfs(Node node){
      // check if node in map --> if in map, it means we already made a clone of it
      // return clone bc we don't need to create a new one
      if(map.containsKey(node)){
         return map.get(node);
      }

      // create clone if not in map, then add to map
      Node copy = new Node(node.val);
      map.put(node, copy);

      // now, we wanna make copies of every single neighbor of the original node
      // for each neighbor, we call dfs on THAT neighbor
         // when we call dfs on THAT neighbor, it's gonna return the copy we end up creating
         // and with that copy, I'm going to append the node's neighbors (one at a time) to the copy's neighbor list
      for(Node item : node.neighbors){
         copy.neighbors.add(dfs(item));
      }
      
      return copy; // once we're done making a copy of the neighbors, then we return the copy
    }

    /*
    A more brute force way to think about this problem. This is a good way to think about it before jumping into the solution given by NeetCode.
    #1. Use a hashmap to track originals to their clones (same as NC). 
    #2. Traverse the original graph, visiting each node once, for each node just clone it's value without the neighbors.
    #3. Traverse the original graph again, visiting each node once, for each node find it''s clone and set the original's neighbors clones as the clone's neighbors.
    #4. return oldToNew[node]
    */
}
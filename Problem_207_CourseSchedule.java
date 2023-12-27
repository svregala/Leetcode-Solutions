/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */

class Solution {
   Map<Integer, ArrayList<Integer>> prereqMap = new HashMap<>();   // map each course to it's prerequisite list
   Set<Integer> visited = new HashSet<>();                         // visit == all courses along the current DFS path

   public boolean canFinish(int numCourses, int[][] prerequisites) {
      // map each course to it's prerequisite list
      for(int i=0; i<numCourses; i++){
         prereqMap.put(i, new ArrayList<Integer>());
      }
      for(int[] item : prerequisites){
         prereqMap.get(item[0]).add(item[1]);
      }

      // call dfs function for every single course in numCourses
      // if any of them happen to return false, we return false immediately
      // we loop like this to take care of the instance for when the graph is NOT full connected
         // 1 -> 2 (1 has prerequisite of 2)
         // 3 -> 4
         // ^^ these are two separated graphs
         // so we have to manually iterate through every course and check if each course can be completed
      for(int i=0; i<numCourses; i++){
         if(!dfs(i)){
            return false;
         }
      }
      return true;
   }

   // pass in current course we are visiting
   private boolean dfs(int course){
      // multiple base cases
      // if course is visited already, return false --> we're visiting a course twice, so we detected a loop, course cannot be completed
      if(visited.contains(course)){
         return false;
      }
      // if this course has an empty list for prerequisites --> course CAN be completed
      if(prereqMap.get(course).isEmpty()){
         return true;
      }

      visited.add(course);
      // recursively run DFS on its prerequisites
      for(int item : prereqMap.get(course)){
         // if dfs is false --> if we find one course that CANNOT be completed, then we can return right away
         if(!dfs(item)){
            return false; 
         }
      }

      // before we return true, we remove from visit set because we're no longer visiting the course, since we finished visiting it
      visited.remove(course);

      // since we know this course can be completed, set the course's list to an empty list
      // so if we ever have to run DFS on that course again, we can return true from because of line 44
         // therefore, we don't have to repeat the works on line 50 (DFS on the course's neighbors)
      prereqMap.put(course, new ArrayList<Integer>());

      // when we reach this point, it means the course can be completed
      return true;
   }
}

// CANNOT complete all courses if there exists a cycle
// solve using DFS or BFS
// courses are the nodes, prerequisites are the edges
// GOAL: for each node/courses, can we complete this course? 
    // how do we know if we can complete? 
// Base case: nodes that do NOT have prerequisites (ie no outgoing arrows in a drawn graph)
    // we can use a data structure, an adjacency list (HashMap representation), to tell us that
        // key == course, value == list of ALL of its prerequisites (if empty list, it has no prerequisites)
// After creating map, run DFS on every single node --> start at 0 up to n-1
    // run DFS using prerequisite map, recursively
    // visit course/node 0, then recursively visit its neighbor (map to find its neighbor)
        // if node does NOT have any neighbors, we know that we can complete that course
        // when recursion calls continue, once we visit all the neighbors of a node, then we are able to complete the course
        // once we visit all the neighbors of a node, we can remove them from the node's neighbor list in our map
            // when we remove all the neighbors of a node, that means we can complete that course/node
            // ==> empty neighbor list in hash map implies node/course can be completed
// TC of the above -- O(n+p) with n as number of nodes and p as number of prerequisites
    // because we recursively visit the nodes and it's corresponding prerequisites, 
    // we don't visit the course more than once because once we know the course can be completed (by removing the 
    // prerequisites from its list (because we visited it)), we can instantly just say it can be completed and NOT 
    // have to visit its prerequisites again

// example of detecting a loop (cycle)
    // using the set DS -- set will contain the courses that we're currently visiting along our DFS
        // during our visit of these nodes, when we visit a node that already exists in the set, then we detect a cycle

// explain the problem using an example that would be untrue and true
// TRUE: DFS, n=5 (i=0 to 4), prereq = [ [0,1], [0,2], [1,3], [1,4], [3,4] ] 
// UNTRUE: DFS, n=3 (i=0 to 2), prereq = [ [0,1], [1,2], [2,0] ]
// --> for both examples above, draw graph with arrows, draw map and set, explain algorithm
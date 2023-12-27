/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. 
If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
*/

class Solution {
   ArrayList<Integer> result;
   Map<Integer, ArrayList<Integer>> adj_list;
   Set<Integer> visit;

   public int[] findOrder(int numCourses, int[][] prerequisites) {
      adj_list = new HashMap<>(); // adjacency list, key is node with value as prerequisite list
      visit = new HashSet<>();    // set to keep track of current node in path
      result = new ArrayList<>();

      // fill up adjacency list with all required keys
      for(int i=0; i<numCourses; i++){
         adj_list.put(i, new ArrayList<Integer>());
      }

      // fill in prerequisite classes
      for(int[] prereq : prerequisites){
         adj_list.get(prereq[0]).add(prereq[1]);
      }

      for(int i=0; i<numCourses; i++){
         if(!dfs(i)){
            result.clear();
            return result.stream().mapToInt(Integer::intValue).toArray();
         }
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
   }

   private boolean dfs(int course){
      // if course doesn't have any prerequisites, return true right away because we can complete it
      if(adj_list.get(course).isEmpty()){
         // add the course to result since it doesn't have any more prerequisites
         if(!result.contains(course)){
            result.add(course);
         }
         return true;
      }

      // make sure we don't visit a the same node in our current path twice
      if(visit.contains(course)){
         return false;
      }

      // add current course in our path
      visit.add(course);

      // go through each neighbor of the current course, run dfs to make sure no cycle exists
      for(int item : adj_list.get(course)){
         if(!dfs(item)){
            return false;
         }
      }

      // after visiting course's neighbors, we can remove course from our current visit path
      visit.remove(course);

      // set neighbor list of course to empty list because once we reach this point, we visited all it's neighbors without detecting a cycle
         // this is also to remove any repeated work
      adj_list.put(course, new ArrayList<>());

      // add the course to result once we went through ALL of it's prerequisites
      if(!result.contains(course)){
         result.add(course);
      }

      return true;
   }
}

// TC: O(n+p), n=number of courses and p=total number of prerequisites
    // we recursively visit the nodes and its corresponding prerequisites
    // we don't visit a course more than once because once we know the course can be completed (removing it's prerequisites from it's list),
        // we can instantly say it can be completed and NOT have to visit it's prerequisites again

// SC: O(n+p), n=number of courses and p=total number of prerequisites
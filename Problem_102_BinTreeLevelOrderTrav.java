/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);

      while(!q.isEmpty()){
         int qLength = q.size();
         List<Integer> level = new ArrayList<>();

         for(int i=0; i<qLength; i++){
            TreeNode node = q.poll();
            if(node!=null){
               level.add(node.val);
               q.add(node.left);
               q.add(node.right);
            }
         }
         
         if(!level.isEmpty()){
            res.add(level);
         }
      }

      return res;
   }
}
// BFS ON TREE, add values in lists
// use queue -->
    // count elements in queue initially, until the queue is not EMPTY, add to the sublist
// TC: O(n) --> visiting node once
// SC: O(n) --> queue could have up to n/2 elements in it bc the biggest level of a tree is n/2
// need qLength is to make sure we're going 1 level at a time
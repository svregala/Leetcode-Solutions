/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
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
   public TreeNode buildTree(int[] preorder, int[] inorder) {
      ArrayList<Integer> pre_list = new ArrayList<>();
      ArrayList<Integer> in_list = new ArrayList<>();
      for(int i=0; i<preorder.length; i++){
         pre_list.add(preorder[i]);
         in_list.add(inorder[i]);
      }

      return buildHelper(pre_list, in_list);
   }

   private TreeNode buildHelper(List<Integer> pre, List<Integer> in){
      // base case
      if(pre.isEmpty() || in.isEmpty()){
         return null;
      }

      TreeNode root = new TreeNode(pre.get(0));
      int mid = in.indexOf(pre.get(0));

      // create left subtree
      root.left = buildHelper(pre.subList(1, mid+1), in.subList(0, mid));
      // create right subtree
      root.right = buildHelper(pre.subList(mid+1, pre.size()), in.subList(mid+1, in.size()));

      return root;
   }
}

// base case -- no nodes to traverse in 2 arrays given
    // if either array is empty, return null because no values so don't need to create a tree
// otherwise create a tree with the root as the first value of the preorder array
    // find mid, then recursively create left and right subtree


// preorder ALWAYS has the node first. But you don't know the size of either branch.
// inorder ALWAYS has the left branch to the left of the node, and right branch right of the node. So now you know the size of each branch
    // Take those information and break the arrays into subproblems, based on the size.

// 2 facts we use, given preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]:

    // 1) the first value in preorder traversal is ALWAYS gonna be the root node, we can recursively construct left subtree and right subtree
        // after removing the 3, the first value 9 is gonna be the root of the left subtree
        // looking at our sublist [9,20,15,7], figure out what's gonna go in the left and right subtree
            // 9 goes in the left subtree, the rest of the 3 values go in the right subtree
            // BUT how do we determine that? we need INORDER TRAVERSAL ARRAY for that
        // we know that 3 is the root so let's find 3 in inorder: [9,3,15,20,7]
            // INORDER array: every value to the left of the 3 we created the root from is gonna go in the left subtree
            // AND every value to the right of 3 is gonna go in the right subtree

    // 2) say our root node is 3 (from our preorder array), everything to the left of the 3 in the INORDER array is in the left subtree
        // similarly, everything to the right of 3 in the inorder array is gonna be in the right subtree
            // in our example, there is 1 value that goes in the left subtree and 3 values that go in the right subtree
        
    // what we do is gonna take the remainder of the preorder array, [9,20,15,7], 
        // and partition it such that 9 goes in the left subtree and 20,15,7 go in the right subtree
    // create subtrees ^ recursively

    // now looking at preorder = [20,15,7] and inorder = [15,20,7] --> we are constructing the right subtree of root node 3
        // create root node of this subtree by taking the first value of the PREORDER array, so 20
        // so now, find 20 (find the index of 20, call it mid) in the INORDER array and determine what is in the left and right subtree
            // ==> there is one value on the left of 20, and one value on the right of 20 
                // so one value in the left subtree and then one value on the right subtree

/*
Given an integer array nums, handle multiple queries of the following types:
- Update the value of an element in nums.
- Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:
- NumArray(int[] nums) Initializes the object with the integer array nums.
- void update(int index, int val) Updates the value of nums[index] to be val.
- int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */

class SegmentTreeNode{
   int start;
   int end;
   int sum;
   SegmentTreeNode left;
   SegmentTreeNode right;

   public SegmentTreeNode(int start, int end){
      this.start = start;
      this.end = end;
      this.sum = 0;
      this.left = null;
      this.right = null;
   }
}

class NumArray {
   SegmentTreeNode root;

   public NumArray(int[] nums) {
      root = buildTree(nums, 0, nums.length-1);
   }

   // helper for constructor
   private SegmentTreeNode buildTree(int[] nums, int start, int end){
      if(start > end){
         return null;
      }
      else{
         SegmentTreeNode result = new SegmentTreeNode(start, end);
         if(start == end){
            result.sum = nums[start];
         }
         else{
            int mid = (start + end)/2;
            result.left = buildTree(nums, start, mid);
            result.right = buildTree(nums, mid+1, end);
            result.sum = result.left.sum + result.right.sum;
         }
         return result;
      }
   }
   
   public void update(int index, int val) {
      updateTree(root, index, val);
   }

   // helper for update functions
   private void updateTree(SegmentTreeNode node, int index, int value){
      if(node.start == node.end){
         node.sum = value;
      }
      else{
         int mid = (node.start + node.end)/2;
         if(index <= mid){
            updateTree(node.left, index, value);
         }
         else{
            updateTree(node.right, index, value);
         }
         node.sum = node.left.sum + node.right.sum;
      }
   }
   
   public int sumRange(int left, int right) {
      return sumRangeHelper(root, left, right);
   }

   // helper for sumRange function
   private int sumRangeHelper(SegmentTreeNode node, int left, int right){
      if(node.start==left && node.end==right){
         return node.sum;
      }
      else{
         int mid = (node.start + node.end)/2;
         if(mid >= right){
            return sumRangeHelper(node.left, left, right);
         }
         else if(mid+1 <= left){
            return sumRangeHelper(node.right, left, right);
         }
         else{
            return sumRangeHelper(node.left, left, mid) + sumRangeHelper(node.right, mid+1, right);
         }
      }

      // base case: if current node start is left boundary AND current node end is right boundary
      // calculate mid of the current node you are at --> this will tell us how to go down the segment tree
      // if mid >= right index, it means we're beyond the right boundary --> so visit LEFT child node with same index boundaries
      // if mid+1 <= left index, it means we're beyond the left boundary --> so visit RIGHT child node with the same index boundaries
      // else we visit the left child node with boundaries left to mid AND visit right child node with boundaries mid+1 to right
   }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

// Segment tree --
    // SegmentTreeNode object - sum, start, end, left node, right node
        // start is index (from nums array) of where the sum starts
        // end is the index (from nums array) of where the sum ends
        // sum is the sum from index start to index end
        // left and right node are children

// TC
    // initializing tree is O(nlogn)
    // updating tree is O(logn)
    // sum range is O(logn)

// SC
    // storing segment tree is O(nlogn)

// try with example nums=[1,3,5]
class Solution {
    public int removeDuplicates(int[] nums) {
        // base case
        if(nums.length == 0){
            return 0;
        }

        // start at k = 1 because the first element is always unique
        int k = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
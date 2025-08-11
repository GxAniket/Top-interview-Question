class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int k = 0; // last unique index
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}

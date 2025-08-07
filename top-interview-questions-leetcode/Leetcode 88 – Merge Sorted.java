class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;          // Pointer for nums1
        int p2 = n - 1;          // Pointer for nums2
        int i = m + n - 1;       // Last position in nums1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        sol.merge(nums1, m, nums2, n);

        System.out.print("Merged Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

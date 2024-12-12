class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (nums[mid] == target)
                return mid;

            if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
            mid = start + (end - start) / 2;
        }
        return start;
    }
}

public class searchInsertPos {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 1, 3, 5, 6 };
        int target1 = 5;
        System.out.println(solution.searchInsert(nums1, target1)); // Output: 2

        // Test case 2
        int[] nums2 = { 1, 3, 5, 6 };
        int target2 = 2;
        System.out.println(solution.searchInsert(nums2, target2)); // Output: 1

        // Test case 3
        int[] nums3 = { 1, 3, 5, 6 };
        int target3 = 7;
        System.out.println(solution.searchInsert(nums3, target3)); // Output: 4

        // Test case 4
        int[] nums4 = { 1, 3, 5, 6 };
        int target4 = 0;
        System.out.println(solution.searchInsert(nums4, target4)); // Output: 0
    }
}

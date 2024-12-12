import java.util.*;

class Solution {
    // Approach 1
    public boolean containsDuplicate1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    // Approach 2 -- liked
    public boolean containsDuplicate2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int m = set.size();
        if (n == m)
            return false;
        return true;
    }

    // Approach 3 - using hashTable counting -> don't used it

}

public class containsDup {
    public static void main(String[] args) {
        // .....
    }
}

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        // Hashmap to store element and it's index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                ans[0] = i;
                ans[1] = map.get(complement);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}

public class twoSum {
    public static void main(String[] args) {
        // .....
    }
}
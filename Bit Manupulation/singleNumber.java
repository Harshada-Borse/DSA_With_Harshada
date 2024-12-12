class Solution {
    public int singleNumber(int[] nums) {
        // xor of the no with itself gives 0
        // take the xor of each element value of twice occring elements become 0 and at
        // the last only one element remain which having single occurance
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

public class singleNumber {
    public static void main(String[] args) {
        // .....
    }
}

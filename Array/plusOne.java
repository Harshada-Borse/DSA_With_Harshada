class Solution {
    public int[] plusOne(int[] digits) {
        // math approach
        int n = digits.length;
        int carry = 1;

        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; --i) {
            int currentSum = digits[i] + carry;
            digits[i] = currentSum % 10; // Update the digit at i
            carry = currentSum / 10; // Calculate the carry
        }

        // If there's still carry left, we need to create a new array with extra space
        if (carry > 0) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = carry; // Set the carry at the start
            System.arraycopy(digits, 0, newDigits, 1, n); // Copy the original digits
            return newDigits;
        }

        return digits;
    }
}

public class plusOne {
    public static void main(String[] args) {
        // .....
    }
}

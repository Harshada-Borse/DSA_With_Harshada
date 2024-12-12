import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> result = new Stack<>();
        int len = s.length();
        int sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0; // to store the operand
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0'); // subtraction of char 0 is to convert charater to integer;
                    i++;
                }
                i--;

                // now check the sign and perform resp. operation
                if (sign == '+')
                    result.push(num);
                else if (sign == '-')
                    result.push(-num);
                else if (sign == '*') {
                    int preNo = result.pop();
                    int ans = preNo * num;
                    result.push(ans);
                } else if (sign == '/') {
                    int preNo = result.pop();
                    int ans = preNo / num;
                    result.push(ans);
                }
            }

            else if (s.charAt(i) != ' ') {
                sign = s.charAt(i);
            }
        }
        // at the last remove all content of the stack and sum it up
        int sum = 0;
        while (result.size() > 0) {
            sum += result.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator sol = new BasicCalculator();

        // Test cases
        String s1 = "3+2*2";
        String s2 = " 3/2 ";
        String s3 = " 3+5 / 2 ";

        int result1 = sol.calculate(s1);
        int result2 = sol.calculate(s2);
        int result3 = sol.calculate(s3);

        System.out.println("Result for '" + s1 + "': " + result1); // Expected output: 7
        System.out.println("Result for '" + s2 + "': " + result2); // Expected output: 1
        System.out.println("Result for '" + s3 + "': " + result3); // Expected output: 5
    }
}

public class BitwiseAND {

    public static int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = left + 1; i <= right; i++) {
            ans &= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int left = 5;
        int right = 7;

        System.out.println(rangeBitwiseAnd(left, right));
    }
}

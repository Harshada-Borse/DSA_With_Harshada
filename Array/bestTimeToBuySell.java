class Solution {
    public int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int max_profit = 0;
        int current_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < least) {
                least = prices[i];
            }
            current_profit = prices[i] - least;
            if (max_profit < current_profit) {
                max_profit = current_profit;
            }
        }
        return max_profit;
    }
}

public class bestTimeToBuySell {
    public static void main(String[] args) {
        // .....
    }
}

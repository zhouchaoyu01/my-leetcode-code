/**
 * @author ChanceZhou
 * @code this file2022-05-05-22:03
 */
public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                max += profit;
            }
        }
        return max;
    }
}

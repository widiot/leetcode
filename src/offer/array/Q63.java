package offer.array;

/**
 * 股票的最大利润
 */
public class Q63 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0, temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                temp = prices[i] - min;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }
}

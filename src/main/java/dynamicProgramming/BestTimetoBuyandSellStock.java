package dynamicProgramming;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = null;

        prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("7 = " + maxProfit(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println("4 = " + maxProfit(prices));

        prices = new int[]{1};
        System.out.println("0 = " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = 0;
        int max = 0;
        int cur = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            } else {
                cur = prices[i] - prices[min];
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }
}

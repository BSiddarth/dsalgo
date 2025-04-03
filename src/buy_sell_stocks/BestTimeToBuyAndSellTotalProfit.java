package buy_sell_stocks;

public class BestTimeToBuyAndSellTotalProfit {
    public int maxProfit(int[] prices) {

        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxprofit += Math.max(0, prices[i] - prices[i - 1]);

        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellTotalProfit bestTimeToBuyAndSell = new BestTimeToBuyAndSellTotalProfit();
        System.out.println(bestTimeToBuyAndSell.maxProfit(prices));
    }
}

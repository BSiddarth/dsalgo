package buy_sell_stocks;

public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min =Integer.MAX_VALUE;
        for (int i = 1; i <= prices.length-1; i++) {
             min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSell bst = new BestTimeToBuyAndSell();
        int profit = bst.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(profit);
    }
}

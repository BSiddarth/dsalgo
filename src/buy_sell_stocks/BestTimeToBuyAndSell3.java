package buy_sell_stocks;

public class BestTimeToBuyAndSell3 {

    public static void main(String[] args) {

        int [] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxProfit1 = 0;
        int minPrice = Integer.MAX_VALUE;
        int minPrice1 = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            System.out.println("minPrice----------->" + minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
            System.out.println("maxProfit----------->" + maxProfit);
            minPrice1 = Math.min(minPrice1, price-maxProfit);
            System.out.println("minPrice1----------->" + minPrice1);
            maxProfit1 = Math.max(maxProfit1, price - minPrice1);
            System.out.println("maxProfit1----------->" + maxProfit1);
        }
 return maxProfit1;
    }


}

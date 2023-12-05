package Leetcode.easy;

/**
 * Вам предоставляется массив, prices где prices[i] - цена данной акции на ith день.
 *
 * Вы хотите максимизировать свою прибыль, выбрав один день для покупки одной акции и
 * другой день в будущем для продажи этой акции.
 *
 * Получите максимальную прибыль, которую вы можете получить от этой сделки.
 * Если вы не можете получить никакой прибыли, вернитесь 0.
 *
 * Пример 1:
 *
 * Входные данные: цены = [7,1,5,3,6,4]
 * Результат:5
 * Пояснение: Покупайте на 2-й день (цена = 1) и продавайте на 5-й день (цена = 6), прибыль = 6-1 = 5.
 * Обратите внимание, что покупка во 2-й и продажа в 1-й день запрещены, поскольку вы должны купить перед продажей.
 * Пример 2:
 *
 * Входные данные: цены = [7,6,4,3,1]
 * Результат:0
 * Пояснение: В этом случае транзакции не совершаются, а максимальная прибыль = 0.
 *
 * Ограничения:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */


class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,2,6,1,2,6};
        System.out.println(solution.maxProfit(arr));
    }


    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }
            profit = prices[i] - buy;
            if(maxProfit < profit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}

package neetcode.slidingwindow;

public class MaxProfit {
    
    public static void main(String[] args) {
        Solution obj = new Solution();
        // int arr[] = [7,1,5,3,6,4];
         int[] arr = {7, 1, 5, 3, 6, 4}; 
         int ans = obj.maxProfit(arr);
         System.out.println("ans " + ans);
    }

    static class Solution{
        public int maxProfit(int[] prices){
           int result = 0;
           int mini = prices[0];
            for(int i=0; i<prices.length; i++){
                if(prices[i] < mini){
                    mini = prices[i];
                }
                int profit = prices[i] - mini;
                if(profit > result){
                    result = profit;
                }
            }
            return result;
        }
    }
}

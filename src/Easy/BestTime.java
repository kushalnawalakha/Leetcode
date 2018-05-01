package Easy;

/**
 * Created by kushal on 10/21/17.
 */
class BestTime {
    public static int maxProfit(int[] prices, int fee) {
        int prev=prices[0];
        int profit=0;
        int max=50000;

        for(int i=1;i<prices.length;i++){
            if(prev+fee<prices[i]){
                profit=profit+(prices[i]-prev)-fee;
                prev=max;
            }
            else if(prev>prices[i]){
                prev=prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int array[]={1,3,7,5,10,3};
        maxProfit(array,3);
    }
}
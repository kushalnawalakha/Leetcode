package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by kushal on 9/28/17.
 */
public class MaximizeProfit {
    public static void max(int nums[]){
        int max=Integer.MIN_VALUE;
        int maxArray[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            max=Math.max(max,nums[i]);
            maxArray[i]=max;
        }
        int profit=0;
        for(int i=0;i<nums.length;i++){
            profit=profit+(maxArray[i]-nums[i]);
        }
        System.out.println(profit);
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cum = new int[n+1];
        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + nums[i];
        int[][] dp = new int[n+1][];
        for(int i = 0;i < n-k+1;i++){
            dp[i] = new int[]{cum[i+k] - cum[i], i, -1, -1};
        }
        for(int u = 0;u < 2;u++){
            int[] best = null;
            int[][] ndp = new int[n+1][];
            for(int i = 0;i <= n;i++){
                if(i >= k){
                    if(dp[i-k] != null){
                        if(best == null || best[0] < dp[i-k][0]){
                            best = dp[i-k];
                        }
                    }
                }
                if(best != null && i+k <= n){
                    ndp[i] = Arrays.copyOf(best, 4);
                    ndp[i][0] += cum[i+k] - cum[i];
                    ndp[i][u+2] = i;
                }
            }
            dp = ndp;
        }

        int[] best = null;
        for(int i = 0;i <= n;i++){
            if(dp[i] != null && (best == null || best[0] < dp[i][0])){
                best = dp[i];
            }
        }
        return new int[]{best[1], best[2], best[3]};
    }


    public static int repeatedStringMatch(String A, String B) {
        if(A.length()==0&&B.length()>0){
            return -1;
        }
        if(A.length()==0&&B.length()==0){
            return 0;
        }
        HashSet<Character> val=new HashSet<>();
        for(Character ch:A.toCharArray()){
            val.add(ch);
        }
        for(Character ch:B.toCharArray()){
            if(!val.contains(ch)){
                return -1;
            }
        }
        String Aorg=A;
        int count=1;
        while (A.length()<B.length()*2){
            if(A.contains(B)){
                return count;
            }else{
                A=A+Aorg;
            }
            count++;
        }
        if(A.contains(B)){
            return count;
        }
        return -1;

    }


    public static void main(String[] args) {
        int arry[]=new int[]{1,2,1,2,6,7,5,1};
        maxSumOfThreeSubarrays(arry,2);
    }
}

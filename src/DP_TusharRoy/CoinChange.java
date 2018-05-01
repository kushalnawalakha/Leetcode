package DP_TusharRoy;

import java.util.Arrays;

/**
 * Created by kusha on 6/17/2017.
 */
public class CoinChange {
    public static int recursive(int nums[], int current, int dp[]) {

        if (current < 0)
            return -1;
        if (current == 0 || dp[current] != 0)
            return dp[current];

        for (int i = 0; i < nums.length; i++) {
            int val = recursive(nums, current - nums[i], dp);
            if (val < 0)
                continue;
            if (dp[current] == 0)
                dp[current] = val + 1;
            else
                dp[current] = Math.min(val + 1, dp[current]);
        }
        return dp[current];
    }

    public static void dp(int nums[],int sum){
        int dpArray[]=new int[sum+1];
        Arrays.fill(dpArray,Integer.MAX_VALUE);
        int track[]=new int[sum+1];
        Arrays.fill(track,-1);
        dpArray[0]=0;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(j-nums[i]>=0&&dpArray[j-nums[i]]!=Integer.MAX_VALUE){
                    if(dpArray[j-nums[i]]+1<dpArray[j]){
                        dpArray[j]=dpArray[j-nums[i]]+1;
                        track[j]=i;
                    }
                }
            }
        }
        for(int i=0;i<=sum;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<=sum;i++){
            System.out.print(dpArray[i]+" ");
        }
        System.out.println();
        for(int i=0;i<=sum;i++){
            System.out.print(track[i]+" ");
        }
        System.out.println();

        int i=track[sum];
        int curr=sum;
        while (i!=-1){
            System.out.print(nums[i]+" ");
            curr=curr-nums[i];
            i=track[curr];
        }
    }

    public static void main(String[] args) {
        int nums[]={7,2,3,6};
        int dp[] = new int[15];
        String a = "abc", b = "pqrstuvqxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i + j < a.length() + b.length(); i++, j++) {
            if (a.length() > i)
                sb.append(a.charAt(i));
            if (b.length() > j)
                sb.append(b.charAt(j));
        }
        System.out.println(sb);
//        recursive(nums,14,new int[15]);
    }

}



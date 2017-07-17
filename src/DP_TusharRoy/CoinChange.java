package DP_TusharRoy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by kusha on 6/17/2017.
 */
public class CoinChange {
    public static int recursive(int nums[],int sum,int current){
        for(int i=0;i<nums.length;i++){

        }
        return 0;
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
        dp(nums,14);
    }

}

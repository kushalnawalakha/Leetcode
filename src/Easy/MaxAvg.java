package Easy;

import java.util.Arrays;

/**
 * Created by kushal on 10/11/17.
 */
public class MaxAvg {
    public static double findMaxAverage(int[] nums, int k) {
        int total=0,max=0;
        for(int i=0;i<k;i++){
            total=total+nums[i];
        }
        max=total;
        for(int i=1;i<=nums.length-k;i++){
            total=total-nums[i-1]+nums[i+k-1];
            max=Math.max(total,max);
        }
        return ((double) max/(double) k);
    }

    public static void main(String[] args) {
        int nums[]={1,3,5,6};
        System.out.println();
    }

}

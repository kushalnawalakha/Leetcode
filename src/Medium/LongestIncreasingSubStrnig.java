package Medium;

import java.util.Arrays;

/**
 * Created by kusha on 5/23/2017.
 */
public class LongestIncreasingSubStrnig {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        int i=1,j=0,max=0;
        Arrays.fill(dp,1);
        while (i<nums.length||j<nums.length){
            if(i==j&&i!=nums.length){
                i++;
                j=0;
            }

            if(nums[j]<nums[i]){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            j++;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int array[]={3,4,-1,0,6,2,3};
        LongestIncreasingSubStrnig obj=new LongestIncreasingSubStrnig();
        System.out.print(obj.lengthOfLIS(array));

    }
}



package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by kushal on 10/10/17.
 */
public class MaxLenghtChainPair {
    public int findLongestChain(int[][] pairs) {
        int dp[]=new int[pairs.length];
        Arrays.fill(dp,1);
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        for(int i=0;i<pairs.length;i++){
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
            }
        }
        return 0;
    }

    public static String reverseString(String input){
        StringBuilder output=new StringBuilder();
        for(String s:input.split(" " )){
            StringBuilder b=new StringBuilder(s);
            output.append(b.reverse()+" ");
        }
        return output.toString().trim();
    }


    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
    }
}

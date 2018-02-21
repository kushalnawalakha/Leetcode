package HackerRank.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by kusha on 8/6/2017.
 */
public class CoinChangeProblem {

    static long getWays(long n, long[] c){
        Arrays.sort(c);
        long[][] dpArray=new long[c.length][(int)n+1];

        for(int i=(int)c[0];i<=n;i+=c[0]){
            dpArray[0][i]=1;
        }

        for(int i=1;i<c.length;i++){
            dpArray[i]=dpArray[i-1];
            for(int j=(int)c[i];j<=n;j++){
                if(j-c[i]==0||dpArray[i][j-(int)c[i]]>=1){
                    dpArray[i][j]=dpArray[i][j]+1;
                }
            }
        }
        return dpArray[c.length-1][(int)n-1];
    }

    public static void main(String[] args) {
        long c[]={2,5,3,6};
        int n=10;
        getWays(10,c);
    }
}

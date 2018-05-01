package DP_TusharRoy;

import java.util.Scanner;

/**
 * Created by kushal on 6/16/17.
 */
//https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

public class knapsack01 {

    public static long solve(int[] weights,int val[],int bagStrength){
        long[][] dpArray=new long[weights.length+1][bagStrength+1];
        for(int i=1;i<=weights.length;i++){
            for(int j=1;j<=bagStrength;j++){
                if(weights[i-1]<=j)
                    dpArray[i][j]=Math.max(val[i-1]+dpArray[i-1][j-weights[i-1]],dpArray[i-1][j]);
                else
                    dpArray[i][j]=dpArray[i-1][j];
            }
        }

        return dpArray[weights.length][bagStrength];

    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int total=scanner.nextInt();
            int st=scanner.nextInt();
            int w[]=new int[total];
            int v[]=new int[total];
            for(int j=0;j<total;j++){
                w[i]=scanner.nextInt();
            }
            System.out.println(solve(w,w,st));
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}

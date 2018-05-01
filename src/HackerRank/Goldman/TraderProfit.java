package HackerRank.Goldman;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by kusha on 8/18/2017.
 */
public class TraderProfit {
    static int traderProfit(int k, int n, int[] A) {
        int arr[][]=new int[k+1][A.length+1];
        for(int i=1;i<=k;i++){
            for(int j=1;j<n;j++){
                int max=Integer.MIN_VALUE;
                for(int m=0;m<j;m++){
                    max=Math.max(max,A[j]-A[m]+arr[i-1][m]);
                }
                arr[i][j]=Math.max(arr[i][j-1], max);;
            }
        }

        for(int i=0;i<=k;i++){
            for(int j=0;j<=n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return arr[k][n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }

}

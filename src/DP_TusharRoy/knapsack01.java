package DP_TusharRoy;

/**
 * Created by kushal on 6/16/17.
 */
//https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

public class knapsack01 {

    public static void solve(int[] weights,int val[],int bagStrength){
        int[][] dpArray=new int[weights.length+1][bagStrength+1];
        for(int i=1;i<=weights.length;i++){
            for(int j=1;j<=bagStrength;j++){
                if(weights[i-1]<=j)
                    dpArray[i][j]=Math.max(val[i-1]+dpArray[i-1][j-weights[i-1]],dpArray[i][j]);
                else
                    dpArray[i][j]=dpArray[i-1][j];
            }
        }

        for(int i=0;i<=weights.length;i++){
            for(int j=0;j<=bagStrength;j++){
                System.out.print(dpArray[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        int w[]={1,3,4,6};
        int v[]={1,4,5,7};
        int bagStrength=7;
        solve(w,v,bagStrength);
    }
}

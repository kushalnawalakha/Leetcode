package Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kushal on 8/26/17.
 */
public class PathSum4 {
    public int pathSum(int[] nums) {
        int sums[][][]=new int[5][9][2];
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                sums[i][j][0]=-1;
            }
        }
        for(int num:nums){
            int h=num/100;
            num=num%100;
            int t=num/10;
            num=num%10;
            int u=num;

            if(t==1||t==2){
                sums[h-1][1][1]=0;
            }else if(t==3||t==4){
                sums[h-1][2][1]=0;
            }else if(t==5||t==6){
                sums[h-1][3][1]=0;
            }else if(t==7||t==8){
                sums[h-1][4][1]=0;
            }

            sums[h][t][0]=u;
            sums[h][t][1]=1;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                System.out.print(" "+sums[i][j][0]);
            }
            System.out.println();
        }
        for(int i=4;i>=0;i--) {
            for (int j = 0; j < 9; j++) {
                if (sums[i][j][0] != -1) {
                    if (j == 1 || j == 2) {
                        sums[i - 1][1][1] += sums[i][j][1];
                    } else if (j == 3 || j == 4) {
                        sums[i - 1][2][1] += sums[i][j][1];
                    } else if (j == 5 || j == 6) {
                        sums[i - 1][3][1] += sums[i][j][1];
                    } else if (j == 7 || j == 8) {
                        sums[i - 1][4][1] += sums[i][j][1];
                    }
                }
            }
        }
        int sum=0;
            for(int i=4;i>=0;i--){
                for(int j=0;j<9;j++){
                        if(sums[i][j][0]!=-1)
                       sum=sum+sums[i][j][0]*sums[i][j][1];
                    }
                }
        return sum;
    }
    public static void main(String[] args) {
        int sums[]={113,229,349,470,485};
        PathSum4 pathSum4=new PathSum4();
    }
}

package Contest;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxRepeatedSubArray {
    public int findLength(int[] A, int[] B) {
            int dpArray[][]=new int[A.length+1][B.length+1];
            int max=0;
            for(int i=1;i<=A.length;i++){
                for(int j=1;j<=B.length;j++){
                    if(A[i-1]==B[j-1]){
                        dpArray[i][j]=dpArray[i-1][j-1]+1;
                        max=Math.max(dpArray[i][j],max);
                    }
                }
            }
            for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                System.out.print(dpArray[i][j]);
            }
            System.out.println();
            }
            return max;
    }

    public static void main(String[] args) {
        int num1[]={0,0,0,0,0};
        int num2[]={0,0,0,0,0};
        MaxRepeatedSubArray maxRepeatedSubArray=new MaxRepeatedSubArray();
        maxRepeatedSubArray.findLength(num1,num2);
    }
}

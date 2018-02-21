package DP_TusharRoy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by kusha on 9/19/2017.
 */
public class ArrayHopper {
    static int[] getMaxElementIndices(int[] a, int[] rotate) {
        int maxLoc=-1;
        int max=Integer.MIN_VALUE;
        int output[]=new int[rotate.length];
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                maxLoc=i;
                max=a[i];
            }
        }
        int i=0;
        for(int r:rotate){
            r=r%a.length;
            int val= maxLoc-r;
            output[i++]=val>=0?val:a.length+val;
        }

        return output;

    }



    private static int calculateJumps(int A[]){

        int jumps = 1;
        int allowedSteps= A[0];
        int max = A[0];

        for(int i=1; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            allowedSteps--;
            if( allowedSteps==0 ) {
                allowedSteps=max-i;
                if(allowedSteps<=0){
                    return -1;
                }
                jumps++;
            }
        }
        return jumps;
    }



    public static void main(String[] args) {
        int array[]={4,2,2,1,2,0,1,1};
        System.out.print(calculateJumps(array));
    }
}

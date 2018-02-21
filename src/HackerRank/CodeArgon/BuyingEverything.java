package HackerRank.CodeArgon;

import java.util.*;

/**
 * Created by kusha on 9/2/2017.
 */
public class BuyingEverything {
    static long minimumTime(int[] b, int m, int k,int d) {
        if(d<m-1){
            return -1;
        }
        long nextOne[]=new long[d];
        long currentLocation[]=new long[d+1];
        long runningSum[]=new long[d];
        int i=0,cnt=0;
        for(;i<b.length;i++){
            if(b[i]==1){
                currentLocation[cnt]=i;
                cnt++;
                i++;
                break;
            }
        }
        for(;i<b.length;i++){
            if(b[i]==1){
                currentLocation[cnt]=i;
                cnt++;
            }
        }
        if(m==1){
            return currentLocation[0];
        }
        nextOne[0]=currentLocation[1]-currentLocation[0];
        runningSum[0]=nextOne[0];
        for(i=1;i<d;i++){
            nextOne[i]=currentLocation[i+1]-currentLocation[i];
            runningSum[i]=nextOne[i]+runningSum[i-1];
        }

        long baseValue=currentLocation[0];
        for(i=1;i<m;i++){
            baseValue=baseValue+nextOne[i-1]*k*i;
        }
        long min=baseValue;
        long curr=baseValue;
        for(i=1;i<=(d-m+1);i++){

            curr -= currentLocation[i-1];
            curr -= (currentLocation[i]-currentLocation[i-1])*k;
            curr += currentLocation[i];
            curr += (currentLocation[i+m-1]-currentLocation[i+m-2])*(m-1)*k;
            curr -= (runningSum[i+m-3] - runningSum[i-1])*k;


            min= Math.min(min,curr);
        }

        return min;
    }

    public static void main(String[] args) {
        char c[]=new char[2];
        c[0]='1';
        c[1]='2';
        String s=String.valueOf(c);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] b = new int[n];
        int d=0;
        for(int b_i = 0; b_i < n; b_i++){
            b[b_i] = in.nextInt();
            if(b[b_i]==1){
                d++;
            }
        }
        long result = minimumTime(b, m, k,d-1);
        System.out.println(result);
        in.close();
    }
}

package Medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by kusha on 5/20/2017.
 */
public class Sum4_454 {
    private int[] getSum(int[]A, int[]B){
        int out[]=new int[A.length*B.length];
        int k=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                out[k++]=A[i]+B[j];
            }
        }
        return out;

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int sum1[]=getSum(A,B);
        int sum2[]=getSum(C,D);
        HashMap<Integer,Integer> sum=new HashMap<>();
        int count=0;

        for(int s:sum1){
            sum.put(s,sum.getOrDefault(s,0)+1);
        }
        for(int s:sum2){
            count=count+sum.getOrDefault(-s,0);
        }

        return count;
    }

    public static void main(String[] args) {
        int a[]={1,2};
        int b[]={-2,-1};
        int c[]={-1,2};
        int d[]={0,2};

        Sum4_454 sum4_454=new Sum4_454();
        System.out.print(sum4_454.fourSumCount(a,b,c,d));

    }
}

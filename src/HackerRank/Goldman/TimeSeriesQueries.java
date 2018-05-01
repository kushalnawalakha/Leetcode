package HackerRank.Goldman;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kusha on 8/18/2017.
 */
public class TimeSeriesQueries {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int q = in.nextInt();
            int[] t = new int[n];
            int maxArray[]=new int[n];
            int minArray[]=new int[n];
            int sortedArray[][]=new int[n][2];
            int tempArray[]=new int[n];
            for(int t_i = 0; t_i < n; t_i++){
                t[t_i] = in.nextInt();
            }
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
                sortedArray[p_i][0]=p[p_i];
                sortedArray[p_i][1]=t[p_i];
            }
            Arrays.sort(sortedArray, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]>o2[0]){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            maxArray[n-1]=sortedArray[n-1][1];
            for(int p_i = n-2; p_i >= 0; p_i--){
                maxArray[p_i]=Math.min(maxArray[p_i+1],sortedArray[p_i][1]);
            }

            int prev=Integer.MIN_VALUE;
            for(int i=n-1;i>=0;i--){
                prev=Math.max(prev,p[i]);
                minArray[i]=prev;
                tempArray[i]=sortedArray[i][0];
            }

            for(int a0 = 0; a0 < q; a0++){
                int _type = in.nextInt();
                int v = in.nextInt();
                if(_type==1){
                    int val=Arrays.binarySearch(tempArray,v);
                    if(val<0){
                        val=val+1;
                        val=-val;
                    }
                    if(val>=n){
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(maxArray[val]);
                }else{
                    int val=Arrays.binarySearch(t,v);
                    if(val<0){
                        val=val+1;
                        val=-val;
                    }
                    if(val>=n){
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(minArray[val]);
                }
            }
            in.close();
        }
}

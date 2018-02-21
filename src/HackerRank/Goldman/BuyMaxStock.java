package HackerRank.Goldman;

import java.util.*;

/**
 * Created by kusha on 8/18/2017.
 */
public class BuyMaxStock {
    static long buyMaximumProducts(int n, long k, int[] a) {
        TreeMap<Long,Long> map=new TreeMap<Long,Long>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1-o2==0){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });
        for(int i=0;i<a.length;i++){
            map.put((long)a[i],(long)i+1);
        }
        long count=0;
        for(Map.Entry<Long,Long> entry:map.entrySet()){
            if(entry.getKey()*entry.getValue()>k){
                count=count+(k/entry.getKey());
                //k=k-(k/entry.getKey())*entry.getKey();
                break;
            }else{
                count=count+entry.getValue();
                k=k-entry.getKey()*entry.getValue();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}

package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by kusha on 12/10/2017.
 */
public class BloomRose {
    public int longestConsecutive(int[] P, int K) {
        int day=-1;
        int kcount=0;
        Map<Integer, Integer> start = new HashMap();
        Map<Integer, Integer> end = new HashMap();

        for(int i=0;i<P.length;i++){
            int ele = P[i];
            int s = ele, e = ele;

            if(end.containsKey(ele-1)){
                s = end.get(ele-1);
                if(start.get(s)-s+1==K){
                    kcount--;
                }
                end.remove(ele-1);
            }
            if(start.containsKey(ele+1)){
                e = start.get(ele+1);
                start.remove(ele+1);
                if(e-end.get(e)+1==K){
                    kcount--;
                }
            }
            start.put(s,e);
            end.put(e,s);

            if(e-s+1 == K) kcount++;

            if(kcount > 0)
                day=i;
        }
        return day;
    }
}

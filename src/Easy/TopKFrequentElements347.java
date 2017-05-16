package Easy;

import java.util.*;

/**
 * Created by kusha on 5/16/2017.
 */
public class TopKFrequentElements347 {
    public void getMap(int nums[],HashMap<Integer,Integer> map){
        for(int num:nums){
            Integer cnt=map.get(num);
            if(cnt==null){
                map.put(num,1);
            }else {
                map.put(num,cnt+1);
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer[]> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        getMap(nums,map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Integer i[]={entry.getKey(),entry.getValue()};
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                System.out.println(o1[0]+" "+o1[1]);
                System.out.println("\t"+o2[0]+" "+o2[1]);

                if(o1[1]>o2[1])
                {
                    return -1;
                }else if(o1[1]<o2[1]){
                   return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0;i<k;i++){
            l.add(list.get(i)[0]);
        }
        return l;
    }
    public static void main(String[] args) {
        int arry[]={-5,-9,67,-10,4,-57,47,13,-67,-26,-57,63,38,-68,62,-45,-37,95,49,-91,-53,-42,-33,80,78,-30,-36,22,9,-86,79,-1,44,-92,30,-68,-94,58,-51,-2};
        TopKFrequentElements347 obj=new TopKFrequentElements347();
        System.out.print(obj.topKFrequent(arry,7));

    }
}

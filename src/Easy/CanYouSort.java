package Easy;

import java.util.*;

/**
 * Created by kushal on 9/28/17.
 */
public class CanYouSort {
    public static void customSort(int nums[]){
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int num:nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hmap.entrySet()){
            ArrayList e=map.get(entry.getValue());
            if(e==null){
                e=new ArrayList();
                e.add(entry.getKey());
                map.put(entry.getValue(),e);
            }else{
                e.add(entry.getKey());
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            Collections.sort(entry.getValue());
            for(Integer l:entry.getValue()){
                for(int k=0;k<entry.getKey();k++){
                    System.out.println(l);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nums[]={3,1,2,2,4};
        customSort(nums);
    }
}

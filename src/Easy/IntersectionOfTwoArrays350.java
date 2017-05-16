package Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kusha on 5/16/2017.
 */
public class IntersectionOfTwoArrays350 {

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

    public ArrayList<Integer> getCommon(int nums[],HashMap<Integer,Integer> map){
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums){
            Integer cnt=map.get(num);
            if(cnt!=null&&cnt>0){
                list.add(num);
                map.put(num,cnt-1);
            }
        }
        return list;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap();
        ArrayList<Integer> list;
        if(nums1.length>nums2.length){
            getMap(nums1,map);
            list=getCommon(nums2,map);
        }
        else{
            getMap(nums2,map);
            list=getCommon(nums1,map);
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;

    }
    public static void main(String[] args) {
        IntersectionOfTwoArrays350 intersectionOfTwoArrays350=new IntersectionOfTwoArrays350();
        int num1[]={1,2};
        int num2[]={1,1};
        System.out.println(Arrays.toString(intersectionOfTwoArrays350.intersect(num1,num2)));
    }
}

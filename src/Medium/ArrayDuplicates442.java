package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kusha on 7/4/2017.
 */
public class ArrayDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list =new ArrayList();
        for(int num:nums){
            int temp=num>0?num:-num;
            temp=temp-1;
            nums[temp]=-nums[temp];

        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }

        return list;


    }

    public static void main(String sp[]){
        int i[]={4,3,2,7,8,2,3,1};
        ArrayDuplicates442 arrayDuplicates442=new ArrayDuplicates442();
        System.out.println(arrayDuplicates442.findDuplicates(i));
    }
}

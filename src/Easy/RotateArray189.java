package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kusha on 5/16/2017.
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k=(k)%nums.length;
        k=nums.length-k;
        int newArray[]=Arrays.copyOf(nums,nums.length);
        int j=0;
        for (int i=k;i<nums.length;i++){
            nums[j++]=newArray[i];
        }
        for (int i=0;i<k;i++){
            nums[j++]=newArray[i];
        }
        System.out.print(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int array[]={1,2};
        RotateArray189 rotateArray189=new RotateArray189();
        rotateArray189.rotate(array,3);
        System.out.print(Arrays.toString(array));
    }
}

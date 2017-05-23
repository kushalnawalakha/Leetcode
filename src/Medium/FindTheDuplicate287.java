package Medium;

import DataStructures.ListNode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kusha on 5/21/2017.
 */
public class FindTheDuplicate287 {
    public int getCount(int[] nums,int low,int high){
        int count=0;
        for(int num:nums){
            if(num>=low&&num<=high){
                count++;
            }
        }
        return count;
    }
    public int findDuplicate(int[] nums) {
        int low=0,high=nums.length;
        while (high-low>1){
            int mid=(low+high)/2;
            if(getCount(nums,low,high)>low-mid){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        return low;
    }
    public  static void main(String sp[]){

    }
}

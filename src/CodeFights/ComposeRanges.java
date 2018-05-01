package CodeFights;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kusha on 8/5/2017.
 */
public class ComposeRanges {
    static String[] composeRanges(int[] nums) {

        if(nums.length==0){
            return new String[0];
        }
        ArrayList<String> list=new ArrayList<String>();
        int prev=nums[0];
        int n=0;
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1])>1){
                if(n==0)
                    list.add(""+prev);
                else
                    list.add(prev+"->"+nums[i-1]);
                prev=nums[i];
                n=0;
            }else{
                n++;
            }
        }
        if(nums[nums.length-1]==prev){
            list.add(""+nums[nums.length-1]);
        }else{
            list.add(prev+"->"+nums[nums.length-1]);
        }

        String[] out = list.toArray(new String[list.size()]);
        return out;
    }

    public static void main(String[] args) {
        int nums[]={-2147483647, -2147483646, 2147483647};
        composeRanges(nums);
    }
}

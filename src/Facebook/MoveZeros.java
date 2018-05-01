package Facebook;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kusha on 1/26/2018.
 */
public class MoveZeros {
    static ArrayList list=new ArrayList();

    public static void moveZeroes(int[] nums) {
        
        int nonZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nonZero=Math.max(nonZero,i+1);
                while(nonZero<nums.length&&nums[nonZero]==0){
                    nonZero++;
                }
                if(nonZero<nums.length){
                    nums[i]=nums[nonZero];
                    nums[nonZero]=0;
                }

            }
        }
    }

    public static void main(String[] args) {
        int nums[]={0,1,0,12,13};
        moveZeroes(nums);
    }
}

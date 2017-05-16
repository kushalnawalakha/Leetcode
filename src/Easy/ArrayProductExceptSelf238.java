package Easy;

import java.util.Arrays;

/**
 * Created by kusha on 5/16/2017.
 */
public class ArrayProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        ArrayProductExceptSelf238 arrayProductExceptSelf238=new ArrayProductExceptSelf238();
        System.out.print(Arrays.toString(arrayProductExceptSelf238.productExceptSelf(nums)));

    }

}

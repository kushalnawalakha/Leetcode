package Easy;

import java.util.Arrays;

/**
 * Created by kusha on 5/13/2017.
 */
public class ReshapetheMatrix566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;

    }
    public static void main(String[] args) {
        ReshapetheMatrix566 obj=new ReshapetheMatrix566();
        int array[][]={{1,2},{3,4}};

        System.out.print(Arrays.deepToString(obj.matrixReshape(array,1,4)));
    }
}

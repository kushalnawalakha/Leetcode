package Hard;

import java.util.ArrayList;
import java.util.List;

public class SplitArray {
    Boolean done = false;

    public static void main(String[] args) {
        SplitArray array = new SplitArray();
        array.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    public void helper(int A[], int prev_i, List<Integer> list, double sum, double maxSum) {

        if (list.size() == A.length || done) {
            return;
        }
        if (list.size() != 0 && sum / list.size() == (maxSum - sum) / (A.length - list.size())) {
            done = true;
            return;
        }
        for (int i = prev_i; i < A.length; i++) {
            list.add(A[i]);
            helper(A, i + 1, list, sum + A[i], maxSum);
            list.remove(list.size() - 1);
        }
    }

    public boolean splitArraySameAverage(int[] A) {
        double maxSum = 0;
        for (int a : A) {
            maxSum = maxSum + a;
        }
        done = false;
        helper(A, 0, new ArrayList<Integer>(), 0.0, maxSum);
        return done;
    }

}

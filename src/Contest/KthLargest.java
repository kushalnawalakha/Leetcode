package Contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kushal on 8/26/17.
 */
public class KthLargest {
    public static int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low != high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 1; i <= m; ++i) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;

    }

    public static void main(String[] args) {
        System.out.print(findKthNumber(5,5,6));
    }
}

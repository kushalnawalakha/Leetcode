package Amazon;

import java.util.Arrays;

public class SimpleQuery {
    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        int output[] = new int[maxes.length];
        int i = 0;
        for (int max : maxes) {
            int loc = Arrays.binarySearch(nums, max);
            if (loc < 0)
                loc = -loc - 1;
            else if (nums[loc] == max)
                loc = loc + 1;
            output[i++] = loc;
            System.out.println(loc);
        }
        return output;
    }

    public static void main(String[] args) {
        SimpleQuery simpleQuery = new SimpleQuery();

        counts(new int[]{1, 4, 2, 4}, new int[]{3, 5});
    }
}

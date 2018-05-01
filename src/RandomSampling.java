import java.util.Random;

/**
 * Created by kushaln on 3/4/2018.
 */
public class RandomSampling {
    int[] nums;
    Random rnd;

    public RandomSampling(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    public static void main(String[] args) {


        int[] nums = new int[] {1,2,3,3,3};
        RandomSampling sampling=new RandomSampling(nums);
        sampling.pick(3);
    }
}



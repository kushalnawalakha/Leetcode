package Medium;

/**
 * Created by kusha on 5/23/2017.
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            }
            else if (n <= big) {
                big = n;
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int array[]={10,5,4,3,2,11,12};
        System.out.print(new IncreasingTriplet().increasingTriplet(array));
    }
}

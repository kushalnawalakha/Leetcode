package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kusha on 5/13/2017.
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies)
            kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
    public static void main(String[] args) {
        DistributeCandies575 obj=new DistributeCandies575();
        int array[]={0,0,14,0,10,0,0,0};
        System.out.print(obj.distributeCandies(array));
    }
}

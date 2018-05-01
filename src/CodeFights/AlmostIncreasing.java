package CodeFights;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by kusha on 8/6/2017.
 */
public class AlmostIncreasing {
    static boolean almostIncreasingSequence(int[] arr) {
        int array[]=Arrays.copyOf(arr,arr.length);
        Arrays.sort(array);
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=array[i]){
                count++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int array[]={1, 3, 2, 1};
        almostIncreasingSequence(array);
    }

}

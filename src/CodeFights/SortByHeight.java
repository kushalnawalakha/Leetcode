package CodeFights;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by kusha on 8/6/2017.
 */
public class SortByHeight {
    static int[] sortByHeight(int[] a) {
        Stack stack=new Stack();

        int array[]=Arrays.copyOf(a,a.length);
        Arrays.sort(array);
        int i=0;
        while(i<a.length&&array[i]==-1){
            i++;
        }

        int j=0;
        while(i<a.length){
            while(a[j]==-1){
                j++;
            }
            a[j]=array[i];
            i++;
            j++;
        }
        return array;

    }

    public static void main(String[] args) {
        int array[]={-1, 150, 190, 170, -1, -1, 160, 180};
        sortByHeight(array);
    }

}

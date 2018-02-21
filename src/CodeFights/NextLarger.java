package CodeFights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by kusha on 8/5/2017.
 */
public class NextLarger {
    static int[] nextLarger(int[] a) {
        int[] output = new int[a.length];
        for(int i = 0, l = output.length; i < l; i++)
            output[i] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1, pointerToSmall = 0, l = a.length; i < l; i++){
            while(!stack.isEmpty() && a[stack.peek()] < a[i]){
                pointerToSmall = stack.pop();
                output[pointerToSmall] = a[i];
            }
            stack.push(i);
        }

        return output;
    }

    public static void main(String[] args) {
        int arr[]={6,3,3,8};
        System.out.println(Arrays.toString(nextLarger(arr)));
    }

}

package CodeFights;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by kusha on 8/3/2017.
 */
public class KthLargest {
    static int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++) {
            if(queue.peek()<nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int array[]={5,6,5,4,3,7,8};
        int k=2;
        Stack stk=new Stack();
        String str;
        System.out.println(kthLargestElement(array,k));
    }

}

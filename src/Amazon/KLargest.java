package Amazon;

import java.util.PriorityQueue;

public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int num:nums){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int array[]={3,2,1,5,6,4};
        KLargest kLargest=new KLargest();
        kLargest.findKthLargest(array,2);
    }

}

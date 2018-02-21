package Contest;

import java.util.PriorityQueue;

public class SmallestDistancePair {
    public static int smallestDistancePair(int[] nums, int k) {

        PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a, b)->b-a);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                queue.offer(Math.abs(nums[i]-nums[j]));
                if(queue.size()>k){
                    queue.poll();
                }
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int nums[]={1,3,1};
        System.out.println(smallestDistancePair(nums,1));
    }
}

package Amazon;

import java.util.PriorityQueue;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0||nums==null||nums.length==0){
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        PriorityQueue<int[]> q=new PriorityQueue<>((a, b)->b[0]-a[0]);
        int max[]=new int[nums.length-k+1];
        int i=0;
        for(i=0;i<k;i++){
            int temp[]=new int[2];
            temp[0]=nums[i];
            temp[1]=i;
            q.offer(temp);
        }
        int n=0;
        max[n++]=q.peek()[0];

        for(;i<nums.length;i++){
            int temp[]=new int[2];
            temp[0]=nums[i];
            temp[1]=i;
            q.offer(temp);
            while(q.peek()[1]<=i-k){
                q.poll();
            }
            max[n++]=q.peek()[0];
        }
        return max;
    }

    public static void main(String[] args) {
        int array[]={7,2,4};
        SlidingWindow slidingWindow=new SlidingWindow();
        slidingWindow.maxSlidingWindow(array,2);
    }
}

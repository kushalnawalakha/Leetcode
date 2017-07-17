package Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kusha on 7/2/2017.
 */
public class MaxProduct628 {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> dec=new PriorityQueue();
        PriorityQueue<Integer> asc=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        for(int i=0;i<nums.length&&i<3;i++){
            asc.add(nums[i]);
            dec.add(nums[i]);
        }

        for(int i=3;i<nums.length;i++){
            asc.add(nums[i]);
            dec.add(nums[i]);
            asc.poll();
            dec.poll();
        }
        asc.remove();
        int negSum=asc.poll()*asc.poll();

        int top1=dec.poll();
        int top2=dec.poll();
        int top3=dec.poll();

        if(top1*top2>negSum){
            return top1*top2*top3;
        }else{
            return top3*negSum;
        }


    }
    public static void main(String[] args) {
        int nums[]={1,2,-3,-4};
        MaxProduct628 maxProduct628=new MaxProduct628();
        maxProduct628.maximumProduct(nums);
    }
}

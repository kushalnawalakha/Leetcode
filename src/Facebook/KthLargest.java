package Facebook;

/**
 * Created by kusha on 1/27/2018.
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    public int partition(int nums[],int lo,int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && nums[++i] < nums[lo]) ;
            while (j > lo && nums[--j] > nums[lo]) ;
            if (i >= j) {
                break;
            }
            exch(nums, i, j);

        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int a[],int i,int j){
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int nums[]={1,3,2,1,5,6,4};
        KthLargest k=new KthLargest();
        k.findKthLargest(nums,3);
    }

}

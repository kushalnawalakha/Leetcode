package Contest;

/**
 * Created by kushal on 8/26/17.
 */
public class IsIncreasing {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(i+1<nums.length&&nums[i-1]<nums[i+1]){
                    nums[i] = nums[i+1];
                }else if(i+1==nums.length){
                    nums[i] = nums[i-1];
                }else{
                    nums[i - 1] = nums[i];
                }
                count++;
            }
        }
        if(count>1){
            return false;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int array[]={1,2,4,5,3};
        IsIncreasing i=new IsIncreasing();
        System.out.println(i.checkPossibility(array));
    }
}

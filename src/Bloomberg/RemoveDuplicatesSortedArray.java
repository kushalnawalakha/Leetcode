package Bloomberg;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int prev=nums[0];
        int current=0;
        nums[current]=prev;
        current++;
        for(int i=1;i<nums.length;i++){
            while(i<nums.length&&prev==nums[i]){
                i++;
            }
            if(i<nums.length){
                prev=nums[i];
            }else{
                break;
            }
            nums[current++]=prev;
        }
        return current;
    }

    public static void main(String[] args) {

        int array[]={1,1,2};
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray=new RemoveDuplicatesSortedArray();
        removeDuplicatesSortedArray.removeDuplicates(array);
    }
}

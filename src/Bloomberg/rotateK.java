package Bloomberg;

public class rotateK {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int temp[]=new int[nums.length-k];
        for(int i=0;i<nums.length-k;i++){
            temp[i]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=nums[nums.length-k+i];
        }
        int p=0;
        for(int i=k;i<nums.length;i++){
            nums[i]=temp[p++];
        }
    }

    public static void main(String[] args) {
        rotateK rotateK=new rotateK();
        rotateK.rotate(new int[]{1,2,3,4,5},1);
    }
}

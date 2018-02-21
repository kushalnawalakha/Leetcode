package Medium;

/**
 * Created by kushal on 10/10/17.
 */
public class PredictTheWinner {
    int score1=0,score2=0;
    public boolean helper(int nums[],int left,int right,boolean play1){
        if(left>right){
            if(score1>score2){
                return true;
            }else{
                return false;
            }
        }

        int max=0;
        boolean isLeft=false;
        if(nums[left]>nums[right]){
            max=nums[left];
            isLeft=true;
        }else{
            max=nums[right];
        }
        if(play1)
                score1=score1+max;
        else
            score2=score2+max;

        if(helper(nums,left+(isLeft?1:0),right-(!isLeft?1:0),!play1)||helper(nums,left,right-1,!play1)){
            return true;
        }else{
            return false;
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums,0,nums.length-1,false);
    }
    public static void main(String[] args) {
        PredictTheWinner predictTheWinner=new PredictTheWinner();
        predictTheWinner.PredictTheWinner(new int[]{1,5,233,7});
    }
}

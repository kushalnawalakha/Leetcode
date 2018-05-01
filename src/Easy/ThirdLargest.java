package Easy;

/**
 * Created by kusha on 11/2/2017.
 */
public class ThirdLargest {
    public static int thirdMax(int[] nums) {
        Integer min=null;
        Integer secondMin=null;
        Integer thirdMin=null;
        for(int num:nums){
            if(min==null||min<num){
                thirdMin=secondMin;
                secondMin=min;
                min=num;
            }
            else if(secondMin==null||(secondMin<num&&min!=num)){
                thirdMin=secondMin;
                secondMin=num;
            }else if(thirdMin==null||(thirdMin<num&&secondMin!=num&&min!=num)){
                thirdMin=num;
            }
        }
        if(thirdMin==null){
            return min;
        }
        return thirdMin;
    }

    public static void main(String[] args) {
        int nums[]={1,2,Integer.MIN_VALUE};
        thirdMax(nums);
    }

}

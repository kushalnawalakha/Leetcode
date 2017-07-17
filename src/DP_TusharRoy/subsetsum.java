package DP_TusharRoy;

/**
 * Created by kusha on 6/17/2017.
 */
public class subsetsum {
    public static boolean recursive(int nums[], int total,int current){
        if(current==0){
            return true;
        }else if(current<0){
            return false;
        }
        for(int num:nums){
            if(recursive(nums,total,current-num)){
                return true;
            }
        }
        return false;
    }
    public static void dp(int nums[], int total){
        int dpArray[][]=new int[nums.length][total+1];
        dpArray[0][nums[0]]=1;
        dpArray[0][0]=1;
        for (int j=1;j<nums.length;j++){
            dpArray[j][0]=1;
            for(int i=1;i<=total;i++){
                if(i-nums[j]>=0&&dpArray[j-1][i-nums[j]]==1){
                    dpArray[j][i]=1;
                }else if(dpArray[j-1][i]==1){
                    dpArray[j][i]=1;
                }
            }
        }

        for(int i=0;i<dpArray.length;i++){
            for(int j=0;j<dpArray[0].length;j++){
                System.out.print(dpArray[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nums[]={2,3,7,8,10};
        dp(nums,11);
    }
}

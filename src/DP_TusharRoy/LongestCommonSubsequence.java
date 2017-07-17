package DP_TusharRoy;

/**
 * Created by kusha on 6/17/2017.
 */
public class LongestCommonSubsequence {
    public static void solve(String str1,String str2){
        int dpArray[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dpArray[i][j]=Math.max(dpArray[i-1][j],dpArray[i][j-1])+1;
                }else{
                    dpArray[i][j]=Math.max(dpArray[i-1][j],dpArray[i][j-1]);
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
        solve("abcdaf","acbcf");
    }
}

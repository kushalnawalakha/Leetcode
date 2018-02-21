package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquare {
    public ArrayList<Integer> getSquares(int maxValue){
        int maxSquare=(int)Math.sqrt(maxValue);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=maxSquare;i++){
            list.add(i*i);
        }
        return list;
    }

    public int numSquares(int n) {
        ArrayList<Integer> list=getSquares(n);
        int dpArray[][]=new int[list.size()+1][n+1];
        Arrays.fill(dpArray[0],Integer.MAX_VALUE);
        for(int i=1;i<=list.size();i++){
            for(int j=1;j<=n;j++){
                if(j-list.get(i-1)==0||(j>list.get(i-1)&&dpArray[i][j-list.get(i-1)]>0)){
                    dpArray[i][j]=Math.min(dpArray[i][j-list.get(i-1)]+1,dpArray[i-1][j]);
                }else{
                    dpArray[i][j]=dpArray[i-1][j];
                }
            }
        }
        return dpArray[list.size()][n];
    }
    public static void main(String[] args) {
        PerfectSquare perfectSquare=new PerfectSquare();
        perfectSquare.numSquares(13);
    }
}

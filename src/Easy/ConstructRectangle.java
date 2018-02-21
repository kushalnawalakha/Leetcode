package Easy;

/**
 * Created by kushal on 10/16/17.
 */
class Solution {
    public static int[] constructRectangle(int area) {
        int out[]=new int[2];
        int min=Integer.MAX_VALUE;
        if(area==1){
            out[0]=1;
            out[1]=1;
        }
        for(int i=1;i<=area/2;i++){
            if(area%i==0){
                int temp=area/i;
                if(min>Math.abs(i-temp)){
                    min=Math.abs(i-temp);
                    out[1]=i;
                    out[0]=temp;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(constructRectangle(4));
    }
}

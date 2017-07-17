package Medium;

import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class MaxSPeed {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int testCases=scanner.nextInt();
        for(int i=0;i<testCases;i++){
            int carCount=scanner.nextInt();
            int min=Integer.MAX_VALUE;
            int count=0;
            for(int j=0;j<carCount;j++){
                int current=scanner.nextInt();
                if(current<min){
                    min=current;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

package HackerRank.Warmup;

import java.util.Scanner;

/**
 * Created by kusha on 8/6/2017.
 */
public class DiagonalDifference {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            int sum1=0,sum2=0;
            for(int i=0;i<x;i++){
                for(int j=0;j<x;j++){
                    int t=sc.nextInt();
                    if(i==j){

                        System.out.println(t+" "+(x-i-1)+" "+j);
                        sum1=sum1+t;
                    }
                    if((x-i-1)==j){
                        System.out.println(t);
                        sum2=sum2+t;
                    }
                }
            }
            System.out.println(Math.abs(sum1-sum2));

        }
}

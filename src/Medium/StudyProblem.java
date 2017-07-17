package Medium;

import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class StudyProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            long k=sc.nextLong();
            int j=0;
            int t=0;
            for(j=1;;j=j*2){
                long cnt=0;
                t=j;
                cnt=d;
                cnt=cnt+c*t;
                t=t*j;
                cnt=cnt+b*t;
                t=t*j;
                cnt=cnt+a*t;
                if(cnt>k){
                    break;
                }
            }

            for(int n=j/2;n<=j;n++){
                long cnt=0;
                t=n;
                cnt=d;
                cnt=cnt+n*t;
                t=t*n;
                cnt=cnt+b*t;
                t=t*n;
                cnt=cnt+a*t;
                if(cnt>k){
                    System.out.println(n-1);
                    break;
                }
            }

        }
    }
}

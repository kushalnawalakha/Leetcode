package HackerRank.Goldman;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kusha on 8/18/2017.
 */
public class BankAccounts {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int pn=scanner.nextInt();
            int k=scanner.nextInt();
            double x=(double) scanner.nextInt()/100;
            double d=scanner.nextInt();
            double couldBe=0;
            for(int pi=0;pi<pn;pi++){
                couldBe=couldBe+Math.max((double) k,(double) scanner.nextInt()*x);
            }
            if(couldBe>d){
                System.out.print("upfront");
            }else{
                System.out.print("fee");
            }
        }
    }
}

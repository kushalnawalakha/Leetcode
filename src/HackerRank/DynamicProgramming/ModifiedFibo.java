package HackerRank.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kusha on 8/10/2017.
 */
public class ModifiedFibo {
        public static void main(String args[] ) throws Exception {
            Scanner sc=new Scanner(System.in);
            BigInteger i3=BigInteger.ZERO;
            BigInteger i1=BigInteger.valueOf(sc.nextInt());
            BigInteger i2=BigInteger.valueOf(sc.nextInt());
            int n=sc.nextInt();

            for(int i=2;i<n;i++){
                i3=i1.add(i2.multiply(i2));
                i1=i2;
                i2=i3;
            }
            System.out.print(i3);
        }
    }

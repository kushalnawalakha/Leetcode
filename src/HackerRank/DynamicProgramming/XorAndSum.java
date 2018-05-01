package HackerRank.DynamicProgramming;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by kusha on 8/17/2017.
 */
public class XorAndSum {

    public static void main(String[] args) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
        }

        String num1=scanner.next();
        String num2=scanner.next();
        BigInteger bnum1=new BigInteger(num1,2);
        BigInteger bnum2=new BigInteger(num2,2);
        BigInteger outcome=BigInteger.ZERO;

        List<List<String>> a=new ArrayList<>();

        ArrayList<String> arrayList=new ArrayList<>();
        for(int k=0;k<num1.length();k++){
            arrayList.add(num1.substring(k)+num1.substring(0,k));
        }
        System.out.println(arrayList);
        int i=0,j=0;
        for(;i<=314159;i++){
            outcome=outcome.add(bnum1.xor(bnum2));
            j=(j+1)%num2.length();
            bnum2=new BigInteger(arrayList.get(j),2);
        }
        System.out.println(outcome.mod(BigInteger.valueOf((long)Math.pow(10,9)+7)));

    }
}

package Amazon;

import java.util.ArrayList;

/**
 * Created by kushal on 10/24/17.
 */
public class CountPrimes {
    public boolean isPrimeNumber(int num,ArrayList<Integer> prev){
        int sqrt=(int)Math.sqrt(num)+1;
        for(Integer p:prev){
            if(num%p==0){
                return false;
            }
            if(p>sqrt){
                return true;
            }
        }
        return true;

    }

    public int countPrimes(int n) {
        int count=2;
        if(n<=2){
            return 0;
        }
        if(n<=3){
            return 1;
        }
        if(n<=5){
            return 2;
        }
        ArrayList<Integer> prev=new ArrayList<>();
        prev.add(2);
        prev.add(3);
        for(int i=6;i<=n;i=i+6){
            if(isPrimeNumber(i-1,prev)){
                prev.add(i-1);
            }
            if(isPrimeNumber(i+1,prev)){
                prev.add(i+1);
            }
        }
        if(prev.get(prev.size()-1)>=n){
            return prev.size()-1;
        }
        return prev.size();

    }

    public static void main(String[] args) {
        CountPrimes countPrimes=new CountPrimes();
        System.out.println(countPrimes.countPrimes(10000));
    }
}

package Medium;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class CommonDivisers {
    public static int check(ArrayList<Long> arrayList,long num){
        for(long val:arrayList){
            if(val%num!=0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int tot=scanner.nextInt();
        for (int i=0;i<tot;i++){
            long num1=scanner.nextLong();
            long num2=scanner.nextLong();
            long num3=scanner.nextLong();
            long smallest=Math.min(num1,num2);
            smallest=Math.min(smallest,num3);

            if(smallest==0){
                System.out.println(0);
            }else {
                long cnt=1;
                ArrayList<Long> arrayList=new ArrayList<>();
                arrayList.add(num1);
                arrayList.add(num2);
                arrayList.add(num3);
                Collections.sort(arrayList);
                if(num2%num1==0){
                    arrayList.remove(num2);
                }
                if(num3%num1==0){
                    arrayList.remove(num3);
                }
                if(num3%num2==0){
                    arrayList.remove(num3);
                }
                cnt=cnt+check(arrayList,2)+check(arrayList,3);
                for (long j=6;j<=smallest;j++) {
                    cnt=cnt+check(arrayList,j-1)+check(arrayList,j+1);
                }
                System.out.println(cnt);
            }
        }
    }
}

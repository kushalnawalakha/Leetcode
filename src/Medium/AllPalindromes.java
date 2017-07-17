package Medium;

import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class AllPalindromes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        boolean array[][]=new boolean[str.length()][str.length()];
        int count=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                array[i][j]=true;
                count++;
                for(int k=0;k<=j-i;k++){
                    if(str.charAt(i+k)!=str.charAt(j-k)){
                        array[i][j]=false;
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
/*
  d s k j k d
d t f f
s   t f f
k     t f t
j       t f
k         t f
d           t
*/

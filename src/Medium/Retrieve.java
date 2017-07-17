package Medium;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class Retrieve {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int r=scanner.nextInt();
        int c=scanner.nextInt();
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int array[]={i,j};
                map.put(scanner.nextInt(),array);
            }
        }
        int querries=scanner.nextInt();
        int notpresent[]={-1,-1};
        for(int i=0;i<querries;i++){
            int arr[]=map.getOrDefault(scanner.nextInt(),notpresent);
            System.out.println(arr[0]+" "+arr[1]);
        }
    }
}

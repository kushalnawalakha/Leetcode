package Medium;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class Travel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cityCoutn=sc.nextInt();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<cityCoutn;i++){
            map.put(sc.next(),i);
        }
        int cost[][]=new int[cityCoutn][cityCoutn];
        for(int i=0;i<cityCoutn;i++){
            for(int j=0;j<cityCoutn;j++){
                cost[i][j]=sc.nextInt();
            }
        }
        int cnt=sc.nextInt();
        long totCost=0;
        int prev=0;
        for(int i=0;i<cnt;i++){
            int next=map.get(sc.next());
            totCost=totCost+cost[prev][next];
            prev=next;
        }
        System.out.println(totCost);

    }
}

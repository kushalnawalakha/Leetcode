package Medium;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by kushal on 5/29/17.
 */
public class Timeland {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for(int i=0;i<num;i++){
            int slipCount=scanner.nextInt();
            int k=scanner.nextInt();
            int slips[]=new int[slipCount];
            for(int j=0;j<slipCount;j++){
                slips[j]=scanner.nextInt();
            }
            PriorityQueue<int[]> priorityQueue=new PriorityQueue();
            for(int j=0;j<k+1;j++){
                int array[]=new int[2];
                if(slips[j]>0){
                    array[0]=slips[j];
                    array[1]=j;
                }
                priorityQueue.add(array);
            }

            for(int j=k+1;j<slipCount-k;j++){
                           }

        }
    }
}

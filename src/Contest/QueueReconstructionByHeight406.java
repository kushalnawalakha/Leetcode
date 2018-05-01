package Contest;

import java.util.*;

/**
 * Created by kushal on 8/27/17.
 */
public class QueueReconstructionByHeight406 {
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,(int a[],int b[])->a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        ArrayList<int[]> list=new ArrayList<>();
        int max=people[people.length-1][0];
        int i=0;
        for(i=people.length-1;i>=0&&people[i][0]==max;i--){
            list.add(people[i]);
        }
        for(;i>=0;i--){
            list.add(people[i][1],people[i]);
        }
        int out[][]=list.toArray(new int[list.size()][]);
        return out;
    }

    public static int newInteger(int n) {


        return Integer.parseInt(Long.toString(n, 9));

    }


    public static void main(String[] args) {
        int array[][]={{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}};
//        reconstructQueue(array);
        System.out.print(newInteger(10));
    }
}

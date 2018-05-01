package Facebook;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Created by kusha on 2/2/2018.
 */
public class ReconstructTree {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int []o1,int []o2){
                return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        ArrayList<int[]> list=new ArrayList();
        for(int person[]:people){
            int i=0;
            for(int[] l:list){
                if(l[1]>person[1])
                    break;
                i++;
            }
            if(i!=list.size())
                list.add(i,person);
            else
                list.add(person);
        }
        int i=0;
        for(int[] output:list){
            people[i++]=output;
        }

        return people;
    }

    public static void main(String[] args) {
        int people[][]={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        ReconstructTree r=new ReconstructTree();
//        r.reconstructQueue(people);
        String s="223";
        int count=s.split("2").length;
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        System.out.println(count);
    }
}

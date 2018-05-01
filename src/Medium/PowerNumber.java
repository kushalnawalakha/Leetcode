package Medium;

import java.util.*;

/**
 * Created by kusha on 3/3/2018.
 */
public class PowerNumber {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        TreeMap<String, String> map = new TreeMap();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);


//        PowerNumber number=new PowerNumber();
//        System.out.println(number.powerNumber(10000));
    }

    public long powerNumber(int num) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        ArrayList<Long> list = new ArrayList<>();
        queue.offer(new long[]{4L, 2, 2});
        list.add(4L);
        while (list.size() <= num) {
            long l[] = queue.poll();
            if (list.get(list.size() - 1) != l[0]) {
                list.add(l[0]);
            }
            queue.offer(new long[]{(long) Math.pow(l[1] + 1, l[2]), l[1] + 1, l[2]});
            queue.offer(new long[]{(long) Math.pow(l[1], l[2] + 1), l[1], l[2] + 1});
        }
        return list.get(list.size() - 1);
    }
}

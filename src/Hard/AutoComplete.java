package Hard;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by kusha on 2/26/2018.
 */
public class AutoComplete {
    public static void main(String[] args) {
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        String n = "\t\t\tabc";
        System.out.println(n.replaceAll("\t", "").length());


    }
}

package PermutationAndCombination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        Permute permute=new Permute();
        permute.permute(nums);
    }
}

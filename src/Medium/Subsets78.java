package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kusha on 5/23/2017.
 */
public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String sp[]){
        Subsets78 subsets78=new Subsets78();
        int array[]={1,2,3};
        subsets78.subsets(array);
    }
}

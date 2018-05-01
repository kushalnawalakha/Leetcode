package PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

public class Combination_NoDuplicates {

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        Combination_NoDuplicates combination_noDuplicates=new Combination_NoDuplicates();
        combination_noDuplicates.subsets(nums);
    }
}

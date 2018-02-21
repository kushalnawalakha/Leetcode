package Medium;

import DataStructures.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kusha on 8/16/2017.
 */
public class MaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
        if(start>end){
            return null;
        }
        int max=Integer.MIN_VALUE;
        int loc=0;
        for(int i=start;i<=end;i++){
            if(max<nums[i]){
                loc=i;
                max=nums[i];
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=constructMaximumBinaryTree(nums,start,loc-1);
        node.right=constructMaximumBinaryTree(nums,loc+1,end);
        return node;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
         return constructMaximumBinaryTree(nums,0,nums.length-1);
    }



    public static void main(String[] args) {
        Queue<TreeNode> queue=new LinkedList<>();
        int nums[]={3,2,1,6,0,5};
        TreeNode node=constructMaximumBinaryTree(nums);
    }
}

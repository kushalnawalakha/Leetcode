package Medium;

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumToLeaf {
    public void helper(TreeNode root, int sum, ArrayList<Integer> list, List<List<Integer>> output)
    {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(sum-root.val==0){
                output.add((ArrayList)list.clone());
                output.get(output.size()-1).add(root.val);
            }
        }
        list.add(root.val);
        helper(root.left,sum-root.val,list,output);
        helper(root.right,sum-root.val,list,output);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        helper(root,sum,new ArrayList<>(),list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode t1=new TreeNode(4);
        root.left=t1;
        TreeNode t2=new TreeNode(8);
        root.right=t2;
        TreeNode t3=new TreeNode(11);
        t1.left=t3;
        TreeNode t5=new TreeNode(13);
        TreeNode t6=new TreeNode(4);
        t2.left=t5;
        t2.right=t6;
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(2);
        t3.left=t7;
        t3.right=t8;
        TreeNode t11=new TreeNode(5);
        TreeNode t12=new TreeNode(1);
        t6.left=t11;
        t6.left=t12;
        SumToLeaf sumToLeaf=new SumToLeaf();
        System.out.println(sumToLeaf.pathSum(root,22));

    }
}

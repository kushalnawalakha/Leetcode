package Easy;

import DataStructures.TreeNode;

/**
 * Created by kusha on 7/2/2017.
 */
public class SumOfLeftSubTree404 {
    int temp=0;
    public void sumOfLeftLeaves(TreeNode root,boolean isLeft) {
        if(root==null){
            return;
        }
        if(root!=null && root.right==null&&root.left==null&&isLeft){
            temp=temp+root.val;
            return;
        }
        sumOfLeftLeaves(root.left,true);
        sumOfLeftLeaves(root.right,false);
    }

    public int sumOfLeftLeaves(TreeNode root){
        temp=0;
        sumOfLeftLeaves(root,false);
        return temp;
    }

    public static void main(String strp[]){
        TreeNode root1=new TreeNode(3);
        TreeNode root2=new TreeNode(9);
        TreeNode root3=new TreeNode(20);
        TreeNode root4=new TreeNode(15);
        TreeNode root5=new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        root3.right=root5;

        SumOfLeftSubTree404 s2b=new SumOfLeftSubTree404();
        s2b.sumOfLeftLeaves(root1);
    }
}

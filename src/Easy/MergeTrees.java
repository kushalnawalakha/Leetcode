package Easy;

/**
 * Created by kusha on 7/1/2017.
 */

import DataStructures.TreeNode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MergeTrees {
    TreeNode root=null;

    public void mergeTrees(TreeNode t1, TreeNode t2,TreeNode root) {
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        root=null;
        mergeTrees(t1,t2);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1_1=new TreeNode(1);
        TreeNode root1_2=new TreeNode(3);
        TreeNode root1_3=new TreeNode(2);
        TreeNode root1_4=new TreeNode(5);

        root1_1.left=root1_2;
        root1_1.right=root1_3;
        root1_2.left=root1_4;

        TreeNode root2_1=new TreeNode(2);
        TreeNode root2_2=new TreeNode(1);
        TreeNode root2_3=new TreeNode(3);
        TreeNode root2_4=new TreeNode(4);
        TreeNode root2_5=new TreeNode(7);

        root2_1.left=root2_2;
        root2_1.right=root2_3;
        root2_2.right=root2_4;
        root2_3.right=root2_5;

        MergeTrees mergeTrees=new MergeTrees();
        mergeTrees.mergeTrees(root1_1,root2_1);
    }
}
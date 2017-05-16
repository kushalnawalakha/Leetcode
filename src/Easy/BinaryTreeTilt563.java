package Easy;

import DataStructures.TreeNode;

/**
 * Created by kusha on 5/16/2017.
 */
public class BinaryTreeTilt563 {
    int result=0;
    public int findTilt1(TreeNode root) {
        if(root==null){
            return 0;
        }
        result=result+ Math.abs(findTilt1(root.left)-findTilt1(root.right));
        return root.val;
    }

    public int findTilt(TreeNode root) {
        findTilt1(root);
        return result;
    }


    public static void main(String[] args) {

    }
}

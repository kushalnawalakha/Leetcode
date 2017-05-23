package Medium;

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kusha on 5/20/2017.
 */
public class BinaryTreeInorder94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
    public static void main(String[] args) {

    }
}

package Easy;

import DataStructures.TreeNode;

/**
 * Created by kusha on 7/2/2017.
 */
public class StringToBinary606 {
    StringBuilder str=new StringBuilder();
    public void solve(TreeNode t) {
        if(t==null){
            return;
        }
        str.append(t.val);
        if(t.left==null&&t.right==null){
            return;
        }else if(t.left!=null&&t.right!=null){
            str .append("(");
            solve(t.left);
            str .append( ")");
            str  .append("(");
            solve(t.right);
            str  .append( ")");
        }
        else if (t.left==null){
            str  .append( "()");
            str  .append( "(");
            solve(t.right);
            str  .append( ")");
        }else {
            str  .append( "(");
            solve(t.left);
            str  .append( ")");
        }



    }

    public String tree2str(TreeNode t) {
        str=new StringBuilder();
        solve(t);
        System.out.println(str);
        return str.toString();
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;

        StringToBinary606 s2b=new StringToBinary606();
        s2b.tree2str(root1);
    }
}

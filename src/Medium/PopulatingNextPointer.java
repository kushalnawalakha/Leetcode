package Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kusha on 2/10/2018.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextPointer {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        Queue<TreeLinkNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            TreeLinkNode prev=null;
            while(count>0){
                TreeLinkNode current=queue.poll();
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
                count--;
                if(prev!=null){
                    prev.next=current;
                }
                prev=current;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode t1=new TreeLinkNode(1);
        TreeLinkNode t2=new TreeLinkNode(2);
        TreeLinkNode t3=new TreeLinkNode(3);
        t1.left=t2;
        t1.right=t3;
        PopulatingNextPointer populatingNextPointer=new PopulatingNextPointer();
        populatingNextPointer.connect(t1);
        LinkedList<Integer> linkedList=new LinkedList<>();
    }
}

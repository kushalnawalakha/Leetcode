package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

 class TreeLinkNode {
int val;
TreeLinkNode left, right, next;
TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextNode {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=1,newCount=0;
        while(!queue.isEmpty()){
            TreeLinkNode prev=null;
            newCount=0;
            for(int i=0;i<count;i++){
                TreeLinkNode current=queue.poll();
                if(prev==null)
                    prev=current;
                else
                    prev.next=current;

                if(current.left!=null){
                    newCount++;
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    newCount++;
                    queue.offer(current.right);
                }

            }
            count=newCount;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode1=new TreeLinkNode(2);
        TreeLinkNode treeLinkNode2=new TreeLinkNode(3);
        treeLinkNode1.left=treeLinkNode2;
        PopulatingNextNode populatingNextNode=new PopulatingNextNode();
        populatingNextNode.connect(treeLinkNode1);
    }
}

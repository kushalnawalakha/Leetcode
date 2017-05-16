package Easy;

import DataStructures.ListNode;

import java.util.Stack;

/**
 * Created by kusha on 5/16/2017.
 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        if (head==null){
            return null;
        }
        while(head.next!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode temp=head;
        while(!stack.isEmpty()){
            temp.next=stack.pop();
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public static void main(String s[]){
        int array[]={1,2,3,4,5};
        ListNode head=ListNode.getList(array);
        ReverseLinkedList206 reverseLinkedList206=new ReverseLinkedList206();
        reverseLinkedList206.reverseList(head);
        ListNode.print(head);
    }
}

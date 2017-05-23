package Medium;

import DataStructures.ListNode;

/**
 * Created by kusha on 5/21/2017.
 */
public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddCurrent=head;
        if(oddCurrent==null){
            return head;
        }
        ListNode evenhome=head.next;
        ListNode evenCurrent=evenhome;
        if(evenhome==null){
            return head;
        }
        ListNode current=evenCurrent.next;
        ListNode next;
        int i=3;
        while (current!=null){
            next=current.next;
            if(i%2==0){
                evenCurrent.next=current;
                evenCurrent=evenCurrent.next;
            }else {
                oddCurrent.next=current;
                oddCurrent=oddCurrent.next;
            }
            current=next;
            i++;
        }
        evenCurrent.next=null;
        oddCurrent.next=evenhome;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        OddEvenLinkedList328 obj=new OddEvenLinkedList328();
        ListNode o=obj.oddEvenList(listNode1);
        while (o!=null){
            System.out.println(o.val);
            o=o.next;
        }
    }
}

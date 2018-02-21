package Amazon;

import DataStructures.ListNode;

public class IntersectionOfTwoLinkedList {
    private int getLength(ListNode head){
        int l=0;
        while(head!=null){
            l++;
            head=head.next;
        }
        return l;
    }

    private ListNode moveAheadBy(ListNode head,int k){
        for(int i=0;i<k;i++){
            head=head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode head1=headA;
        ListNode head2=headB;
        int l1=getLength(head1);
        int l2=getLength(head2);
        head1=headA;
        head2=headB;
        if(l1>l2){
            head1=moveAheadBy(head1,l1-l2);
        }else if(l1<l2){
            head2=moveAheadBy(head2,l2-l1);
        }
        while(head1!=null&&head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        listNode1.next=listNode2;
        IntersectionOfTwoLinkedList i=new IntersectionOfTwoLinkedList();
        i.getIntersectionNode(listNode1,listNode2);
     }
}

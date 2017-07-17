package CTCI;

import DataStructures.ListNode;

/**
 * Created by kusha on 7/17/2017.
 */
public class LinkedListPalindrome {
    ListNode home=null;

    public boolean isPalindome(ListNode listNode){
        boolean b=true;
        if(listNode==null){
            return true;
        }
        b=isPalindome(listNode.next);
        if(home.val!=listNode.val){
            b= false;
        }
        home=home.next;
        return b;

    }
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(3);
        ListNode listNode7=new ListNode(2);
        ListNode listNode8=new ListNode(1);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        listNode7.next=listNode8;

        LinkedListPalindrome linkedListPalindrome=new LinkedListPalindrome();
        linkedListPalindrome.home=listNode1;
        System.out.println(linkedListPalindrome.isPalindome(listNode1));
    }

}

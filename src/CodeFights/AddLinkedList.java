package CodeFights;

import DataStructures.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by kusha on 7/26/2017.
 */
public class AddLinkedList {
    ListNode formLinkedList(int array[]){
        ListNode home=new ListNode(array[0]);
        ListNode prev=home;
        for(int i=1;i<array.length;i++){
            ListNode next=new ListNode(array[i]);
            prev.next=next;
            prev=prev.next;
        }
        return home;
    }

    ListNode reverse(ListNode l){
         ListNode home=l;
        ListNode prev=null;
        ListNode next=l;
        while(home!=null){
            next=home.next;
            home.next=prev;
            prev=home;
            home=next;
        }
        return prev;
    }
    ListNode addTwoHugeNumbers(ListNode a, ListNode b) {
        a=reverse(a);
        b=reverse(b);
        ListNode temp=new ListNode(0);
        ListNode home=temp;
        int carry=0;
        while(a!=null&&b!=null){
            int sum=a.val+b.val;
            temp.next=new ListNode(sum%10000+carry);
            carry=sum/10000;
            a=a.next;
            b=b.next;
            temp=temp.next;

        }
        while(a!=null){
            int sum=a.val;
            temp.next=new ListNode(sum%10000+carry);
            carry=sum/10000;
            a=a.next;
            temp=temp.next;
        }
        while(b!=null){
            int sum=b.val;
            temp.next=new ListNode(sum%10000+carry);
            carry=sum/10000;
            b=b.next;
            temp=temp.next;
        }
        return reverse(home.next);
    }

    public static void main(String[] args) {
        int array1[]={9876, 5432, 1999};
        int array2[]={1, 8001};
        AddLinkedList a=new AddLinkedList();
        a.addTwoHugeNumbers(a.formLinkedList(array1),a.formLinkedList(array2));
    }
}

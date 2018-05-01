package Medium;

import DataStructures.ListNode;

/**
 * Created by kusha on 2/25/2018.
 */
public class LinkedListSort {
    public static void main(String[] args) {
        String s = "";

        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        LinkedListSort linkedListSort = new LinkedListSort();
        ListNode root = linkedListSort.sortList(l1);
        root.print();
    }

    private ListNode findMid(ListNode head) {
        ListNode p1 = head, p2 = head, prev = null;
        while (p2 != null && p2.next != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode temp = p1.next;
        if (p2 != null) {
            p1.next = null;
        } else {
            prev.next = null;
        }

        return p2 == null ? p1 : temp;
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = findMid(head);
        ListNode root1 = helper(head);
        ListNode root2 = helper(newhead);
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        while (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                temp.next = root1;
                root1 = root1.next;
            } else {
                temp.next = root2;
                root2 = root2.next;
            }
            temp = temp.next;
        }
        while (root1 != null) {
            temp.next = root1;
            root1 = root1.next;
            temp = temp.next;
        }
        while (root2 != null) {
            temp.next = root2;
            root2 = root2.next;
            temp = temp.next;
        }

        return newNode.next;

    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = helper(head);
        return root;
    }

}

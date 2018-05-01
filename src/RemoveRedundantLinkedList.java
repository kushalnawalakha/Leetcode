import java.util.HashSet;

/**
 * Created by kusha on 3/28/2018.
 */
public class RemoveRedundantLinkedList {
    public static LinkedListNode distinct(LinkedListNode head) {
        LinkedListNode prev = null, itr = head;
        HashSet<Integer> set = new HashSet();
        while (itr != null) {
            if (set.add(itr.val)) {
                prev = itr;
                itr = itr.next;
            } else {
                itr = itr.next;
                prev.next = itr;
            }
        }
        return head;
    }

    public static boolean isTwins(String a, String b) {
        int odd[] = new int[26];
        int even[] = new int[26];
        boolean flag = true;
        for (int i = 0; i < a.length(); i++) {
            if (flag) {
                odd[a.charAt(i) - 'a']++;
                odd[b.charAt(i) - 'a']--;
            } else {
                even[a.charAt(i) - 'a']++;
                even[b.charAt(i) - 'a']++;
            }
            flag = !flag;
        }
        for (int i = 0; i < 26; i++) {
            if (odd[i] != 0 || even[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(1);
        LinkedListNode l2 = new LinkedListNode(1);
        LinkedListNode l3 = new LinkedListNode(2);
        LinkedListNode l4 = new LinkedListNode(1);
        LinkedListNode l5 = new LinkedListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        distinct(l1);
    }
}

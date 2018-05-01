package DataStructures;

/**
 * Created by kusha on 5/16/2017.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public static ListNode getList(int array[]){
        if(array.length==0){
            return null;
        }
        ListNode head=new ListNode(0);
        ListNode temp=head;
        for (int arr:array){
            temp.next=new ListNode(arr);
            temp=temp.next;
        }
        return head.next;
    }

    public static void print(ListNode temp){
        ListNode head=temp;
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public void print() {
        ListNode head = this;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}

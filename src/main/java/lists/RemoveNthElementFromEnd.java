package lists;

import java.util.ArrayList;
import java.util.List;

import static lists.DeleteNode.deleteNode;

public class RemoveNthElementFromEnd {
    public static void main(String[] args) {
        ListNode b = new ListNode(4);
       ListNode b2 = new ListNode(5);
        b.setNext(b2);
         ListNode b3 = new ListNode(4);
        b2.setNext(b3);

        ListNode a = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a.setNext(a2);
        ListNode a3 = new ListNode(3);
        a2.setNext(a3);
        ListNode a4 = new ListNode(4);
        a3.setNext(a4);
        ListNode a5 = new ListNode(5);
        a4.setNext(a5);
/*        ListNode a6 = new ListNode(6);
        a5.setNext(a6);
        ListNode a7 = new ListNode(7);
        a6.setNext(a7);
        ListNode a8 = new ListNode(8);
        a7.setNext(a8);
        ListNode a9 = new ListNode(9);
        a8.setNext(a9);
*/
        System.out.println(b.print());
        b = removeNthFromEnd(b, 1);
        if(b!=null) {
            System.out.println(b.print());
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //traverse listnodes and record positions
        ListNode current = head;
        List<ListNode> cache = new ArrayList<ListNode>();
        while(current!=null) {
            ListNode tmp = current;
            cache.add(tmp);
            current = tmp.next;
        }

        // if exist - delete nth element
        current = head;
        ListNode prev = null;
        int pos = 0;
        if(cache.size()>=n) {
            while(cache.size()-n-1>=0 && !(current.val==cache.get(cache.size()-n).val && pos==cache.size()-n)) {
                prev = current;
                current = current.next;
                pos++;
            }
            if(current.next!=null) {
                current.val = current.next.val;
                current.next = current.next.next;
            } else if(cache.size()==1){
                head = null;
            } else if (current.next==null) {
                prev.next = null;
            }
        }
        // return list
        return head;
    }
}

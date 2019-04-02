package lists;

public class ReverseListNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a3 = new ListNode(3);
        a.setNext(a3);
        ListNode a5 = new ListNode(5);
        a3.setNext(a5);
        ListNode a7 = new ListNode(7);
        a5.setNext(a7);

        ListNode m = reverse2(a);
        System.out.println(m.print());

        a = new ListNode(1);
        a3 = new ListNode(3);
        a.setNext(a3);
        a5 = new ListNode(5);
        a3.setNext(a5);
        a7 = new ListNode(7);
        a5.setNext(a7);

        m = reverse1(a);
        System.out.println(m.print());

        a = new ListNode(1);
        a3 = new ListNode(3);
        a.setNext(a3);
        a5 = new ListNode(5);
        a3.setNext(a5);
        a7 = new ListNode(7);
        a5.setNext(a7);

        m = reverseListRecursive(a);
        System.out.println(m.print());
    }

    public static ListNode reverse1(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static ListNode reverse2(ListNode a) {
        if(a==null) return a;

        ListNode reverse = new ListNode(0);
        ListNode clone = a;

        while(clone.getNext()!=null) {
            ListNode tmp = clone;
            while(clone.getNext().hasNext()) {
                clone = clone.getNext();
            }
            ListNode last = clone.getNext();
            clone.setNext(null);
            ListNode add = reverse;
            while (add.hasNext()) {
                add = add.getNext();
            }
            add.setNext(last);
            clone = tmp;
        }

        if(clone.hasNext()) {
            ListNode add = reverse;
            while (add.hasNext()) {
                add = add.getNext();
            }
            add.setNext(clone.getNext());
        }

        ListNode add = reverse;
        while (add.hasNext()) {
            add = add.getNext();
        }
        add.setNext(clone);

        return reverse.getNext();
    }

}

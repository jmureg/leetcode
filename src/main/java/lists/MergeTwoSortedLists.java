package lists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a3 = new ListNode(3);
        a.setNext(a3);
        ListNode a5 = new ListNode(5);
        a3.setNext(a5);
        ListNode a7 = new ListNode(7);
        a5.setNext(a7);

        ListNode b = new ListNode(2);
        ListNode b4 = new ListNode(4);
        b.setNext(b4);
        ListNode b5 = new ListNode(5);
        b4.setNext(b5);
        ListNode b8 = new ListNode(8);
        b5.setNext(b8);
        ListNode b10 = new ListNode(10);
        b8.setNext(b10);

        ListNode m = mergeTwoSortedLists(a, b);
        System.out.println(m.print());
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;
        if (list1.getValue() < list2.getValue()) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }
        while (list1.getNext() != null) {
            if (list1.getNext().getValue() > list2.getValue()) {
                ListNode tmp = list1.getNext();
                list1.setNext(list2);
                list2 = tmp;
            }
            list1 = list1.getNext();
        }
        list1.setNext(list2);
        return head;
    }
}

package lists;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getValue() {
        return this.val;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    void setNext(ListNode n) {
        this.next = n;
    }

    public ListNode getNext() {
        return this.next;
    }

    public String print() {
        ListNode l = this;
        StringBuffer sb = new StringBuffer();
        if (l != null) {
            sb.append(l.getValue());
            while (l.hasNext()) {
                sb.append("->" + l.getNext().getValue());
                l = l.getNext();
            }
        }

        return sb.toString();
    }

    public void addLast(int a) {
        ListNode tmp = this;
        while (tmp.hasNext()) {
            tmp = tmp.getNext();
        }
        tmp.setNext(new ListNode(a));
        System.out.println("added: " + a);
    }

    public void addLast(ListNode a) {
        ListNode tmp = this;
        while (tmp.hasNext()) {
            tmp = tmp.getNext();
        }
        tmp.setNext(a);
        System.out.println("added node: " + a);
    }
}

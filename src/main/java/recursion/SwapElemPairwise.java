package recursion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapElemPairwise {
    @Test
    public void test() {

        /*

         */
        assertEquals(new ListNode().create(new int[]{2, 1, 4, 3, 6, 5}).print(), swapPairs(new ListNode().create(new int[]{1, 2, 3, 4, 5, 6})).print());
        assertEquals(new ListNode().create(new int[]{2, 1, 4, 3}).print(), swapPairs(new ListNode().create(new int[]{1, 2, 3, 4})).print());
        assertEquals(new ListNode().create(new int[]{2, 1, 3}).print(), swapPairs(new ListNode().create(new int[]{1, 2, 3})).print());
        assertEquals(new ListNode().create(new int[]{2, 1}).print(), swapPairs(new ListNode().create(new int[]{1, 2})).print());
        assertEquals(new ListNode().create(new int[]{1}).print(), swapPairs(new ListNode().create(new int[]{1})).print());

    }


    public ListNode swapPairs(ListNode head) {
        //System.out.println(head.val);
        ListNode tmp = null;
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            tmp = head;
            head = head.next;
            head.next = tmp;
            head.next.next = null;
            return head;
        } else {
            tmp = head.next;
            head.next = head.next.next;
            tmp.next = head;
            //System.out.println("\t" + tmp.next.next.val);
            tmp.next.next = swapPairs(tmp.next.next);
        }
        return tmp;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode create(int[] nodes) {
            ListNode result = null;
            if (nodes == null) {
                return null;
            } else if (nodes.length == 1) {
                return new ListNode(nodes[0]);
            } else {
                result = new ListNode(nodes[0]);
                for (int n = 1; n < nodes.length; n++) {
                    ListNode current = result;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = new ListNode(nodes[n]);
                }
                return result;
            }
        }

        public String print() {
            StringBuffer sb = new StringBuffer();
            ListNode ln = this;
            while (ln.next != null) {
                sb.append(ln.val);
                ln = ln.next;
            }
            sb.append(ln.val);
            //System.out.println(sb.toString());
            return sb.toString();
        }
    }
}

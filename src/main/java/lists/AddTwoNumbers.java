package lists;

/*
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rln = null;
        ListNode current = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            //retrieve
            int l1v = 0;
            if (l1 != null) {
                l1v = l1.val;
            }
            int l2v = 0;
            if (l2 != null) {
                l2v = l2.val;
            }

            //calculate & create
            int result = l1v + l2v + carry;
            int tmp = result % 10;
            if (result >= 10) {
                carry = result / 10;
            } else {
                carry = 0;
            }
            ListNode ln = new ListNode(tmp);

            //append
            if (current == null) {
                rln = ln;
            } else if (current.next == null) {
                current.next = ln;
            } else if (current.next != null) {
                while (current != null && current.next != null) {
                    current = current.next;
                }
                current.next = ln;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            current = rln;
        }
        if (carry > 0) {
            while (current != null && current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(carry);
        }
        return rln;
    }
}

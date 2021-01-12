package lists;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode zero = new ListNode(0);
        two.next = zero;
        ListNode minusFour = new ListNode(-4);
        zero.next = minusFour;
        minusFour.next = two;

        LinkedListCycle llc = new LinkedListCycle();

        System.out.println("expect TRUE: " + llc.hasCycleIntuitive(head));
    }

    public boolean hasCycleIntuitive(ListNode head) {
        boolean flag;
        int pos = 0;
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> cache = new HashMap<>();

        ListNode currentNode = head;
        cache.put(currentNode, pos++);

        while (currentNode.next != null) {
            ListNode pointer = currentNode.next;
            if (cache.containsKey(pointer)) {
                return true;
            } else {
                cache.put(pointer, pos++);
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}
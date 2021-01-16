package lists;

/*
https://leetcode.com/problems/delete-node-in-a-linked-list/

Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.

 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a3 = new ListNode(3);
        a.setNext(a3);
        ListNode a5 = new ListNode(5);
        a3.setNext(a5);
        ListNode a7 = new ListNode(7);
        a5.setNext(a7);

        System.out.println(a.print());
        deleteNode(a7);
        System.out.println(a.print());
    }

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
        } else if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}

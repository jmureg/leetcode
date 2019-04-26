package lists;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode a = null;

        a = new ListNode(1);
        ListNode a3 = new ListNode(3);
        a.setNext(a3);
        ListNode a5 = new ListNode(5);
        a3.setNext(a5);
        ListNode a7 = new ListNode(7);
        a5.setNext(a7);

        System.out.println(a.print());
        System.out.println(isPalindrome(a));
        System.out.println();

        a = new ListNode(1);
        a3 = new ListNode(3);
        a.setNext(a3);
        a5 = new ListNode(3);
        a3.setNext(a5);
        a7 = new ListNode(1);
        a5.setNext(a7);

        System.out.println(a.print());
        System.out.println(isPalindrome(a));
        System.out.println();

        a = new ListNode(1);

        System.out.println(a.print());
        System.out.println(isPalindrome(a));
        System.out.println();

        a = null;

        System.out.println("empty: " + isPalindrome(a));
        System.out.println();

        a = new ListNode(1);
        a3 = new ListNode(3);
        a.setNext(a3);

        System.out.println(a.print());
        System.out.println(isPalindrome(a));
        System.out.println();


        a = new ListNode(-129);
        a3 = new ListNode(-129);
        a.setNext(a3);

        System.out.println(a.print());
        System.out.println(isPalindrome(a));
        System.out.println();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> cache = convertToList(head);
        return checkValidPalindrom(cache, 0, cache.size() - 1);
    }

    private static boolean checkValidPalindrom(List<Integer> cache, int left, int right) {
        if (left == right || (right - left == 1 && cache.get(left) == cache.get(right))) {
            return true;
        } else if (cache.get(left) == cache.get(right)) {
            if (right - left == 1) {
                return true;
            } else {
                return checkValidPalindrom(cache, ++left, --right);
            }
        }
        return false;
    }

    private static List<Integer> convertToList(ListNode head) {
        List<Integer> cache = new ArrayList<Integer>();
        ListNode current = head;

        while (current != null) {
            cache.add(current.val);
            current = current.next;
        }
        return cache;
    }
}

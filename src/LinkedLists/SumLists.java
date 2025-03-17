package LinkedLists;

/**
 * Problem description:
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are store in
 * reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and
 * return the sum as a linked list.
 * <p>
 * EXAMPLE:
 * Input: (7 → 1 → 6) + (5 → 9 → 2). That is 617 + 295
 * Output: 2 → 1 → 9. That is, 912
 * <p>
 * ANALYSIS:
 * I am given 2 linked list node, and they are in reverse order.
 * When adding them, I just need to worry about whether their sum >= 10.
 * I need to be careful when a number is shorter than the other num.
 * <p>
 * Time Complexity:
 * The first loop takes O(min(N, M)), where N is the number of nodes in num1 and M is the number of nodes in num2.
 * The second loops only execute when num1 length > num2 length, so it takes at most O(N).
 * Similarly, the third loops only execute when num2 length > num1 length, and it takes at most O(M).
 * Therefore, the overall time complexity is O(max(N, M)).
 * <p>
 * Space Complexity:
 * I need a new linked list to store their sum, so it cost O(max(N, M)) spaces.
 * <p>
 * FOLLOW UP
 * Suppose the digits are store in forward order.
 * EXAMPLE
 * Input: (6 → 1 → 7) + (2 → 9 → 5). That is, 617 + 295
 * Output: 9 → 1 → 2. That is, 912
 * <p>
 * ANALYSIS:
 * I can try to convert both nums back to int and then add it to a linked list, but I may encounter a number that
 * exceeds 2³¹ - 1. Therefore, it is not an optimal approach.
 * I can try to reverse the linked list num1 and num2, and then apply the method that I created before to calculate
 * their sum. Finally, reverse one more time before returning result.
 *
 * Time Complexity:
 * reverse method takes O(max(N, M)), where N is the number of nodes in num1 and M is the number of nodes in num2.
 * sum method takes O(max(N, M)) (proved above).
 * Therefore, total time complexity is O(max(N, M))
 *
 * Space Complexity
 * Reverse returns new linked list, so it costs extra space O(max(N, M)).
 * sum method takes O(max(N, M)).
 * Therefore, total space consumption is O(max(N, M))
 *
 */

public class SumLists {

    public Node sumForward(Node num1, Node num2) {
        Node reverseNum1 = reverseLinkedList(num1);
        Node reverseNum2 = reverseLinkedList(num2);
        Node result = sum(reverseNum1, reverseNum2);
        result = reverseLinkedList(result);
        return result;
    }

    public Node sum(Node num1, Node num2) {
        Node result = new Node(0);
        Node iterator = result;
        int carry = 0;

        while (num1 != null && num2 != null) {
            if (num1.val + num2.val + carry < 10) {
                iterator.val = num1.val + num2.val + carry;
                carry = 0;
            } else {
                iterator.val = (num1.val + num2.val + carry) % 10;
                carry = 1;
            }

            num1 = num1.next;
            num2 = num2.next;
            if (num1 != null || num2 != null) {
                iterator.next = new Node(0);
                iterator = iterator.next;
            }
        }

        while (num1 != null) {
            if (num1.val + carry < 10) {
                iterator.val = num1.val + carry;
                carry = 0;
            } else {
                iterator.val = (num1.val + carry) % 10;
                carry = 1;
            }

            num1 = num1.next;
            if (num1 != null) {
                iterator.next = new Node(0);
                iterator = iterator.next;
            }
        }

        while (num2 != null) {
            if (num2.val + carry < 10) {
                iterator.val = num2.val + carry;
                carry = 0;
            } else {
                iterator.val = (num2.val + carry) % 10;
                carry = 1;
            }
            num2 = num2.next;
            if (num2 != null) {
                iterator.next = new Node(0);
                iterator = iterator.next;
            }
        }

        if (carry == 1) {
            iterator.next = new Node(1);
        }

        return result;
    }

    private Node reverseLinkedList(Node head) {
        Node reverse = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = reverse;
            reverse = head;
            head = tmp;
        }

        return reverse;
    }
}

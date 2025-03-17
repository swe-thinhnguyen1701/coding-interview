package LinkedLists;

/**
 * Problem description:
 * Implement a function to check if a linked list is a palindrome
 * <p>
 * ANALYSIS
 * To determine if a linked list is a palindrome, the first half of the list must be identical to the second half.
 * If I can reverse the first half of the list, I can compare it with the second half to check for equality.
 * To obtain the first half in reverse order, I need two pointers: one fast and one slow.
 * As the slow pointer moves, I will update a list to store the reversed first half. When the fast pointer reaches the
 * end of the list, the slow pointer will stop at the midpoint.
 * In the final step, I move the slow pointer to the end of the list while comparing values from the reversed first half.
 * If the values are different at any point, return false.
 *
 * Time Complexity
 * The first loop iterates through the list once, and since it only processes the first half of the list, it takes
 * O(N/2) time.
 * Building the reversed list involves constant-time operations (inserting a node at the front), so the time complexity
 * for building the reversed list is O(1) for each operation. Over the first half of the list, this becomes O(N/2).
 * The second loop iterates through the second half of the list, comparing it with the reversed first half. This takes
 * O(N/2) time.
 * Therefore, the total time complexity is O(N/2 + N/2) = O(N).
 *
 * Space Complexity:
 * Since the reversed list takes extra space proportional to the number of nodes in the first half, the space complexity
 * is O(N/2).
 * This can be simplified to O(N), since constant factors are dropped in Big-O notation.
 *
 */

public class Palindrome {
    public boolean isPalindrome(Node head) {
        Node firstHalf = null;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            Node tmp = new Node(slow.val);
            tmp.next = firstHalf;
            firstHalf = tmp;
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null && firstHalf != null) {
            if (slow.val != firstHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            slow = slow.next;

        }

        return true;
    }
}

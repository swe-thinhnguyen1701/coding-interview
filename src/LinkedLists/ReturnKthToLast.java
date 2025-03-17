package LinkedLists;

/**
 * Problem description:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * EXAMPLE:
 * input: 1 → 2 → 3 → 4 → 5 → null, k = 2
 * output: 4
 *
 * ANALYSIS:
 * If I have two pointers and maintain a difference of k between them, I can find the k-th to last node in a linked list.
 *  left/right
 *     ↓
 *     1  →  2  →  3  →  4  →  5  →  null
 *
 * Move right pointer k steps ahead
 *   left        right
 *     ↓           ↓
 *     1  →  2  →  3  →  4  →  5  →  null
 *
 *  When the right pointer reaches the end, the left pointer will be at the k-th to last node (in this case, node with
 *  value 4). However, this approach may occur an error when k > the size of a linked list. Let's consider k = 6.
 *
 * Move right to k units
 *   left                            right
 *     ↓                              ↓
 *     1  →  2  →  3  →  4  →  5  →  null
 * When right pointer reaches the end of the linked list, but k does not reach 0 yet. Therefore, the method should
 * return -1 or throw an error.
 * Suppose value from [0, 2³¹ - 1]
 *
 * Time complexity:
 * Iterate through the linked list takes O(N), where N is the number of nodes
 *
 * Space complexity:
 * I do not use extra space, so it remains O(1).
 */

public class ReturnKthToLast {

    public int getValAt(Node head, int k) {
        Node left = head;
        Node right = head;

        while(right != null && k != 0) {
            right = right.next;
            k--;
        }

        if(k == 0)
            return -1;

        while(right != null) {
            right = right.next;
            left = left.next;
        }

        return left.val;
    }
}

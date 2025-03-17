package LinkedLists;

/**
 * Problem description:
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
 * than or equal to x. (IMPORTANT: The partition element x can appear anywhere in the "right partition"; it does not
 * need to appear between left and right partitions).
 *
 * EXAMPLE:
 * 3 → 5 → 8 → 5 → 10 → 2 → 1 (partition = 5)
 * 3 → 2 → 1 → 5 → 8 → 5 → 10
 *
 * ANALYSIS:
 * Initially, I need an iterator to iterate through the linked list.
 * In the first loop, I need to locate where is the last node (left) has a value smaller than partition. This can help
 * in determining where the smaller values should be inserted.
 * In the second loop, I will traverse the remaining list and whenever I find a value smaller than partition, I will
 * move that node right after left while maintaining list integrity.
 *
 * Time Complexity:
 * The total time complexity of both loops is O(N).
 * The first loop takes at most O(N) time to locate that last node that has a value smaller than partition.
 * The second loops only execute if and only if the iterator does not point to null. Even if the second loop executes,
 * it still iterates through at most O(N) nodes, making the overall complexity O(N).
 * The update association between nodes remains constant time O(1).
 * Therefore, total time complexity is O(N).
 *
 * Space complexity:
 * I do not use any extra space, so it remains O(1).
 */

public class Partition {
    public Node partition(Node head, int partition) {
        Node iterator = head;
        Node left = null;

        while (iterator != null && iterator.val < partition) {
            left = iterator;
            iterator = iterator.next;
        }

        while (iterator != null && iterator.next != null) {
            if (iterator.next.val < partition) {
                if (left == null) {
                    left = iterator.next;
                    iterator.next = iterator.next.next;
                    left.next = head;
                    head = left;
                } else {
                    Node tmp = left.next;
                    left.next = iterator.next;
                    iterator.next = iterator.next.next;
                    left = left.next;
                    left.next = tmp;
                }
            } else {
                iterator = iterator.next;
            }
        }

        return head;
    }
}

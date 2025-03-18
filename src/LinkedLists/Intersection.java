package LinkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem description:
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
 * intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact
 * same node (by reference) as the jth node of the second linked list, then they are intersecting.
 * <p>
 * ANALYSIS:
 * CASE 1: Use extra space
 * I will use a set to keep track. A node is considered as an intersecting node if it exists in the set.
 *
 * Time Complexity:
 * First loop (storing nodes of head1 in a set):
 * You iterate through head1 and insert each node into a set.
 * This takes O(N) time, where N is the number of nodes in head1.
 *
 * Second loop (checking nodes of head2 in the set):
 * You iterate through head2 and check if any node exists in the set.
 * This takes O(M) time, where M is the number of nodes in head2.
 *
 * Therefore, total time complexity is O(max(N, M)).
 *
 * Space Complexity:
 * Since I use set to store node, so it cost O(max(N, M)) space.
 *
 * CASE 2: NO extra space.
 * I will use 2 pointers to find the intersecting node.
 * When either iterator1 or iterator2 reaches the end of a list, I will set it to the other head.
 *
 * - head1 length = head2 length
 * iterator1 (i1)
 *     ↓
 *     1 → 2
 *           ↘
 *             3   →  4  →  null
 *           ↗
 *          5
 *          ↑
 *      iterator2 (i2)
 *
 *         i1
 *         ↓
 *     1 → 2
 *           ↘
 *             3  →  4  →  null
 *           ↗ ↑
 *         5   i2
 *
 *
 *     1 → 2   i1
 *           ↘ ↓
 *             3  →  4  →  null
 *           ↗       ↑
 *        5          i2
 *
 *
 *      1 → 2         i1
 *            ↘        ↓
 *              3   →  4  →  null
 *            ↗                ↑
 *          5                 i2
 *
 * Since i2 reach the end of list head2, so I set i2 point to the other list which is head1
 *
 *          i2
 *          ↓
 *      1 → 2                i1
 *            ↘               ↓
 *              3   →  4  →  null
 *            ↗
 *          5
 *
 *
 *           i2
 *           ↓
 *       1 → 2
 *             ↘
 *               3   →  4  →  null
 *             ↗
 *            5
 *            ↑
 *           i1
 *
 *
 *
 *       1 → 2   i2
 *             ↘ ↓
 *               3   →  4  →  null
 *             ↗ ↑
 *            5  i1
 *
 * Now both i1 and i2 point to the same Node, return either i1 or i2.
 *
 * Time Complexity:
 * The iteration through 2 linked list takes upto O(N + M), where N is the number of nodes in head1, and M is the number
 * of nodes in head2.
 *
 * Space Complexity:
 * There is no extra space used when finding the intersecting node, so it remains O(1).
 *
 */

public class Intersection {

    public Node findIntersectioiterator2(Node head1, Node head2) {
        Node iterator1 = head1;
        Node iterator2 = head2;

        while(iterator1 != iterator2) {
            iterator1 = iterator1 == null ? head2 : iterator1.next;
            iterator2 = iterator2 == null ? head1 : iterator2.next;
        }

        return iterator1;
    }

    public Node findIntersection(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if(set.contains(head2))
                return head2;

            head2 = head2.next;
        }

        return null;
    }
}

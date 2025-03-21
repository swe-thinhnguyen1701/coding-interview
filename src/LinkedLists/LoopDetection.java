package LinkedLists;

/**
 * Problem description:
 * Given a linked list which might contain a loop, implement an algorithm that returns the node at the beginning of the
 * loop (if one exists)
 *
 * ANALYSIS:
 * I can implement 2 pointer, one fast and one slow.
 * However, this technique does not guarantee that they will meet at the beginning of the loop. I use a hint to visualize
 * 9 nodes 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → ?, where "?" is a node that I want to make a loop.
 * Suppose:
 *      fast (f), slow (s)
 *              ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *
 *                      s       f
 *                      ↓       ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *
 *                              s
 *                              ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5   ←  f
 *
 *
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4   ←  s
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *              ↑
 *              f
 *
 *      f
 *      ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5   ←  s
 *
 *
 *                      f
 *                      ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *                      ↑
 *                      s
 *
 *
 *
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4  ← f
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *              ↑
 *              s
 *
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *        ↗   ↖                 ↓
 *      s       7   ←   6   ←   5
 *                      ↑
 *                      f
 *
 *      9   →   1   →   2   →   3
 *    ↗   ↖                     ↓
 *  s       8                   4
 *        ↗   ↖                 ↓
 *      f       7   ←   6   ←   5
 *
 *
 *             f,s
 *              ↓
 *      9   →   1   →   2   →   3
 *        ↖                     ↓
 *          8                   4
 *            ↖                 ↓
 *              7   ←   6   ←   5
 *
 * When the loop starts at 1, both slow and fast pointer meets at 1.
 *
 * Let try loop start at 2, but this time I will skip steps and display result only
 *
 *      fast (f), slow (s)
 *              ↓
 *              1   →   2   →   3   →   4                   1   →   2   →   3   →   4
 *                      ↑               ↓                           ↑               ↓
 *                      9               5     ---→           f,s →  9               5
 *                      ↑               ↓                           ↑               ↓
 *                      8   ←   7   ←   6                           8   ←   7   ←   6
 * When the loop starts at 2, they meet at a node one that has 1 step away from the beginning of the loop.
 * This distance is similar as from 1 to 2.
 *
 * Let try loop start at 3
 *
 *      fast (f), slow (s)
 *              ↓
 *              1   →   2   →   3   →   4                      1   →   2   →   3   →   4
 *                          ↗             ↘                                ↗             ↘
 *                       9                  5      ---→                  9                 5
 *                       ↑                 ↙                             ↑                ↙
 *                       8   ←   7   ←   6                       f,s  →  8   ←   7   ←   6
 * When the loop starts at 2, they meet at a node one that has 2 steps away from the beginning of the loop.
 * Similarly, the distance between 8 and 3 is equal to from 1 to 3.
 *
 * Therefore, when they first meet some where in a loop, I just need to move either fast or slow back to the head and let
 * them run 1 step at a time. It'll be guarantee that they will meet at the beginning of the loop.
 *
 * If a linked list does not have a loop, fast pointer will reach at null or .next = null.
 *
 * Time Complexity:
 * The first iteration will take O(N), where N is the number of nodes.
 * The second iteration takes O(M), where M is a distance from head to the beginning of the loop.
 * Therefore, total time complexity is O(N + M) = O(N) (Since M <= N)
 *
 * Space Complexity:
 * I don't use extra space, so it remains O(1).
 */

public class LoopDetection {
    public Node findLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
